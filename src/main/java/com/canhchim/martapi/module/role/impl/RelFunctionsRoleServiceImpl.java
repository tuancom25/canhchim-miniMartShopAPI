/**
 * @Author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.role.impl;

import com.canhchim.martapi.module.role.IRelFunctionsRoleRepository;
import com.canhchim.martapi.module.role.IRelFunctionsRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelFunctionsRoleServiceImpl implements IRelFunctionsRoleService {
    private IRelFunctionsRoleRepository relFunctionsRoleRepository;

    public RelFunctionsRoleServiceImpl(IRelFunctionsRoleRepository relFunctionsRoleRepository) {
        this.relFunctionsRoleRepository = relFunctionsRoleRepository;
    }

    @Override
    public List<String> findFunction_IdByRole_Id(Integer roleId) {
        return relFunctionsRoleRepository.findFunction_nameByRole_Id(roleId);
    }
}
