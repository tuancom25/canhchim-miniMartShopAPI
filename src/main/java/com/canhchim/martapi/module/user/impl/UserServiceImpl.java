/**
 * @Author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.user.impl;

import com.canhchim.martapi.dto.UserDetailDto;
import com.canhchim.martapi.dto.UserRequestDto;
import com.canhchim.martapi.dto.UserResponseDto;
import com.canhchim.martapi.entity.User;
import com.canhchim.martapi.module.role.IFunctionAndRoleRepository;
import com.canhchim.martapi.module.role.IFunctionAndRoleService;
import com.canhchim.martapi.module.user.IRoleOfUserService;
import com.canhchim.martapi.module.user.IUserRepository;
import com.canhchim.martapi.module.user.IUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;
    private final IRoleOfUserService roleOfUserService;
    private final IFunctionAndRoleService functionAndRoleService;

    public UserServiceImpl(IUserRepository userRepository, IRoleOfUserService roleOfUserService, IFunctionAndRoleService functionAndRoleService) {
        this.userRepository = userRepository;
        this.roleOfUserService = roleOfUserService;
        this.functionAndRoleService = functionAndRoleService;
    }
    @Override
    public User findByUsernameLike(String username) {
        return userRepository.findByUsernameLike(username);
    }


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findAll(Sort sort) {
        return userRepository.findAll(sort);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Page<User> findAll(Pageable pageable, Sort sort) {
        return null;
    }

    @Override
    public Page<User> findAll(String search, String searchField, Pageable pageable, Sort sort) {
        return null;
    }

    @Override
    public User findById(Integer id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("User có Id=%d không tồn tại!", id)));
    }

    @Override
    public void deleteById(int id) throws EntityNotFoundException{
        try {
            userRepository.deleteById(id);
        }
        catch (EntityNotFoundException exception) {
            System.err.println(exception);
            throw new EntityNotFoundException(String.format("User có Id=%d không tồn tại!", id));
        }
    }

    @Override
    public UserDetailDto findUserDetailByUsernameLike(String username){
        User user = userRepository.findByUsernameLike(username);
        List<Integer> roles = roleOfUserService.findRoleIdsByUser_id(user.getId());
        List<String> functions = new ArrayList<>();

        for (Integer roleId: roles) {
            for (String function: functionAndRoleService.findFunction_IdByRole_Id(roleId)) functions.add(function);
        }

        UserDetailDto userDetailDto = new UserDetailDto();
        userDetailDto.setUsername(user.getUsername());
        userDetailDto.setUserPassword(user.getUserPassword());
        userDetailDto.setFunctions(functions);
        return userDetailDto;
    }

    @Override
    public UserResponseDto create(UserRequestDto userRequestDto) throws IOException {
        if(userRepository.existsById(userRequestDto.getId())) {
            User user = new User();
            String salt = generateSalt();
            String password = hashPassword(userRequestDto.getUserPassword(), salt);

            user.setUsername(userRequestDto.getUsername());
            user.setUserFullName(userRequestDto.getUserFullName());
            user.setUserPassword(password);
            user.setUserPasswordSalt(salt);
            user.setUserPhone(userRequestDto.getUserPhone());
            user.setUserEmail(userRequestDto.getUserEmail());
            user.setUserCCCD(userRequestDto.getUserCCCD());
            user.setUserAddress(userRequestDto.getUserAddress());
            User saveUser = userRepository.saveAndFlush(user);

            UserResponseDto userResponseDto = new UserResponseDto();
            userResponseDto.setId(saveUser.getId());
            userResponseDto.setUsername(saveUser.getUsername());
            userResponseDto.setFullname(saveUser.getUserFullName());
            userResponseDto.setPhone(saveUser.getUserPhone());
            userResponseDto.setEmail(saveUser.getUserEmail());
            userResponseDto.setCccd(saveUser.getUserCCCD());
            userResponseDto.setAddress(saveUser.getUserAddress());
            userResponseDto.setRsa(null);
            userResponseDto.setIpLastWork(null);
            userResponseDto.setFunctions(null);
            return userResponseDto;
        }
        else throw new IOException("Username đã tồn tại!");
    }

    private String generateSalt() {
        byte[] array = new byte[12]; // length is bounded by 7
        new Random().nextBytes(array);
        String salt = new String(array, Charset.forName("UTF-8"));
        return salt;
    }

    private String hashPassword(String password, String salt) {
        return DigestUtils.sha256Hex(password + salt);
    }
}
