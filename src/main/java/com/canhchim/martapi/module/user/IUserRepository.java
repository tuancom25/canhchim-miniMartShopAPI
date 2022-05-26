package com.canhchim.martapi.module.user;

import com.canhchim.martapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.username like ?1")
    User findByUsernameLike(String username);
}