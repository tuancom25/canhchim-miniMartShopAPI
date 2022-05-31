/**
 * @Author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.role;

import com.canhchim.martapi.entity.FunctionAndRole;
import com.canhchim.martapi.entity.FunctionAndRoleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IFunctionAndRoleRepository extends JpaRepository<FunctionAndRole, FunctionAndRoleId> {
    @Query("select f.function.functionKey from FunctionAndRole f where f.role.id = ?1")
    List<String> findFunction_nameByRole_Id(Integer id);
}