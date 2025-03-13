package com.cloud.user.controller;

import lombok.Data;

import javax.persistence.*;

@Table(name = "user_t")
@Data
@Entity(name = "user_t")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
}