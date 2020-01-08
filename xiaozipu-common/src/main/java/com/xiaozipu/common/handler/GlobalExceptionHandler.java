package com.xiaozipu.common.handler;

import com.xiaozipu.common.exception.BusinessRuntimeException;
import com.xiaozipu.common.result.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: Yin JunJie
 * @date: 2019/12/21 20:36
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private static final String SYS_ERROR_CODE="000000";
    private static final String SYS_ERROR_MESSAGE="系统异常";
    @ExceptionHandler(BusinessRuntimeException.class)
    public ResultInfo bizExceptionHandler(BusinessRuntimeException e) {
        logger.error("业务异常：", e);
        return new ResultInfo(e.getErrorCode(), e.getErrorMsg());
    }

    @ExceptionHandler(Exception.class)
    public ResultInfo exceptionHandler(Exception e) {
        logger.error("系统异常：", e);
        return new ResultInfo(SYS_ERROR_CODE, SYS_ERROR_MESSAGE);
    }
}
