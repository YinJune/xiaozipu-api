package com.xiaozipu.service.util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @description:
 * @author: Yin JunJie
 * @date: 2019/10/17 13:53
 */
public class JwtUtils {
    //2天
    public static final long EXPIRATION = Long.parseLong(String.valueOf(60 * 60 * 24 * 2));
    public static final String SECRET = "xiaozipu";
    public static final String TOKEN_HEADER = "Authorization";

    public static String generateToken(Integer userId) {
        return Jwts.builder()
                //设置头部信息
                .setHeaderParam("typ", "JWT")
                .setAudience(String.valueOf(userId))
                //token过期时间 不设置过期时间不会校验过期
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION * 1000))
                //设置签名算法
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    /**
     * 如果过期或者是被篡改，则会抛异常.
     * 注意点：只有在生成token设置了过期时间(setExpiration(expireDate))才会校验是否过期，
     * 可以参考源码io.jsonwebtoken.impl.DefaultJwtParser的299行。
     * 拓展：利用不设置过期时间就不校验token是否过期的这一特性，我们不设置Expiration;
     * 而采用自定义的字段来存放过期时间放在Claims（可以简单的理解为map）中;
     * 通过token获取到Claims后自己写代码校验是否过期。
     * 通过这思路，可以去实现对过期token的手动刷新
     *
     * @param token
     * @return
     */
    public static Claims verifyAndGetClaimsByToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            throw new RuntimeException("token无效");
        }
        return claims;
    }
}
