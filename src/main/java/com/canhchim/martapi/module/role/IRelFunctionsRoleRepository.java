package com.canhchim.martapi.module.role;

import com.canhchim.martapi.entity.RelFunctionsRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRelFunctionsRoleRepository extends JpaRepository<RelFunctionsRole, Integer> {
    @Query("select r.function.name from RelFunctionsRole r where r.role.id = ?1")
    List<String> findFunction_nameByRole_Id(Integer id);
}