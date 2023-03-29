package com.it.boot.config.excel.excel1;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ThrowJsonException extends RuntimeException {

    public ThrowJsonException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;
}
