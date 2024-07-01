package com.it.websocket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class WsDto {
    String id;
    String path;
    String code;
    Object data;
}
