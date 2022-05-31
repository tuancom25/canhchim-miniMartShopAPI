/**
 * @Author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.user;

import com.canhchim.martapi.entity.RoleOfUser;
import com.canhchim.martapi.entity.RoleOfUserId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRoleOfUserRepository extends JpaRepository<RoleOfUser, RoleOfUserId> {
    List<RoleOfUser> findByUser_Id(Integer id);
}