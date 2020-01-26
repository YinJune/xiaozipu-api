package com.xiaozipu.client.interceptor;

import com.xiaozipu.service.constants.RedisKeyConstants;
import com.xiaozipu.service.util.JwtUtils;
import com.xiaozipu.service.util.RedisUtils;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
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

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("authorization");
        try {
            logger.info("请求uri", request.getRequestURI());
            Claims claims = JwtUtils.verifyAndGetClaimsByToken(token);
            String userId = claims.getAudience();
            request.setAttribute("userId", userId);
            request.setAttribute("phone",claims.get("phone"));
            Long expire = redisUtils.getExpire(RedisKeyConstants.USER_TOKEN + userId);
            Long oneDay = Long.parseLong(String.valueOf(60 * 60 * 24));
            if (expire < oneDay) {
                redisUtils.expire(RedisKeyConstants.USER_TOKEN+userId,JwtUtils.EXPIRATION);
            }
        } catch (Exception e) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter printWriter = null;
            try {
                printWriter = response.getWriter();
                printWriter.write("令牌无效");
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
