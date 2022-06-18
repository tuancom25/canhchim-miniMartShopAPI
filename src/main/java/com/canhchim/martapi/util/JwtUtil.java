/**
 * @author Duong Ngo Nam Anh
 */

package com.canhchim.martapi.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.*;
import java.util.function.Function;

@Component
@Slf4j
public class JwtUtil {
    private final String JWT_SECRET = "66w94CaPsFS32124rSUZ5DpWduia16YSYNOvfb1eGmuMd8FeNg6iM6o5WoThV3SzT8M1C5M5smGP1PHz5VF8Jg166w94CaPsFS32124rSUZ5DpWduia16YSYNOvfb1eGmuMd8FeNg6iM6o5WoThV3SzT8M1C5M5smGP1PHz5VF";
    private final long JWT_EXPIRATION = 86400000L;
    public String generateToken(Long uid, String username, String type, Integer shopId) throws Exception{
        Map<String, Object> claims = new HashMap<>();
        claims.put("uid", uid);
        claims.put("type", type);
        claims.put("shopId", shopId);
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }
    public String getAccountTyeFromToken(String token) {
        final Claims claims = getAllClaimsFromToken(token);
        return claims.get("type").toString();
    }
    public int getShopIdFromToken(String token) {
        final Claims claims = getAllClaimsFromToken(token);
        return Integer.parseInt(claims.get("shopId").toString());
    }
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
