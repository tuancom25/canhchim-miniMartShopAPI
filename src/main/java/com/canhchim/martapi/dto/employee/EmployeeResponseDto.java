package com.canhchim.martapi.dto.employee;

import com.canhchim.martapi.entity.Employee;
import lombok.Data;

@Data
public class EmployeeResponseDto {
    private Long id;
    private String username;
    private String fullname;
    private String phone;
    private String email;
    private String cccd;
    private String address;
    private String publicKey;
    private String ipLastWork;

    public static EmployeeResponseDto fromEntity(Employee employee) {
        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();

        employeeResponseDto.setId(employee.getId());
        employeeResponseDto.setUsername(employee.getUsername());
        employeeResponseDto.setFullname(employee.getFullname());
        employeeResponseDto.setPhone(employee.getPhone());
        employeeResponseDto.setEmail(employee.getPhone());
        employeeResponseDto.setCccd(employee.getCccd());
        employeeResponseDto.setAddress(employee.getAddress());
        employeeResponseDto.setPublicKey(employee.getPublicKey());
        employeeResponseDto.setIpLastWork(employee.getIpLastWork());

        return employeeResponseDto;
    }
}
