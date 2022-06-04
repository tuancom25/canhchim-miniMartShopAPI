package com.canhchim.martapi.dto.user;

import lombok.Data;

@Data
public class UserRequestDto {
    private int id;
    private String username;
    private String fullName;
    private String password;
    private String phone;
    private String email;
    private String cccd;
    private String address;
}
