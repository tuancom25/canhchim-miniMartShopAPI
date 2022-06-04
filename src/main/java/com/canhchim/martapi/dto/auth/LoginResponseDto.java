package com.canhchim.martapi.dto.auth;

import lombok.Data;

@Data
public class LoginResponseDto {
    private String accessToken;
    private String tokenType = "Bearer";
    private UserLoginResponseDto user;
}
