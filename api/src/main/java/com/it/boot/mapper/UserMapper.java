package com.it.boot.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.it.boot.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;

/**
 * (user)表数据库访问层
 */
@Mapper
public interface UserMapper extends MPJBaseMapper<UserEntity> {

    // cacheNames 缓存多个key-value数据
    // CacheManager:
    //         SimpleCacheManager	使用简单的 Collection 来存储缓存
    //         ConcurrentMapCacheManager	使用 java.util.ConcurrentHashMap 来实现缓存
    //         NoOpCacheManager	仅测试用，不会实际存储缓存
    //         EhCacheCacheManger	使用EhCache作为缓存技术。EhCache 是一个纯 Java 的进程内缓存框架，特点快速、精干，是 Hibernate 中默认的 CacheProvider，也是 Java 领域应用最为广泛的缓存
    //         JCacheCacheManager	支持JCache（JSR-107）标准的实现作为缓存技术
    //         CaffeineCacheManager	使用 Caffeine 作为缓存技术。用于取代 Guava 缓存技术。
    //         RedisCacheManager	使用Redis作为缓存技术
    //         HazelcastCacheManager	使用Hazelcast作为缓存技术
    //         CompositeCacheManager	用于组合 CacheManager，可以从多个 CacheManager 中轮询得到相应的缓存
    // cacheResolver = "customCacheResolver"  自定义缓存数据方法
    @Cacheable(value = "getUserById", key = "#p0", unless = "#result == null")
    @Select(value = "select * from user u where u.id=#{id}")
    UserEntity getUserById(Integer id);
}