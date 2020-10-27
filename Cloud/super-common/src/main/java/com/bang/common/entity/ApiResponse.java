package com.bang.common.entity;


import com.bang.common.enums.Result;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 统一接口返回实体
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String msg;
    private int code;
    private T data;

    public static <T> ApiResponse<T> createApiResponse(T data, Result result) {
        return new ApiResponse<>(result.getMsg(), result.getCode(), data);
    }


}
