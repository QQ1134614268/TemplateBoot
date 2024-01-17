package com.it.boot.config.redis;

import com.alibaba.fastjson2.support.spring.data.redis.GenericFastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class RedisConfig {
    /**
     * @param redisConnectionFactory：配置不同的客户端，这里注入的redis连接工厂不同： JedisConnectionFactory、LettuceConnectionFactory配置Redis序列化，原因如下：
     * <pre>
     *  （1） StringRedisTemplate的序列化方式为字符串序列化，
     *  RedisTemplate的序列化方式默为jdk序列化（实现Serializable接口）
     *  （2） RedisTemplate的jdk序列化方式在Redis的客户端中为乱码，不方便查看，
     *  因此一般修改RedisTemplate的序列化为方式为JSON方式【建议使用GenericJackson2JsonRedisSerializer】
     * </pre>
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();

        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // 使用Jackson, 序列化json带有 @class 类名
        // GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();

        // 使用fastjson扩展包, 序列化json带有 @type 类名
        GenericFastJsonRedisSerializer serializer = new GenericFastJsonRedisSerializer();

        // 使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(stringRedisSerializer);
        template.setValueSerializer(serializer);

        // Hash的key也采用StringRedisSerializer的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
        template.setHashValueSerializer(serializer);

        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplateWithType(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        FasterJsonWithTypeSerializer<Object> serializer = new FasterJsonWithTypeSerializer<>(Object.class);

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

        FasterJsonNoTypeSerializer<Object> serializer = new FasterJsonNoTypeSerializer<>(Object.class);

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
