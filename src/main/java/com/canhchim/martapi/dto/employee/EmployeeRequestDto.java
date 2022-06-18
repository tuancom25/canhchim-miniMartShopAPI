package com.canhchim.martapi.dto.employee;

import lombok.Data;

@Data
public class EmployeeRequestDto {
    private int id;
    private String username;
    private String fullName;
    private String password;
    private String phone;
    private String email;
    private String cccd;
    private String address;
}
