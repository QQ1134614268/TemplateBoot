package com.it.boot.config.excel.excel1;

import lombok.Data;

@Data
public class ThrowJsonException extends RuntimeException {

    private static final long serialVersionUID = 2074723225554638558L;

    public ThrowJsonException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;

    }

    private Integer code;
    private String msg;
}
