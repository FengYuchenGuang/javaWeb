package com.AopBean.Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * @author hxz
 */
public class JwtUtils {
    // 数字签名 和 过期时间
    private static String signKey = "FenYuChen";
    private static Long expire = 86400000L;


    /**
     * 生成 JWT令牌
     */
    public static String generateJwt(Map<String,Object> claims){
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, signKey)  //签名算法
                .setClaims(claims) //自定义内容（载荷）
                // JWT 令牌的有效期为 一天（当前时间加上 一天）
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .compact();

        return jwt;
    }


    /**
     * 验证 JWT令牌
     */
    public static Claims parseJwt(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();

        return claims;
    }

}
