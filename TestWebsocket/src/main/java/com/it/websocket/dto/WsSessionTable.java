package com.it.websocket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.socket.WebSocketSession;

import java.util.Set;

@AllArgsConstructor
@Data
public class WsSessionTable {
    String id; // sessionId
    String userId; //
    WebSocketSession session;
    Set<String> topic;
}
