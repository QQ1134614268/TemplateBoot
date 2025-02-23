package com.cloud.user.controller;

import lombok.Data;

import javax.persistence.*;

@Table(name = "stock")
@Data
@Entity
public class StockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    private Integer count;
}