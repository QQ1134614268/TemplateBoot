package com.it.websocket.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public
class SysAnno {
    String title;
    String auth;
    String content;

    String topic;

}
