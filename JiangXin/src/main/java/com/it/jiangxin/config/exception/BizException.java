package com.it.jiangxin.config.exception;

import lombok.Data;

@Data
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 2074723225554638558L;
    private Integer code;
    private String msg;

    public BizException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;

    }

    public BizException(String msg) {
        this.code = 2;
        this.msg = msg;
    }
}