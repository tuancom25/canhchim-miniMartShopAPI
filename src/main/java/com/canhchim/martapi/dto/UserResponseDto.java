package com.canhchim.martapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserResponseDto {
    private Integer id;
    private String username;
    private String fullname;
    private String phone;
    private String email;
    private String cccd;
    private String address;
    private RSADto rsa;
    private String ipLastWork;
    private List<String> functions;
}
