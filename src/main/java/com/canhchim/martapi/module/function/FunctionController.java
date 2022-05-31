/**
 * @Author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.function;

import com.canhchim.martapi.dto.DataDto;
import com.canhchim.martapi.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path = "/shop/functions")
public class FunctionController {
    private IFunctionService functionService;

    public FunctionController(IFunctionService functionService) {
        this.functionService = functionService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        ResponseDto responseDto = new ResponseDto();
        DataDto dataDto = new DataDto();
        dataDto.setContent(functionService.findAll());
        responseDto.setData(dataDto);

        return ResponseEntity.status(HttpServletResponse.SC_OK).body(responseDto);
    }
}
