/**
 * @author Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.employee.impl;

import com.canhchim.martapi.dto.employee.EmployeeRequestDto;
import com.canhchim.martapi.dto.employee.EmployeeResponseDto;
import com.canhchim.martapi.entity.Employee;
import com.canhchim.martapi.module.employee.IEmployeeRepository;
import com.canhchim.martapi.module.employee.IEmployeeService;
import com.canhchim.martapi.module.role.IRelEmployeesFunctionService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class EmployeeServiceImpl implements IEmployeeService {
    private final IEmployeeRepository employeeRepository;
    private final IRelEmployeesFunctionService relEmployeesFunctionService;

    public EmployeeServiceImpl(IEmployeeRepository employeeRepository, IRelEmployeesFunctionService relEmployeesFunctionService) {
        this.employeeRepository = employeeRepository;
        this.relEmployeesFunctionService = relEmployeesFunctionService;
    }

    @Override
    public Employee findByUsernameLikeIgnoreCase(String username) throws Exception {
        return this.employeeRepository.findByUsernameLikeIgnoreCase(username);
    }

    @Override
    public EmployeeResponseDto findById(Long employId) throws Exception {
        Employee employee = this.employeeRepository.findById(employId).get();
        return EmployeeResponseDto.fromEntity(employee);
    }

    @Override
    public Page<EmployeeResponseDto> findAll() throws Exception {
        return null;
    }

    @Override
    public Boolean create(EmployeeRequestDto employeeRequestDto) throws Exception {
        return null;
    }

    @Override
    public EmployeeResponseDto update(Long employeeId, EmployeeRequestDto employeeRequestDto) throws Exception {
        return null;
    }

    @Override
    public EmployeeRequestDto delete(Long employeeId) throws Exception {
        return null;
    }
}
