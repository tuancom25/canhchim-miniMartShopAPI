/**
 * @author Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.auth.impl;

import com.canhchim.martapi.dto.auth.LoginResponseDto;
import com.canhchim.martapi.dto.RSADto;
import com.canhchim.martapi.dto.auth.UserLoginResponseDto;
import com.canhchim.martapi.entity.Admin;
import com.canhchim.martapi.entity.Employee;
import com.canhchim.martapi.entity.User;
import com.canhchim.martapi.module.admin.IAdminService;
import com.canhchim.martapi.module.auth.IAuthService;
import com.canhchim.martapi.module.employee.IEmployeeService;
import com.canhchim.martapi.module.role.IRelUsersFunctionService;
import com.canhchim.martapi.module.user.IUserService;
import com.canhchim.martapi.util.HashUtil;
import com.canhchim.martapi.util.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthServiceImpl implements IAuthService {
    private JwtUtil jwtUtil;
    private IAdminService adminService;
    private IUserService userService;
    private IEmployeeService employeeService;
    private IRelUsersFunctionService relUsersFunctionService;

    public AuthServiceImpl(JwtUtil jwtUtil, IAdminService adminService, IUserService userService, IEmployeeService employeeService, IRelUsersFunctionService relUsersFunctionService) {
        this.jwtUtil = jwtUtil;
        this.adminService = adminService;
        this.userService = userService;
        this.employeeService = employeeService;
        this.relUsersFunctionService = relUsersFunctionService;
    }

    @Override
    public LoginResponseDto loginAdmin(String username, String password) throws Exception {
        LoginResponseDto loginResponseDto = new LoginResponseDto();

        Admin admin = adminService.findByAdminNameLike(username);
        String salt = admin.getSalt();
        if (admin.getPassword().equals(HashUtil.sha256(password + salt))) {
            //Login success
//            String accessToken = jwtUtil.generateToken(admin.getId(), username, "ADMIN", 0);
//            loginResponseDto.setAccessToken(accessToken);
            return loginResponseDto;
        }
        throw new Exception();
    }

    @Override
    public LoginResponseDto loginUser(String username, String password) throws Exception {
        //Tìm User
        User user = userService.findByUsernameLike(username);
        //Kiểm tra user có tồn tại trong DB?
        if (user != null) {
            String salt = user.getSalt();
            if (user.getPassword().equals(HashUtil.sha256(password + salt))) { // Kiểm tra Password trong DB có trùng với Password truyền vào không?
                //Login success
                LoginResponseDto loginResponseDto = new LoginResponseDto();
                RSADto rsaDto = new RSADto();
                List<String> functions = new ArrayList<>();

                for (String function: relUsersFunctionService.findFunctionNamesByUser_Id(user.getId())) functions.add(function);

                String accessToken = jwtUtil.generateToken(user.getId(), username, "SHOP", 0);
                loginResponseDto.setUser(UserLoginResponseDto.fromEntity(user, functions));
                loginResponseDto.setAccessToken(accessToken);

                return loginResponseDto;
            }
        }
        throw new Exception("Tài khoản hoặc mật khẩu không chính xác!");
    }

    @Override
    public LoginResponseDto loginEmployee(String username, String password) throws Exception {
        Employee employee = employeeService.findByUsernameLikeIgnoreCase(username);
        if (employee != null) {
            String salt = employee.getSalt();
            if (employee.getPassword().equals(HashUtil.sha256(password + salt))) { // Kiểm tra Password trong DB có trùng với Password truyền vào không?
                //Login success
                LoginResponseDto loginResponseDto = new LoginResponseDto();
                RSADto rsaDto = new RSADto();
                List<String> functions = new ArrayList<>();

                for (String function: relUsersFunctionService.findFunctionNamesByUser_Id(employee.getId())) functions.add(function);

                String accessToken = jwtUtil.generateToken(employee.getId(), username, "EMPLOYEE", employee.getShopId());
                loginResponseDto.setUser(UserLoginResponseDto.fromEntity(employee, functions));
                loginResponseDto.setAccessToken(accessToken);

                return loginResponseDto;
            }
        }
        throw new Exception("Tài khoản hoặc mật khẩu không chính xác!");
    }
}
