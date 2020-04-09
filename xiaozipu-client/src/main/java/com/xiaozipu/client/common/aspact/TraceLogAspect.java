package com.xiaozipu.client.common.aspact;

import com.alibaba.fastjson.JSONObject;
import com.xiaozipu.client.common.annotation.TraceLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/3/22 17:13
 * @description:
 */
@Aspect
@Component
public class TraceLogAspect {
    private static Logger logger = LoggerFactory.getLogger(TraceLogAspect.class);

    @Pointcut("@annotation(com.xiaozipu.client.common.annotation.TraceLog)")
    public void logAspect() {}

    @Around("logAspect()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Object[] args = joinPoint.getArgs();
        List params=new ArrayList();
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof ServletRequest || args[i] instanceof ServletResponse || args[i] instanceof MultipartFile) {
                //ServletRequest不能序列化，从入参里排除，否则报异常：java.lang.IllegalStateException: It is illegal to call this method if the current request is not in asynchronous mode (i.e. isAsyncStarted() returns false)
                //ServletResponse不能序列化 从入参里排除，否则报异常：java.lang.IllegalStateException: getOutputStream() has already been called for this response
                continue;
            }
            params.add(args[i]);
        }
        Integer userId= (Integer) request.getAttribute("userId");
        String phone = (String) request.getAttribute("phone");
        String desc=getAspectLogDescription(joinPoint);
        String uri=request.getRequestURI();
        String method=request.getMethod();
        String paramStr=JSONObject.toJSONString(params);
        logger.info("用户:{} 手机:{} {} url:{} type:{} 参数：{}",userId,phone,desc,uri,method,paramStr);
        Object result=joinPoint.proceed();
        logger.info("请求url:{} 返回值:{}",request.getRequestURL(), JSONObject.toJSONString(result));
        return result;
    }
    /**
     * @Function: 获取切面注解的描述
     * @author:   YangXueFeng
     * @Date:     2019/5/9 18:18
     * @param:    joinPoint切点
     * @return:   描述信息
     */
    public String getAspectLogDescription(JoinPoint joinPoint)
            throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        StringBuilder description = new StringBuilder("");
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description.append(method.getAnnotation(TraceLog.class).desc());
                    break;
                }
            }
        }
        return description.toString();
    }
}
