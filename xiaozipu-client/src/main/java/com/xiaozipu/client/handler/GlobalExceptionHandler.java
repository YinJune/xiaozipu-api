package com.xiaozipu.client.handler;

import com.xiaozipu.client.enums.error.ErrorCodeEnum;
import com.xiaozipu.common.exception.BusinessRuntimeException;
import com.xiaozipu.common.result.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
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
    private static final String SYS_ERROR_CODE = "999999";
    private static final String SYS_ERROR_MESSAGE = "系统异常";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultInfo argumentExceptionHandler(MethodArgumentNotValidException e) {
        logger.error("参数错误:{}", e.getMessage());
        return new ResultInfo(ErrorCodeEnum.ARGUMENT_INVALID.getCode(), e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResultInfo methodExceptionHandler(HttpRequestMethodNotSupportedException e) {
        logger.error("请求方法错误:{}", e.getMessage());
        return new ResultInfo(ErrorCodeEnum.METHOD_NOT_SUPPORTED.getCode(), e.getMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResultInfo methodExceptionHandler(MissingServletRequestParameterException e) {
        logger.error("请求参数:{}", e.getMessage());
        return new ResultInfo(ErrorCodeEnum.ARGUMENT_INVALID.getCode(), e.getMessage());
    }

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
