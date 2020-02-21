package com.xiaozipu.common.func;

/**
 * @author: YinJunJie
 * @date: 2020/2/21 16:14
 * @description:
 */
@FunctionalInterface
public interface BeanCopyUtilCallBack<S, T> {

    /**
     * 定义默认回调方法
     *
     * @param t
     * @param s
     */
    void callBack(S t, T s);
}