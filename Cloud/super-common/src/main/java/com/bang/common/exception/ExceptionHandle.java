package com.bang.common.exception;

import com.bang.common.entity.ApiResponse;
import com.bang.common.enums.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理
 */
@RestControllerAdvice
public class ExceptionHandle {


    /**
     * 异常信息动态
     */
    @ExceptionHandler(value = {DynamicException.class})
    public ApiResponse<String> HandleDynamicException(DynamicException e){
        return ApiResponse.createApiResponse(e.getMessage(),e.getResult());
    }

    /**
     * 处理系统类的异常
     */
    @ExceptionHandler(value = {Exception.class})
    public ApiResponse<String> HandleException(Exception e){
        StackTraceElement[] stackTraceElements = e.getStackTrace();
        StringBuilder sb = new StringBuilder();
        sb.append(e.fillInStackTrace());
        for(int i= 0;i<stackTraceElements.length;i++){
            StackTraceElement s = stackTraceElements[i];
            sb.append(" "+s.getClassName()+"."+s.getMethodName()+"("+s.getFileName()+":"+s.getLineNumber()+") ");
        }
        return ApiResponse.createApiResponse(sb.toString(), Result.SYSTEM_ERROR);
    }



}
