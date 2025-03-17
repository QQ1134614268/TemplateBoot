package com.it.jpa.dto;

import lombok.Data;

@Data
public class UserOnly {
    private final String userName, email;
}