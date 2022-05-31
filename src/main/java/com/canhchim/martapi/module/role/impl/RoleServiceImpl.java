/**
 * @Author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.role.impl;

import com.canhchim.martapi.entity.Role;
import com.canhchim.martapi.module.role.IRoleRepository;
import com.canhchim.martapi.module.role.IRoleService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {
    private IRoleRepository roleRepository;

    public RoleServiceImpl(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAllById(Iterable<Integer> ids) {
        return roleRepository.findAllById(ids);
    }

    @Override
    public Role create(Role role) throws IOException {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
