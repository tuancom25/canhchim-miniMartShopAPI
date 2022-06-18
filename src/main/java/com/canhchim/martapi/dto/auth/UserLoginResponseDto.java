package com.canhchim.martapi.dto.auth;

import com.canhchim.martapi.entity.Employee;
import com.canhchim.martapi.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class UserLoginResponseDto {
    private Long id;
    private String username;
    private String fullname;
    private String phone;
    private String email;
    private String cccd;
    private String address;
    private String publicKey;
    private String ipLastWork;
    private List<String> functions;

    public static UserLoginResponseDto fromEntity(User user, List<String> functions) {
        UserLoginResponseDto userLoginResponseDto = new UserLoginResponseDto();

        userLoginResponseDto.setId(user.getId());
        userLoginResponseDto.setUsername(user.getUsername());
        userLoginResponseDto.setFullname(user.getFullname());
        userLoginResponseDto.setPhone(user.getPhone());
        userLoginResponseDto.setEmail(user.getEmail());
        userLoginResponseDto.setCccd(user.getCccd());
        userLoginResponseDto.setAddress(user.getAddress());
        userLoginResponseDto.setPublicKey(user.getPublicKey());
        userLoginResponseDto.setIpLastWork(user.getIpLastWork());

        userLoginResponseDto.setFunctions(functions);

        return userLoginResponseDto;
    }

    public static UserLoginResponseDto fromEntity(Employee employee, List<String> functions) {
        UserLoginResponseDto userLoginResponseDto = new UserLoginResponseDto();

        userLoginResponseDto.setId(employee.getId());
        userLoginResponseDto.setUsername(employee.getUsername());
        userLoginResponseDto.setFullname(employee.getFullname());
        userLoginResponseDto.setPhone(employee.getPhone());
        userLoginResponseDto.setEmail(employee.getEmail());
        userLoginResponseDto.setCccd(employee.getCccd());
        userLoginResponseDto.setAddress(employee.getAddress());
        userLoginResponseDto.setPublicKey(employee.getPublicKey());
        userLoginResponseDto.setIpLastWork(employee.getIpLastWork());

        userLoginResponseDto.setFunctions(functions);

        return userLoginResponseDto;
    }
}
