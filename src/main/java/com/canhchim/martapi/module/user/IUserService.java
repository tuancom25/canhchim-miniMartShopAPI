/**
 * Author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.user;

import com.canhchim.martapi.entity.User;

public interface IUserService {
    User findByUsernameLike(String username);
}
