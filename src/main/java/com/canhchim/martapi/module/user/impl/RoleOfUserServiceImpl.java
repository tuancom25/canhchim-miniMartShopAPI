/**
 * @Author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.user.impl;

import com.canhchim.martapi.entity.RoleOfUser;
import com.canhchim.martapi.module.user.IRoleOfUserRepository;
import com.canhchim.martapi.module.user.IRoleOfUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleOfUserServiceImpl implements IRoleOfUserService {
    private IRoleOfUserRepository roleOfUserRepository;

    public RoleOfUserServiceImpl(IRoleOfUserRepository roleOfUserRepository) {
        this.roleOfUserRepository = roleOfUserRepository;
    }

    @Override
    public List<Integer> findRoleIdsByUser_id(Integer userId) {
        List<RoleOfUser> roleOfUserList = roleOfUserRepository.findByUser_Id(userId);
        List<Integer> roleIds = new ArrayList<>();
        for (RoleOfUser rou: roleOfUserList) {
            roleIds.add(rou.getRole().getId());
        }
        return roleIds;
    }
}
