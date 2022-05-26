package com.canhchim.martapi.module.auth;

import com.canhchim.martapi.dto.LoginResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface IAuthService {
    LoginResponseDto loginAdmin(String username, String password) throws Exception;

    LoginResponseDto loginUser(String username, String password) throws Exception;
}
