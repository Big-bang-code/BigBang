package com.bang.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum Result {

    SUCCESS(0, "成功"),

    SYSTEM_ERROR(-501, "系统异常")
    ;
    private int code;
    private String msg;



}
