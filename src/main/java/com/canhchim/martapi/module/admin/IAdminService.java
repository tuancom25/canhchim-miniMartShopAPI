/**
 * Author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.admin;

import com.canhchim.martapi.entity.Admin;

public interface IAdminService {
    Admin findByAdminNameLike(String adminName);
}
