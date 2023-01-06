package com.it.oa.config.exception;

import lombok.Data;

@Data
public class OaGlobalException extends RuntimeException {

    private static final long serialVersionUID = 2074723225554638558L;
    private Integer code;
    private String msg;

    public OaGlobalException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;

    }

    public OaGlobalException(String msg) {
        this.code = 2;
        this.msg = msg;
    }
}