package com.canhchim.martapi.module.role.repository;

import com.canhchim.martapi.entity.Function;
import com.canhchim.martapi.entity.RelEmployeesFunction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRelEmployeesFunctionRepository extends JpaRepository<RelEmployeesFunction, Long> {
    @Query("select r.function.name from RelEmployeesFunction r where r.employee.id = ?1")
    List<String> findFunctionNamesByEmployee_Id(Integer id);
}