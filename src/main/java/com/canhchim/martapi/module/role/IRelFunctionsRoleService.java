package com.canhchim.martapi.module.role;

import java.util.List;

public interface IRelFunctionsRoleService {
    List<String> findFunction_IdByRole_Id(Integer roleId);
}
