/**
 * @Author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.role;

import com.canhchim.martapi.entity.Role;

import java.io.IOException;
import java.util.List;

public interface IRoleService {
    /**
     * Tìm kiếm các Role theo Id
     * @param ids
     * @return
     */
    List<Role> findAllById(Iterable<Integer> ids);

    /**
     * Tạo Role mới
     * @param role
     * @return
     */
    Role create(Role role) throws IOException;

    /**
     * Tìm tất cả các Role
     * @return
     */
    List<Role> findAll();
}
