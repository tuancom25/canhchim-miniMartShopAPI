package com.canhchim.martapi.module.user;

import com.canhchim.martapi.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    User findByUsernameLike(String username);
}
