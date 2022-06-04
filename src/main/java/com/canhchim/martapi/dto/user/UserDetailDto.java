package com.canhchim.martapi.dto.user;

import lombok.Data;

import java.util.List;

@Data
public class UserDetailDto {
    private String username;
    private String password;
    private List<String> functions;
}
