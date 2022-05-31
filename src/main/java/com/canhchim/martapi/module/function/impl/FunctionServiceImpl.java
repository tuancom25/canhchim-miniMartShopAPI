/**
 * @Author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.function.impl;

import com.canhchim.martapi.entity.Function;
import com.canhchim.martapi.module.function.IFunctionRepository;
import com.canhchim.martapi.module.function.IFunctionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FunctionServiceImpl implements IFunctionService {
    private IFunctionRepository functionRepository;

    public FunctionServiceImpl(IFunctionRepository functionRepository) {
        this.functionRepository = functionRepository;
    }

    @Override
    public List<Function> findAll() {
        return functionRepository.findAll();
    }

    @Override
    public List<String> findFunction_nameById(List<Integer> ids) {
        List<String> functionNames = new ArrayList<>();
        Iterable<Integer> iterable = ids;
        functionRepository.findAllById(iterable);
        return functionNames;
    }
}
