package com.canhchim.martapi.module.auth.impl;

import com.canhchim.martapi.dto.LoginResponseDto;
import com.canhchim.martapi.entity.Admin;
import com.canhchim.martapi.entity.User;
import com.canhchim.martapi.module.admin.IAdminService;
import com.canhchim.martapi.module.auth.IAuthService;
import com.canhchim.martapi.module.user.IUserService;
import com.canhchim.martapi.util.JwtUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.Random;

@Service
public class AuthServiceImpl implements IAuthService {
    private JwtUtil jwtUtil;
    private IAdminService adminService;

    private IUserService userService;

    public AuthServiceImpl(JwtUtil jwtUtil, IAdminService adminService, IUserService userService) {
        this.jwtUtil = jwtUtil;
        this.adminService = adminService;
        this.userService = userService;
    }

    @Override
    public LoginResponseDto loginAdmin(String username, String password) throws Exception {
        LoginResponseDto loginResponseDto = new LoginResponseDto();

        Admin admin = adminService.findByAdminNameLike(username);
        String salt = admin.getAdminPassswordSalt();
        if (admin.getAdminPassword().equals(hashPassword(password, salt))) {
            //Login success
            String accessToken = jwtUtil.generateToken(username, "ADMIN");
            loginResponseDto.setAccessToken(accessToken);
            return loginResponseDto;
        }
        throw new Exception();
    }

    @Override
    public LoginResponseDto loginUser(String username, String password) throws Exception {
        LoginResponseDto loginResponseDto = new LoginResponseDto();

        User user = userService.findByUsernameLike(username);
        String salt = user.getUserPasswordSalt();
        if (user.getUserPassword().equals(hashPassword(password, salt))) {
            //Login success
            String accessToken = jwtUtil.generateToken(username, "USER");
            loginResponseDto.setAccessToken(accessToken);
            return loginResponseDto;
        }
        throw new Exception();
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
