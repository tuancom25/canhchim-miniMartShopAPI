/**
 * Author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.admin.impl;

import com.canhchim.martapi.entity.Admin;
import com.canhchim.martapi.module.admin.IAdminRepository;
import com.canhchim.martapi.module.admin.IAdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements IAdminService {
    private IAdminRepository iAdminRepository;

    public AdminServiceImpl(IAdminRepository iAdminRepository) {
        this.iAdminRepository = iAdminRepository;
    }

    @Override
    public Admin findByAdminNameLike(String adminName) {
        return iAdminRepository.findByAdminNameLike(adminName);
    }
}
