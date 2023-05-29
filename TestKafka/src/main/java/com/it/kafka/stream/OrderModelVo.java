package com.it.kafka.stream;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderModelVo implements Serializable {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 订单时间
     */
    private LocalDateTime orderTime;

    /**
     * 订单金额
     */
    private BigDecimal orderAmt;

    /**
     * 订单状态
     */
    private String orderStatus;

}
