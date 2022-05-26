/**
 * Author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.admin.impl;

import com.canhchim.martapi.dto.LoginResponseDto;
import com.canhchim.martapi.entity.Admin;
import com.canhchim.martapi.module.admin.IAdminRepository;
import com.canhchim.martapi.module.admin.IAdminService;
import com.canhchim.martapi.util.JwtUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.Random;

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
