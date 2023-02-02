package com.it.boot.config.exception;

public class ExcelException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String message;
    private Integer code;
    private Object data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
