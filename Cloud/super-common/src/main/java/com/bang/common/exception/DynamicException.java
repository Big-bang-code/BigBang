package com.bang.common.exception;

import com.bang.common.enums.Result;
import lombok.Getter;

@Getter
public class DynamicException extends RuntimeException{

    private Result result;

    private String message;

    public DynamicException(String message,Result result){
        this.message = message;
        this.result = result;
    }

}
