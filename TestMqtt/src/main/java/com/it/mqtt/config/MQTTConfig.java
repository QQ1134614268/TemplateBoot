package com.it.mqtt.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(MQTTConfig.PREFIX)
public class MQTTConfig {
    // 指定配置文件application-local.properties中的属性名前缀
    public static final String PREFIX = "publish.mqtt";
    private String host;
    private String clientid;
    private String username;
    private String password;
    private boolean cleansession;
    private String default_topic;
    private int timeout;
    private int keepalive;
    private int connectionTimeout;
}