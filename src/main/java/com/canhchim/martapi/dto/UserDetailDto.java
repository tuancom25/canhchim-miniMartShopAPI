package com.canhchim.martapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDetailDto {
    private String username;
    private String userPassword;
    private List<String> functions;
}
