package com.it.boot.config.redis.cache;

import com.alibaba.fastjson2.support.spring.data.redis.GenericFastJsonRedisSerializer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
public class RedisCacheConfig {

    /**
     * redis作为缓存时配置缓存管理器CacheManager
     * 切记：在缓存配置类中配置以后，yaml配置文件中关于缓存的redis配置就不会生效，如果需要相关配置需要通过@value去读取
     * <pre>
     * 配置缓存管理器CacheManager有两种方式：
     * 方式1：
     *      通过RedisCacheConfiguration.defaultCacheConfig()获取到默认的RedisCacheConfiguration对象，
     *      修改RedisCacheConfiguration对象的序列化方式等参数【这里就采用的这种方式】
     * 方式2：
     *      通过继承CachingConfigurerSupport类自定义缓存管理器，覆写各方法，参考：
     * <a href="https://blog.csdn.net/echizao1839/article/details/102660649">...</a>
     * </pre>
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        // GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();
        GenericFastJsonRedisSerializer serializer = new GenericFastJsonRedisSerializer();
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                // 设置key采用String的序列化方式
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(StringRedisSerializer.UTF_8))
                // 设置value序列化方式采用jackson方式序列化
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer))
                // .disableCachingNullValues()                // 当value为null时不进行缓存
                // .prefixCacheNameWith("demo:")                // 配置缓存空间名称的前缀
                .entryTtl(Duration.ofSeconds(600));                // 全局配置缓存过期时间【可以不配置】
        // 专门指定某些缓存空间的配置，如果过期时间【主要这里的key为缓存空间名称】
        // Map<String, RedisCacheConfiguration> map = new HashMap<>();
        // Set<Map.Entry<String, Long>> entries = ttlParams.entrySet();
        // for (Map.Entry<String, Long> entry : entries) {
        //     // 指定特定缓存空间对应的过期时间
        //     map.put("user", redisCacheConfiguration.entryTtl(Duration.ofSeconds(40)));
        //     map.put(entry.getKey(), redisCacheConfiguration.entryTtl(Duration.ofSeconds(entry.getValue())));
        // }
        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(redisCacheConfiguration)  // 默认配置
                // .withInitialCacheConfigurations(map)  // 某些缓存空间的特定配置
                .build();
    }


    /**
     * 自定义缓存的redis的KeyGenerator【key生成策略】
     * 注意: 该方法只是声明了key的生成策略,需在@Cacheable注解中通过keyGenerator属性指定具体的key生成策略
     * 可以根据业务情况，配置多个生成策略
     * 如: @Cacheable(value = "key", keyGenerator = "cacheKeyGenerator")
     */
    @Bean
    public KeyGenerator keyGenerator() {
        /*
         * target: 类
         * method: 方法
         * params: 方法参数
         */
        return (target, method, params) -> {
            // 获取代理对象的最终目标对象
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getSimpleName()).append(":");
            sb.append(method.getName()).append(":");
            // 调用SimpleKey的key生成器
            Object key = SimpleKeyGenerator.generateKey(params);
            return sb.append(key);
        };
    }
}
