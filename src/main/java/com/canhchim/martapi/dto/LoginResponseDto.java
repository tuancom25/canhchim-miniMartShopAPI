package com.canhchim.martapi.dto;

import lombok.Data;

@Data
public class LoginResponseDto {
    private String accessToken;
    private String tokenType = "Bearer";
    private UserResponseDto user;
}
