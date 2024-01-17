package com.it.boot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.boot.config.ApiResult;
import com.it.boot.entity.CacheEntity;
import com.it.boot.service.CacheService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <pre>
 * 参考: <a href="https://blog.csdn.net/ToBeMaybe_/article/details/126707473">...</a>
 *      <a href="https://www.cnblogs.com/wxl123/p/12537433.html">...</a>
 * 缓存一般放在dao中,service只关注业务处理,不关心缓存方式
 * 实现缓存，还需要考虑淘汰、最大限制、缓存过期时间淘汰等等功能
 * 关键注解:
 *     EnableCaching 开启缓存功能，一般放在启动类上。
 *     CacheConfig 注解在 class 之上来统一指定value的值
 *     Cacheable 根据方法对其返回结果进行缓存，下次请求时，如果缓存存在，则直接读取缓存数据返回；如果缓存不存在，则执行方法，并把返回的结果存入缓存中。一般用在查询方法上。
 *         属性:
 *             value 缓存名，必填，它指定了你的缓存存放在哪块命名空间
 *             cacheNames 与 value 差不多，二选一即可
 *             key	可选属性，可以使用 SpEL 标签自定义缓存的key
 *             keyGenerator	key的生成器。key/keyGenerator二选一使用
 *             cacheManager	指定缓存管理器
 *             cacheResolver	指定获取解析器, 自定义缓存resolver
 *             condition	条件符合则缓存
 *             unless	条件符合则不缓存
 *             sync	是否使用异步模式，默认为false
 *     CachePut 使用该注解标志的方法，每次都会执行，并将结果存入指定的缓存中。其他方法可以直接从响应的缓存中读取缓存数据，而不需要再去查询数据库。一般用在新增方法上
 *     CacheEvict 使用该注解标志的方法，会清空指定的缓存。一般用在更新或者删除方法上
 *     Caching 该注解可以实现同一个方法上同时使用多种注解。
 * CacheManager:
 *     SimpleCacheManager	使用简单的 Collection 来存储缓存
 *     ConcurrentMapCacheManager	使用 java.util.ConcurrentHashMap 来实现缓存
 *     NoOpCacheManager	仅测试用，不会实际存储缓存
 *     EhCacheCacheManger	使用EhCache作为缓存技术。EhCache 是一个纯 Java 的进程内缓存框架，特点快速、精干，是 Hibernate 中默认的 CacheProvider，也是 Java 领域应用最为广泛的缓存
 *     JCacheCacheManager	支持JCache（JSR-107）标准的实现作为缓存技术
 *     CaffeineCacheManager	使用 Caffeine 作为缓存技术。用于取代 Guava 缓存技术。
 *     RedisCacheManager	使用Redis作为缓存技术
 *     HazelcastCacheManager	使用Hazelcast作为缓存技术
 *     CompositeCacheManager	用于组合 CacheManager，可以从多个 CacheManager 中轮询得到相应的缓存
 * 本地缓存:
 *      ConcurrentHashMap
 *          缓存的本质就是存储在内存中的KV数据结构，对应的就是jdk中线程安全的ConcurrentHashMap，但是要实现缓存，还需要考虑淘汰、最大限制、缓存过期时间淘汰等等功能
 *          优点是实现简单，不需要引入第三方包，比较适合一些简单的业务场景。缺点是如果需要更多的特性，需要定制化开发，成本会比较高，并且稳定性和可靠性也难以保障。对于比较复杂的场景，建议使用比较稳定的开源工具。
 *      Guava Cache实现本地缓存
 *          Guava是Google团队开源的一款 Java 核心增强库，包含集合、并发原语、缓存、IO、反射等工具箱，性能和稳定性上都有保障，应用十分广泛。Guava Cache支持很多特性：
 *              支持最大容量限制
 *              支持两种过期删除策略（插入时间和访问时间）
 *              支持简单的统计功能
 *              基于LRU算法实现
 *      Caffeine Caffeine是基于java8实现的新一代缓存工具，缓存性能接近理论最优。可以看作是Guava Cache的增强版，功能上两者类似，不同的是Caffeine采用了一种结合LRU、LFU优点的算法：W-TinyLFU，在性能上有明显的优越性
 *      Ehcache Ehcache是一个纯Java的进程内缓存框架，具有快速、精干等特点，是Hibernate中默认的CacheProvider。同Caffeine和Guava Cache相比，Ehcache的功能更加丰富，扩展性更强：
 *         支持多种缓存淘汰算法，包括LRU、LFU和FIFO
 *         缓存支持堆内存储、堆外存储、磁盘存储（支持持久化）三种
 *         支持多种集群方案，解决数据共享问题
 * SpEL:
 *     methodName	root object	当前被调用的方法名    #root.methodName
 *     method	root object	当前被调用的方法    #root.method.name
 *     target	root object	当前被调用的目标对象    #root.target
 *     targetClass	root object	当前被调用的目标对象类    #root.targetClass
 *     args	root object	当前被调用的方法的参数列表    #root.args[0]
 *     caches	root object	当前方法调用使用的缓存列表（如@Cacheable(value={“cache1”, “cache2”})），则有两个cache    #root.caches[0].name
 *     argument name	evaluation context	方法参数的名字. 可以直接 #参数名 ，也可以使用 #p0或#a0 的形式，0代表参数的索引；	#username 、 #a0 、 #p0
 *     result	evaluation context	方法执行后的返回值（仅当方法执行之后的判断有效，如‘unless’，’cache put’的表达式 ’cache evict’的表达式beforeInvocation=false）    #result
 * </pre>
 */
@Slf4j
@Api(tags = "测试/Cache")
@RestController
@RequestMapping("/api/TestCacheController")
public class TestCacheController {
    @Resource
    private CacheService cacheService;

    // 默认缓存到redis
    // @Cacheable 开启缓存，将查询到的结果对象，存到缓存中，一般用在查询方法上
    // @CachePut 将添加的对象加到缓存中，一般用在插入，更新方法上
    // @CacheEvict 将缓存废弃，一般添加到删除方法上
    //
    // @CacheConfig(cacheNames = "emp")//抽取缓存的公共配置，这样下面配置缓存的时候就不用了配置cacheNames了

    // cacheNames 可以理解为缓存 key 的前缀

    @ApiOperation("page")
    @GetMapping("/page")
    public ApiResult<Page<CacheEntity>> page(Page<CacheEntity> page) {
        return ApiResult.success(cacheService.getPage(page));
    }

    @ApiOperation("info")
    @GetMapping("/info")
    public ApiResult<CacheEntity> info(CacheEntity cache) {
        log.info("info");
        return ApiResult.success(cacheService.info(cache));
    }

    @ApiOperation("create")
    @PostMapping("/create")
    public ApiResult<CacheEntity> create(@Validated @RequestBody CacheEntity cache) {
        CacheEntity b = cacheService.create(cache);
        return ApiResult.success(b);
    }

    @ApiOperation("edit")
    @PostMapping("/edit")
    public ApiResult<CacheEntity> edit(@Validated @RequestBody CacheEntity cache) {
        CacheEntity b = cacheService.edit(cache);
        return ApiResult.success(b);
    }

    @ApiOperation("delete")
    @PostMapping("/delete")
    public ApiResult<Boolean> delete(Long id) {
        cacheService.delete(id);
        return ApiResult.success();
    }
}
