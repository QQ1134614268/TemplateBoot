package com.it.boot.config.redis2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * redis配置
 *
 * @author xc
 */
// @Component
@Configuration
// @EnableCaching // todo ??
// @AutoConfigureBefore(RedisAutoConfiguration.class) // todo ??
// 	- Bean method 'redisTemplate' in 'RedisAutoConfiguration' not loaded because @ConditionalOnMissingBean (names: redisTemplate; SearchStrategy: all) found beans named redisTemplate
public class RedisConfigWithType {//extends CachingConfigurerSupport // todo ??

    @Bean
    public RedisTemplate<Object, Object> redisTemplateWithType(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        MyRedisJsonWithTypeSerializer<Object> serializer = new MyRedisJsonWithTypeSerializer<>(Object.class);

        // 使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(serializer);

        // Hash的key也采用StringRedisSerializer的序列化方式
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(serializer);

        template.afterPropertiesSet();
        return template;
    }
    @Bean
    public RedisTemplate<Object, Object> redisTemplateNoType(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        MyRedisJsonNoTypeSerializer<Object> serializer = new MyRedisJsonNoTypeSerializer<>(Object.class);

        // 使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(serializer);

        // Hash的key也采用StringRedisSerializer的序列化方式
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(serializer);

        template.afterPropertiesSet();
        return template;
    }
    @Bean
    public <K,V> RedisTemplate<K,V> autoRedisTemplate(RedisConnectionFactory connectionFactory) {
        // todo 配置更具RedisTemplate 序列化
        RedisTemplate<K,V> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        AutoRedisJsonSerializer<V> serializer = new AutoRedisJsonSerializer<V>((Class<V>) Object.class);

        // 使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(serializer);

        // Hash的key也采用StringRedisSerializer的序列化方式
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(serializer);

        template.afterPropertiesSet();
        return template;
    }
}
