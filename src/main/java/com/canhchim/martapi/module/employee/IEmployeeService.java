/**
 * @author Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.employee;

import com.canhchim.martapi.dto.employee.EmployeeRequestDto;
import com.canhchim.martapi.dto.employee.EmployeeResponseDto;
import com.canhchim.martapi.entity.Employee;
import org.springframework.data.domain.Page;

public interface IEmployeeService {
    Employee findByUsernameLikeIgnoreCase(String username) throws Exception;

    EmployeeResponseDto findById(Long employId) throws Exception;

    Page<EmployeeResponseDto> findAll() throws Exception;

    Boolean create(EmployeeRequestDto employeeRequestDto) throws Exception;

    EmployeeResponseDto update(Long employeeId, EmployeeRequestDto employeeRequestDto) throws Exception;

    EmployeeRequestDto delete(Long employeeId) throws Exception;
}
