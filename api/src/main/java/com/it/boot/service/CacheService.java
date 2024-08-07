package com.it.boot.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.boot.config.ApiResult;
import com.it.boot.config.exception.BizException;
import com.it.boot.entity.CacheEntity;
import com.it.boot.mapper.CacheMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class CacheService extends ServiceImpl<CacheMapper, CacheEntity> {

    public Page<CacheEntity> getPage(Page<CacheEntity> page) {
        return page(page);
    }

    @Cacheable(value = "CACHE", key = "#cache.id")
    public CacheEntity info(CacheEntity cache) throws InterruptedException {
        return this.lambdaQuery().eq(CacheEntity::getId, cache.getId()).last("limit 1").one();
    }

    @CachePut(value = "CACHE", key = "#cache.id", condition = "#result!=null")
    public CacheEntity create(CacheEntity cache) {
        boolean b = save(cache);
        if (!b) {
            throw new BizException("添加失败!");
        }
        return cache;
    }

    @CachePut(value = "CACHE", key = "#cache.id", condition = "#result!=null")
    public CacheEntity edit(CacheEntity cache) {
        boolean b = updateById(cache);
        if (!b) {
            throw new BizException("修改失败!");
        }
        return cache;
    }

    @CacheEvict(value = "CACHE", key = "#id")
    public void delete(Long id) {
        boolean b = this.removeById(id);
        if (!b) {
            throw new BizException("修改失败!");
        }
    }

    @Async
    public CompletableFuture<ApiResult<Integer>> testAsyncCache(CacheService cacheService) throws InterruptedException {
        int a = 1;
        int b = 2;
        return CompletableFuture.completedFuture(cacheService.sum(a, b));
    }

    public CompletableFuture<ApiResult<Integer>> testAsyncCacheV2(CacheService cacheService) {
        int a = 3;
        int b = 4;
        return CompletableFuture.supplyAsync(() -> {
            try {
                return cacheService.sum(a, b);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Cacheable(value = "CACHE_SUM", key = "#a + ',' + #b")
    public ApiResult<Integer> sum(int a, int b) throws InterruptedException {
        log.info("线程名: {}", Thread.currentThread().getName());
        Thread.sleep(5000);
        return ApiResult.success(a + b);
    }
}
