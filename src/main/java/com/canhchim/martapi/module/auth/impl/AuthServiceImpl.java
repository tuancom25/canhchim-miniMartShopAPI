package com.canhchim.martapi.module.auth.impl;

import com.canhchim.martapi.dto.auth.LoginResponseDto;
import com.canhchim.martapi.dto.RSADto;
import com.canhchim.martapi.dto.auth.UserLoginResponseDto;
import com.canhchim.martapi.entity.Admin;
import com.canhchim.martapi.entity.User;
import com.canhchim.martapi.module.admin.IAdminService;
import com.canhchim.martapi.module.auth.IAuthService;
import com.canhchim.martapi.module.role.IRelFunctionsRoleService;
import com.canhchim.martapi.module.user.IRelUsersRoleService;
import com.canhchim.martapi.module.user.IUserService;
import com.canhchim.martapi.util.JwtUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AuthServiceImpl implements IAuthService {
    private JwtUtil jwtUtil;
    private IAdminService adminService;

    private IUserService userService;
    private IRelUsersRoleService roleOfUserService;
    private IRelFunctionsRoleService relFunctionsRoleService;

    public AuthServiceImpl(JwtUtil jwtUtil, IAdminService adminService, IUserService userService, IRelUsersRoleService roleOfUserService, IRelFunctionsRoleService relFunctionsRoleService) {
        this.jwtUtil = jwtUtil;
        this.adminService = adminService;
        this.userService = userService;
        this.roleOfUserService = roleOfUserService;
        this.relFunctionsRoleService = relFunctionsRoleService;
    }

    @Override
    public LoginResponseDto loginAdmin(String username, String password) throws Exception {
        LoginResponseDto loginResponseDto = new LoginResponseDto();

        Admin admin = adminService.findByAdminNameLike(username);
        String salt = admin.getSalt();
        if (admin.getPassword().equals(hashPassword(password, salt))) {
            //Login success
            String accessToken = jwtUtil.generateToken(username, "ADMIN", 0);
            loginResponseDto.setAccessToken(accessToken);
            return loginResponseDto;
        }
        throw new Exception();
    }

    @Override
    public LoginResponseDto loginUser(String username, String password) throws Exception {
        //Tìm User
        User user = userService.findByUsernameLike(username);
        System.out.println(user);
        //Kiểm tra user có tồn tại trong DB?
        if (user == null) throw new Exception("Tài khoản hoặc mật khẩu không chính xác!");
        String salt = user.getSalt();
        if (user.getPassword().equals(hashPassword(password, salt))) {
            //Login success
            LoginResponseDto loginResponseDto = new LoginResponseDto();
            UserLoginResponseDto userLoginResponseDto = new UserLoginResponseDto();
            RSADto rsaDto = new RSADto();
            List<Integer> roles = roleOfUserService.findRoleIdsByUser_id(user.getId());
            List<String> functions = new ArrayList<>();

            for (Integer roleId: roles) {
                for (String function: relFunctionsRoleService.findFunction_IdByRole_Id(roleId)) functions.add(function);
            }

            userLoginResponseDto.setId(user.getId());
            userLoginResponseDto.setUsername(user.getUsername());
            userLoginResponseDto.setFullname(user.getFullname());
            userLoginResponseDto.setPhone(user.getPhone());
            userLoginResponseDto.setEmail(user.getEmail());
            userLoginResponseDto.setCccd(user.getCccd());
            userLoginResponseDto.setAddress(user.getAddress());
            userLoginResponseDto.setPublicKey(user.getPublicKey());
            userLoginResponseDto.setIpLastWork(user.getIpLastWork());
            userLoginResponseDto.setFunctions(functions);

            String accessToken = jwtUtil.generateToken(username, "SHOP", user.getShop().getId());
            loginResponseDto.setUser(userLoginResponseDto);
            loginResponseDto.setAccessToken(accessToken);

            return loginResponseDto;
        }
        throw new Exception("Tài khoản hoặc mật khẩu không chính xác!");
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
