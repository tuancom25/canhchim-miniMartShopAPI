package com.canhchim.martapi.module.auth;

import com.canhchim.martapi.dto.LoginResponseDto;

public interface IAuthService {
    LoginResponseDto loginAdmin(String username, String password) throws Exception;

    LoginResponseDto loginUser(String username, String password) throws Exception;
}
