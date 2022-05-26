/**
 * Author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.admin;

import com.canhchim.martapi.entity.Admin;
import org.springframework.stereotype.Service;

@Service
public interface IAdminService {
    Admin findByAdminNameLike(String adminName);
}
