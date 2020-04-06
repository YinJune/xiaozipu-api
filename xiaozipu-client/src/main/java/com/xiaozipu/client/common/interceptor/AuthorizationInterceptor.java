package com.xiaozipu.client.common.interceptor;

import com.xiaozipu.client.common.constants.RedisKeyConstants;
import com.xiaozipu.client.util.JwtUtils;
import com.xiaozipu.client.util.RedisUtils;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: YinJunJie
 * @date: 2020/1/19 20:45
 * @description:
 */
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AuthorizationInterceptor.class);

    @Autowired
    private RedisUtils redisUtils;

    @Value("${spring.profiles.active}")
    private String profile;

    private static final String dev = "dev";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("authorization");
        String yjj = request.getHeader("yjj");
        if (dev.equals(profile) && !StringUtils.isEmpty(yjj)) {
            request.setAttribute("userId", Integer.parseInt(yjj));
            request.setAttribute("phone", "17513130886");
            return true;
        }
        try {
            Claims claims = JwtUtils.verifyAndGetClaimsByToken(token);
            String userId = claims.getAudience();
            request.setAttribute("userId", Integer.parseInt(userId));
            request.setAttribute("phone", claims.get("phone"));
            Long expire = redisUtils.getExpire(RedisKeyConstants.USER_TOKEN + userId);
            Long oneDay = Long.parseLong(String.valueOf(60 * 60 * 24));
            if (expire < oneDay) {
                redisUtils.expire(RedisKeyConstants.USER_TOKEN + userId, JwtUtils.EXPIRATION);
            }
        } catch (Exception e) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter printWriter = null;
            try {
                printWriter = response.getWriter();
                printWriter.write("令牌无效");
                logger.error("--令牌无效");
            } catch (IOException ex) {
                logger.error("设置返回内容出错:{}", ex);
            } finally {
                if (printWriter != null) {
                    printWriter.close();
                }
            }
            return false;
        }
        return true;
    }
}
