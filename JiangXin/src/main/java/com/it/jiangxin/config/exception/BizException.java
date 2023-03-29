package com.it.jiangxin.config.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BizException extends RuntimeException {

    private Integer code;
    private String msg;

    public BizException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;

    }

    public BizException(String msg) {
        super(msg);
        this.code = 2;
        this.msg = msg;
    }
}