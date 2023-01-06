package com.it.netty.netty_short;

import lombok.Data;

@Data
public class RpcResponse {
    /**
     * 响应对应的请求ID
     */
    private String requestId;
    /**
     * 调用是否成功的标识
     */
    private boolean success = true;
    /**
     * 调用错误信息
     */
    private String errorMessage;
    /**
     * 调用结果
     */
    private Object result;
}