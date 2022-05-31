/**
 * @Author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.role;

import java.util.List;

public interface IFunctionAndRoleService {
    /**
     * Tìm danh sách Function Name theo Role Id
     * @param roleId
     * @return
     */
    List<String> findFunction_IdByRole_Id(Integer roleId);
}
