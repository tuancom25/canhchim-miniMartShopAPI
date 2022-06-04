/**
 * @author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.user;

import com.canhchim.martapi.dto.user.UserResponseDto;
import com.canhchim.martapi.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUserRepository extends JpaRepository<User, Integer> {
    @Query("select (count(u) > 0) from User u where u.username like ?1")
    boolean existsByUsernameLike(String username);
    @Query("select u from User u where u.username like ?1")
    User findByUsernameLike(String username);

    @Query("select u from User u where u.shop.id = ?1")
    Page<UserResponseDto> findByUserShop_Id(Integer shopId, Pageable pageable);

}