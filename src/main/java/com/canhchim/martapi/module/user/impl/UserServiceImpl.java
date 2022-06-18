/**
 * @author Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.user.impl;

import com.canhchim.martapi.dto.RSADto;
import com.canhchim.martapi.dto.user.UserDetailDto;
import com.canhchim.martapi.dto.user.UserRequestDto;
import com.canhchim.martapi.dto.user.UserResponseDto;
import com.canhchim.martapi.entity.User;
import com.canhchim.martapi.module.role.IRelUsersFunctionService;
import com.canhchim.martapi.module.user.IUserRepository;
import com.canhchim.martapi.module.user.IUserService;
import com.canhchim.martapi.util.HashUtil;
import com.canhchim.martapi.util.RsaUtil;
import com.canhchim.martapi.util.SaltUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;
    private final IRelUsersFunctionService relUsersFunctionService;

    public UserServiceImpl(IUserRepository userRepository, IRelUsersFunctionService relUsersFunctionService) {
        this.userRepository = userRepository;
        this.relUsersFunctionService = relUsersFunctionService;
    }
    @Override
    public User findByUsernameLike(String username) throws Exception {
        User user = userRepository.findByUsernameLike(username);
        if (!user.getActived()) throw new Exception("Tài khoản của bạn đã bị khóa!");
        return user;
    }


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("User có Id=%d không tồn tại!", id)));
    }

    @Override
    public void deleteById(int id) throws EntityNotFoundException {
        try {
            userRepository.deleteById(id);
        }
        catch (EntityNotFoundException exception) {
            System.err.println(exception);
            throw new EntityNotFoundException(String.format("User có Id=%d không tồn tại!", id));
        }
    }

    @Override
    public UserDetailDto findUserDetailByUsernameLike(String username) throws IOException {
        User user = userRepository.findByUsernameLike(username);
        if(!user.getActived()) throw new IOException("Tài khoản của bạn đã bị khóa!");
        List<String> functions = new ArrayList<>();

        for (String function: relUsersFunctionService.findFunctionNamesByUser_Id(user.getId())) functions.add(function);

        UserDetailDto userDetailDto = new UserDetailDto();
        userDetailDto.setUsername(user.getUsername());
        userDetailDto.setPassword(user.getPassword());
        userDetailDto.setFunctions(functions);
        return userDetailDto;
    }

    @Override
    public UserResponseDto create(UserRequestDto userRequestDto) throws IOException, NoSuchAlgorithmException {
        if(userRepository.existsById(userRequestDto.getId())) {
            User user = new User();
            String salt = SaltUtil.generate(12);
            String password = HashUtil.sha256(userRequestDto.getPassword() + salt);
            RSADto rsaDto = RsaUtil.generate();

            user.setUsername(userRequestDto.getUsername());
            user.setFullname(userRequestDto.getFullName());
            user.setPassword(password);
            user.setSalt(salt);
            user.setPhone(userRequestDto.getPhone());
            user.setEmail(userRequestDto.getEmail());
            user.setCccd(userRequestDto.getCccd());
            user.setAddress(userRequestDto.getAddress());
            user.setPublicKey(rsaDto.getPublicKey());
            user.setPrivateKey(rsaDto.getPrivateKey());
            User saveUser = userRepository.saveAndFlush(user);

            UserResponseDto userResponseDto = new UserResponseDto();
            userResponseDto.setId(saveUser.getId());
            userResponseDto.setUsername(saveUser.getUsername());
            userResponseDto.setFullname(saveUser.getFullname());
            userResponseDto.setPhone(saveUser.getPhone());
            userResponseDto.setEmail(saveUser.getEmail());
            userResponseDto.setCccd(saveUser.getCccd());
            userResponseDto.setAddress(saveUser.getAddress());
            userResponseDto.setPublicKey(rsaDto.getPublicKey());
            userResponseDto.setIpLastWork(null);
//            userResponseDto.setFunctions(null);
            return userResponseDto;
        }
        else throw new IOException("Username đã tồn tại!");
    }

    @Override
    public void ban(String username) {
        User user = userRepository.findByUsernameLike(username);
        user.setActived(false);
        userRepository.saveAndFlush(user);
    }
}
