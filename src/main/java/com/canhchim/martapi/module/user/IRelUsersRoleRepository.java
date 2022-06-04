package com.canhchim.martapi.module.user;

import com.canhchim.martapi.entity.RelUsersRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRelUsersRoleRepository extends JpaRepository<RelUsersRole, Integer> {
    @Query("select r from RelUsersRole r where r.user.id = ?1")
    List<RelUsersRole> findByUser_Id(Integer id);
}