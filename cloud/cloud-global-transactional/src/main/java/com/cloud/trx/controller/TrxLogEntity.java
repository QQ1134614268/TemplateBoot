package com.cloud.trx.controller;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.*;

@Data
@TableName(value = "trx_log_t")
@Entity(name = "trx_log_t") //jpa jpsql
@Table(name = "trx_log_t") // jpa
public class TrxLogEntity {
    @Id // jpa
    @GeneratedValue(strategy = GenerationType.IDENTITY) // jpa IDENTITY：数据库自增
    @TableId(type = IdType.AUTO)
    private Long id;
    private String uid;
}