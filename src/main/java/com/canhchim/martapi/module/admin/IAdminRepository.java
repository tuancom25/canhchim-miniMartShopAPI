/**
 * Author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.admin;

import com.canhchim.martapi.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IAdminRepository extends JpaRepository<Admin, Integer> {
    @Query("select a from Admin a where a.adminName like ?1")
    Admin findByAdminNameLike(String adminName);

}