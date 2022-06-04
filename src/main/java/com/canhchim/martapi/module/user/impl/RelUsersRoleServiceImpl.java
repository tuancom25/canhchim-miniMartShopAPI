/**
 * @Author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.user.impl;

import com.canhchim.martapi.entity.RelUsersRole;
import com.canhchim.martapi.module.user.IRelUsersRoleRepository;
import com.canhchim.martapi.module.user.IRelUsersRoleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RelUsersRoleServiceImpl implements IRelUsersRoleService {
    private IRelUsersRoleRepository relUsersRoleRepository;

    public RelUsersRoleServiceImpl(IRelUsersRoleRepository relUsersRoleRepository) {
        this.relUsersRoleRepository = relUsersRoleRepository;
    }

    @Override
    public List<Integer> findRoleIdsByUser_id(Integer userId) {
        List<RelUsersRole> roleOfUserList = relUsersRoleRepository.findByUser_Id(userId);
        List<Integer> roleIds = new ArrayList<>();
        for (RelUsersRole rou: roleOfUserList) {
            roleIds.add(rou.getRole().getId());
        }
        return roleIds;
    }
}
