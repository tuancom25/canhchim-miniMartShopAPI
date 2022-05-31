/**
 * @Author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.role;

import com.canhchim.martapi.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Integer> {
}