package com.canhchim.martapi.module.user.impl;

import com.canhchim.martapi.entity.User;
import com.canhchim.martapi.module.user.IUserRepository;
import com.canhchim.martapi.module.user.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsernameLike(String username) {
        return userRepository.findByUsernameLike(username);
    }
}
