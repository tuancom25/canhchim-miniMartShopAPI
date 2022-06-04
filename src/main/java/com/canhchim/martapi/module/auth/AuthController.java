/**
 * @author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.auth;

import com.canhchim.martapi.dto.ErrorResponseDto;
import com.canhchim.martapi.dto.auth.LoginRequestDto;
import com.canhchim.martapi.dto.auth.LoginResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {
    private final IAuthService authService;

   

    @PostMapping("/admin/login")
    public ResponseEntity<?> adminLogin(@RequestBody LoginRequestDto loginRequestDto, HttpServletRequest request) {
        try {
            LoginResponseDto loginResponseDto = authService.loginAdmin(loginRequestDto.getUsername(), loginRequestDto.getPassword());
            return ResponseEntity.status(HttpServletResponse.SC_OK)
                    .h
        catch (Exception e) {
            System.err.println(e);
            ErrorResponseDto errorResponseDto = new ErrorResponseDto();

            errorResponseDto.setTimestamp(new Date());
            errorResponseDto.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            errorResponseDto.setError("Unauthorized");
            errorResponseDto.setMessage("Tài khoản hoặc mật khẩu không chính xác!");
            errorResponseDto.setPath(request.getRequestURI());

            return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).body(errorResponseDto);
        }
    }

    @PostMapping("/user/login")
    public ResponseEntity<?> userLogin(@RequestBody LoginRequestDto loginRequestDto, HttpServletRequest request) throws Exception {
        LoginResponseDto loginResponseDto = authService.loginUser(loginRequestDto.getUsername(), loginRequestDto.getPassword());
        return ResponseEntity.status(HttpServletResponse.SC_OK)
                .header("Authorization", "Bearer " + loginResponseDto.getAccessToken())
                .body(loginResponseDto);
    }
}
