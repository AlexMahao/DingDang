package com.spearbothy.dingdang.common.response;

import lombok.Getter;

/**
 * 业务异常枚举
 */
@Getter
public enum ResultCode {
    SUCCESS(0, "成功"),
    ERROR_DEFAULT(1,"服务器错误"),
    ERROR_REQUEST_PARAMS (2, "参数不合法"),
    ERROR_BUSSINESS (3, "业务异常");
    private Integer code;
    private String msg;
    ResultCode(Integer code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }
}
