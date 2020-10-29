package com.bang.common.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 统一入参实体
 * @param <T>
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ApiRequest<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *  token
     */
    private String token;

    /**
     *  用户id
     */
    private Integer userId;

    /**
     *  项目id
     */
    private Integer projectId;

    /**
     *  登录类型
     */
    private String loginType;

    /**
     * 是否是底稿管理操作true
     */
    private boolean paperFlag;

    /**
     *	操作来源（所在位置）：底稿管理页-二级位置用'-'连接
     */
    private String sourceName;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 当前页数
     */
    private Integer pageNo = 1;

    /**
     * 每页条数
     */
    private Integer pageSize = 10;

    private T data;



}
