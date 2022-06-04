package com.canhchim.martapi.dto.user;

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
    private String publicKey;
    private String ipLastWork;
}
