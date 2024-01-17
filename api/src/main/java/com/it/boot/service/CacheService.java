package com.it.boot.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.boot.config.exception.BizException;
import com.it.boot.entity.CacheEntity;
import com.it.boot.mapper.CacheMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheService extends ServiceImpl<CacheMapper, CacheEntity> {

    public Page<CacheEntity> getPage(Page<CacheEntity> page) {
        return page(page);
    }

    @Cacheable(value = "CACHE", key = "#cache.id")
    public CacheEntity info(CacheEntity cache) {
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
}
