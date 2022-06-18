package com.canhchim.martapi.module.role.repository;

import com.canhchim.martapi.entity.RelUsersFunction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRelUsersFunctionRepository extends JpaRepository<RelUsersFunction, Long> {
    @Query("select r.function.name from RelUsersFunction r where r.user.id = ?1")
    List<String> findFunctionNamesByUser_Id(Long id);
}