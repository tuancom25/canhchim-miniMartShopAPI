/**
 * Author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.admin;

import com.canhchim.martapi.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IAdminRepository extends JpaRepository<Admin, Integer> {
    @Query("select a from Admin a where a.username like ?1")
    Admin findByAdminNameLike(String adminName);

    @Query("select a from Admin a where upper(a.email) like upper(?1)")
    Optional<Admin> findByAdminEmailLikeIgnoreCase(String adminEmail);

}