/**
 * @author Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.user;

import com.canhchim.martapi.dto.user.UserDetailDto;
import com.canhchim.martapi.dto.user.UserRequestDto;
import com.canhchim.martapi.dto.user.UserResponseDto;
import com.canhchim.martapi.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface IUserService {

    /**
     * Lấy tất cả User
     * @return
     */
    List<User> findAll();



    /**
     * Tìm User với username
     * @param username
     * @return
     */
    User findByUsernameLike(String username) throws Exception;

    /**
     * Tìm User bằng Id
     * @param id
     * @return
     */
    User findById(Integer id);


    /**
     * Xóa User theo Id
     * @param id
     */
    void deleteById(int id) throws EntityNotFoundException;

    /**
     * Tìm UserDetailDto bằng username
     * @param username
     * @return
     */
    UserDetailDto findUserDetailByUsernameLike(String username) throws IOException;

    /**
     * Tạo User mới
     * @param userRequestDto
     * @return
     * @throws IOException
     */
    UserResponseDto create(UserRequestDto userRequestDto) throws IOException, NoSuchAlgorithmException;

    /**
     * Khóa tài khoản
     * @param username
     */
    void ban(String username);
}
