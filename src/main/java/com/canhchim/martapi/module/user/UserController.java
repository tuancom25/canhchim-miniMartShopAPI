/**
 * @Author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.user;

import com.canhchim.martapi.dto.DataDto;
import com.canhchim.martapi.dto.ErrorResponseDto;
import com.canhchim.martapi.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RestController
@RequestMapping(path = "/shop/users")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        ResponseDto responseDto = new ResponseDto();
        DataDto dataDto = new DataDto();
        dataDto.setContent(userService.findAll());
        responseDto.setData(dataDto);
        return ResponseEntity.status(HttpServletResponse.SC_ACCEPTED).body(responseDto);
    }

    @PostMapping("/")
    public ResponseEntity<?> create() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData("Tạo User mới thành công!");
        return ResponseEntity.status(HttpServletResponse.SC_CREATED).body(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        userService.deleteById(id);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(String.format("Xóa User Id=%d thành công!", id));
        return ResponseEntity.status(HttpServletResponse.SC_ACCEPTED).body("ok");
    }
}
