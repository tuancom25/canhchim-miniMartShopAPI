package com.canhchim.martapi.dto;

import lombok.Data;

@Data
public class UserRequestDto {
    private int id;
    private String username;
    private String userFullName;
    private String userPassword;
    private String userPhone;
    private String userEmail;
    private String userCCCD;
    private String userAddress;
}
