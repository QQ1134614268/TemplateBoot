package com.it.mqtt.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(MqttProp.PREFIX)
public class MqttProp {
    // 指定配置文件application-local.properties中的属性名前缀
    public static final String PREFIX = "publish.mqtt";
    private String host;
    private String clientId;
    private String username;
    private String password;
    private boolean cleanSession;
    private String defaultTopic;
    private int timeout;
    private int keepalive;
    private int connectionTimeout;
}