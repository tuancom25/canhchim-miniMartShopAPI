/**
 * @Author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.role.impl;

import com.canhchim.martapi.module.role.IFunctionAndRoleRepository;
import com.canhchim.martapi.module.role.IFunctionAndRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IFunctionAndRoleServiceImpl implements IFunctionAndRoleService {
    private IFunctionAndRoleRepository functionAndRoleRepository;

    public IFunctionAndRoleServiceImpl(IFunctionAndRoleRepository functionAndRoleRepository) {
        this.functionAndRoleRepository = functionAndRoleRepository;
    }

    @Override
    public List<String> findFunction_IdByRole_Id(Integer roleId) {
        return functionAndRoleRepository.findFunction_nameByRole_Id(roleId);
    }
}
