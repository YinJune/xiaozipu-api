package com.xiaozipu.merchant.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: YinJunJie
 * @date: 2020/3/22 17:05
 * @description:
 */
@Target({ElementType.TYPE, ElementType.METHOD})
//注解保留在运行时
@Retention(RetentionPolicy.RUNTIME)
public @interface TraceLog {
    String desc() default "";
}
