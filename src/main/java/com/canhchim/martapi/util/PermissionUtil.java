package com.canhchim.martapi.util;

import com.canhchim.martapi.entity.User;
import com.canhchim.martapi.module.user.IUserRepository;
import com.canhchim.martapi.module.user.IUserService;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class PermissionUtil {
    private final JwtUtil jwtUtil;
    private final IUserService userService;
    @PersistenceContext
    private EntityManager entityManager;

    public PermissionUtil(JwtUtil jwtUtil, IUserService userService) {
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }


    /**
     * Kiểm tra yêu cầu có quyền thực hiện thao tác trên hàng hay không?
     * @param request HttpServletRequest
     * @param entity Tên của Entity được thao tác
     * @param shopIdName Tên của thuộc tính shopId trong Enity
     * @param rowIdName Tên của thuộc tính Id trong Entity
     * @param rowId Id row cần kiểm tra trong Entity
     * @return
     * @throws IOException
     */
    public boolean acceptAction(
            HttpServletRequest request,
            String entity,
            String shopIdName,
            String rowIdName,
            int rowId
    ) throws IOException {
        int shopId = getShopId(request);
        String query = "select (count(e) > 0) from " + entity + " e where e." + rowIdName + " = :rowId and e." + shopIdName + " = :shopId";
        Object output = entityManager.createQuery(query)
                .setParameter("rowId", rowId)
                .setParameter("shopId", shopId)
                .getSingleResult();
        if(output.toString().equals("true")) return true;

        //Khóa tài khoản
        String username = getUsername(request);
        ban(username);
        throw new IOException("HACK! Tài khoản của bạn bị khóa.");
    }

    /**
     * Lấy shopId từ HttpServletRequest
     * @param request HttpServletRequest
     * @return
     */
    public int getShopId(HttpServletRequest request) {
        final String requestTokenHeader = request.getHeader("Authorization");
        String accessToken = requestTokenHeader.substring(7);
        int shopId = jwtUtil.getShopIdFromToken(accessToken);
        return shopId;
    }

    private String getUsername(HttpServletRequest request) {
        final String requestTokenHeader = request.getHeader("Authorization");
        String accessToken = requestTokenHeader.substring(7);
        String username = jwtUtil.getUsernameFromToken(accessToken);
        return username;
    }

    private void ban(String username) {
        userService.ban(username);
    }
}
