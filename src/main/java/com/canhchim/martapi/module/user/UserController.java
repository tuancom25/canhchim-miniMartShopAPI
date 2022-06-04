/**
 * @Author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.user;

import com.canhchim.martapi.dto.*;
import com.canhchim.martapi.dto.user.UserRequestDto;
import com.canhchim.martapi.dto.user.UserResponseDto;
import com.canhchim.martapi.entity.User;
import com.canhchim.martapi.util.PermissionUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping(path = "/shop/users")
public class UserController {
    private final IUserService userService;
    private final PermissionUtil permissionUtil;

    public UserController(IUserService userService, PermissionUtil permissionUtil) {
        this.userService = userService;
        this.permissionUtil = permissionUtil;
    }

    @GetMapping("")
    public ResponseEntity<?> getAll(
            HttpServletRequest httpServletRequest,
            @RequestParam @Nullable Integer pageNumber,
            @RequestParam @Nullable Integer pageSize
    ) {
        if (pageSize == null) pageSize = 20;
        if (pageNumber == null) pageNumber = 0;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        int shopId = permissionUtil.getShopId(httpServletRequest);

        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(userService.findAll(shopId, pageable));
        return ResponseEntity.status(HttpServletResponse.SC_OK).body(responseDto);
    }
    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody UserRequestDto userRequestDto) throws IOException, NoSuchAlgorithmException {
        //Tạo user
        UserResponseDto userResponseDto = userService.create(userRequestDto);
        //Khởi tạo đối tượng Response
        ResponseDto responseDto = new ResponseDto();
        DataDto dataDto = new DataDto();
        responseDto.setMessage("Tạo User mới thành công!");
        dataDto.setContent(userResponseDto);
        responseDto.setData(dataDto);
        return ResponseEntity.status(HttpServletResponse.SC_CREATED).body(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(HttpServletRequest request, @PathVariable Integer id, @RequestBody UserRequestDto userRequestDto) throws IOException, NoSuchAlgorithmException {
        permissionUtil.acceptAction(request, "User", "userShop.id", "id", id);

        //Tạo user
        UserResponseDto userResponseDto = userService.create(userRequestDto);
        //Khởi tạo đối tượng Response
        ResponseDto responseDto = new ResponseDto();
        DataDto dataDto = new DataDto();
        responseDto.setMessage("Cập nhật User mới thành công!");
        dataDto.setContent(userResponseDto);
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
