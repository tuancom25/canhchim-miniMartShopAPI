package com.canhchim.martapi.module.role.impl;

import com.canhchim.martapi.module.role.IRelUsersFunctionService;
import com.canhchim.martapi.module.role.repository.IRelUsersFunctionRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RelUsersFunctionServiceImpl implements IRelUsersFunctionService {
    private final IRelUsersFunctionRepository repository;

    public RelUsersFunctionServiceImpl(IRelUsersFunctionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<String> findFunctionNamesByUser_Id(Long userId) {
        return this.repository.findFunctionNamesByUser_Id(userId);
    }
}
