/**
 * @Author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.user;

import com.canhchim.martapi.dto.DataDto;
import com.canhchim.martapi.dto.ErrorResponseDto;
import com.canhchim.martapi.dto.ResponseDto;
import com.canhchim.martapi.entity.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
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

    @GetMapping("")
    public ResponseEntity<?> getAll(
            @PathVariable @Nullable Integer pageNumber,
            @PathVariable @Nullable Integer pageSize
    ) {
        if (pageSize == null) pageSize = 20;
        if (pageNumber == null) pageNumber = 0;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(userService.findAll(pageable));
        return ResponseEntity.status(HttpServletResponse.SC_OK).body(responseDto);
    }
    @PostMapping("")
    public ResponseEntity<?> create() {
        ResponseDto responseDto = new ResponseDto();
        DataDto dataDto = new DataDto();
        //Tạo user
        dataDto.setContent("Tạo User mới thành công!");
        responseDto.setData(dataDto);
        return ResponseEntity.status(HttpServletResponse.SC_CREATED).body(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOnce(@PathVariable Integer id) {
        ResponseDto responseDto = new ResponseDto();
        DataDto dataDto = new DataDto();
        User user = userService.findById(id);
        dataDto.setContent(user);
        responseDto.setData(dataDto);
        return ResponseEntity.status(HttpServletResponse.SC_OK).body(responseDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        userService.deleteById(id);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(String.format("Xóa User Id=%d thành công!", id));
        return ResponseEntity.status(HttpServletResponse.SC_ACCEPTED).body("ok");
    }
}
