package com.cloud.trx.controller;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.*;

@Table(name = "trx_log_t")
@Data
@TableName(value = "trx_log_t")
@Entity(name = "trx_log_t")
public class TrxLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uid;
}