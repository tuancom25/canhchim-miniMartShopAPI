/**
 * @Author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.user;

import java.util.List;

public interface IRoleOfUserService {
    /**
     * Tìm danh sách Role id bằng UserId
     * @param userId
     * @return
     */
    List<Integer> findRoleIdsByUser_id(Integer userId);
}
