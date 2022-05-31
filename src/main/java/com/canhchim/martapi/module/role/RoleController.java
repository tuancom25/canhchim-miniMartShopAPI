/**
 * @Author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.role;

import com.canhchim.martapi.dto.DataDto;
import com.canhchim.martapi.dto.ResponseDto;
import com.canhchim.martapi.entity.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(path = "/shop/roles")
public class RoleController {
    private IRoleService roleService;

    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        List<Role> roles = roleService.findAll();

        ResponseDto responseDto = new ResponseDto();
        DataDto dataDto = new DataDto();
        dataDto.setContent(roles);
        responseDto.setData(dataDto);

        return ResponseEntity.status(HttpServletResponse.SC_OK).body(responseDto);
    }

    @PostMapping("/")
    public ResponseEntity<?> create() {
        return ResponseEntity.status(HttpServletResponse.SC_CREATED).body("");
    }
}
