package com.bang.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum Result {

    SUCCESS(0, "成功"),

    SYSTEM_ERROR(-501, "系统异常"),

    MONGODB_OPERATION_ERROR(-5018,"操作mongoDB出现异常")
    ;
    private int code;
    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public static Result fromCode(int code) {
        Result[] results = Result.values();
        for (Result result : results) {
            if (result.getCode() == code) {
                return result;
            }
        }
        return null;
    }
    public static Result formMsg(int code,String msg){
        Result[] results = Result.values();
        for (Result result : results) {
            if (result.getCode() == code) {
                result.msg = msg;
                return result;
            }
        }
        return null;
    }
}
