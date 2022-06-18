package com.canhchim.martapi.module.employee;

import com.canhchim.martapi.dto.DataDto;
import com.canhchim.martapi.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path = "/shop/employees")
public class EmployeeController {
    private final IEmployeeService employeeService;

    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOnce(@PathVariable Long id) throws Exception {
        ResponseDto responseDto = new ResponseDto();
        DataDto dataDto = new DataDto();
        dataDto.setContent(employeeService.findById(id));
        responseDto.setData(dataDto);
        return ResponseEntity.status(HttpServletResponse.SC_OK).body(responseDto);
    }
}
