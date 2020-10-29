package com.bang.common.exception;

import com.bang.common.enums.Result;
import lombok.Getter;

@Getter
public class ApiException {

    private Result result;

    public ApiException(Result result) {
       // super(result.getMsg());
        this.result = result;
    }

}
