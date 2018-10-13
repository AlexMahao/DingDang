package com.spearbothy.dingdang.common.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: liuwenbo
 * @Date: 2018/10/11 11:35
 * @Description:数据交互统一格式
 * @Version 1.0
 */
@Getter
@Setter
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public Result<T> setResultCode(ResultCode code) {
        this.code = code.getCode();
        this.message = code.getMsg();
        return new Result<>();
    }

}
