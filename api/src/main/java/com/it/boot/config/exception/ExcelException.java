package com.it.boot.config.exception;

import com.it.boot.config.enum1.ResCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ExcelException extends Exception {

    private String message;
    private Integer code;

    public ExcelException(String msg) {
        this(ResCodeEnum.EXCEPTION.getCode(), msg);
    }

    public ExcelException(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }

}
