package com.canhchim.martapi.module.role.impl;

import com.canhchim.martapi.module.role.IRelEmployeesFunctionService;
import com.canhchim.martapi.module.role.repository.IRelEmployeesFunctionRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RelEmployeesFunctionServiceImpl implements IRelEmployeesFunctionService {
    private final IRelEmployeesFunctionRepository repository;

    public RelEmployeesFunctionServiceImpl(IRelEmployeesFunctionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<String> findFunctionNamesByEmployee_Id(Integer employeeId) {
        return this.repository.findFunctionNamesByEmployee_Id(employeeId);
    }
}
