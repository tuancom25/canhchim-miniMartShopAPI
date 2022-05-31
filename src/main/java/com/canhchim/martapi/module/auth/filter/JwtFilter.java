package com.canhchim.martapi.module.auth.filter;

import com.canhchim.martapi.dto.UserDetailDto;
import com.canhchim.martapi.entity.Admin;
import com.canhchim.martapi.module.admin.IAdminService;
import com.canhchim.martapi.module.user.IUserService;
import com.canhchim.martapi.util.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

@Component
public class JwtFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final IUserService userService;
    private final IAdminService adminService;

    public JwtFilter(JwtUtil jwtUtil, IUserService userService, IAdminService adminService) {
        this.jwtUtil = jwtUtil;
        this.userService = userService;
        this.adminService = adminService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String requestTokenHeader = request.getHeader("Authorization");
        String username = null;
        String jwtToken = null;
        String type = null;
        //Validate token
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);
            try {
                username = jwtUtil.getUsernameFromToken(jwtToken);
                type = jwtUtil.getAccountTyeFromToken(jwtToken);
            } catch (IllegalArgumentException e) {
                System.out.println("Unable to get JWT Token");
            } catch (ExpiredJwtException e) {
                System.out.println("JWT Token has expired");
            }
        } else {
            logger.warn("JWT Token does not begin with Bearer String");
        }

        // Once we get the token validate it.
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails;
            //Check account type
            if (type.equals("ADMIN")) {
                //Type ADMIN
                userDetails = initUserDetailsFromAdmin(username);
            }
            else {
                //Type SHOP
                userDetails = initUserDetailsFromUser(username);
            }

            // if token is valid configure Spring Security to manually set
            // authentication
            if (jwtUtil.validateToken(jwtToken, userDetails)) {
                //Login success
                //Init UsernamePasswordAuthenticationToken
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // After setting the Authentication in the context, we specify
                // that the current user is authenticated. So it passes the
                // Spring Security Configurations successfully.
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }

    private UserDetails initUserDetailsFromAdmin(String username) throws IOException {
        Admin user = this.adminService.findByAdminNameLike(username);
        String password = user.getAdminPassword();
        Collection<GrantedAuthority> roles = new HashSet<>();
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(username, password, roles);
        return userDetails;
    }

    private UserDetails initUserDetailsFromUser(String username) throws IOException {
        UserDetailDto user = this.userService.findUserDetailByUsernameLike(username);
        String password = user.getUserPassword();
        Collection<GrantedAuthority> roles = new HashSet<>();
        for (String function: user.getFunctions()) {
            roles.add(new SimpleGrantedAuthority(function));
            System.out.println(function);
        }
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(username, password, roles);
        return userDetails;
    }
}
