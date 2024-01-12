package com.it.boot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.boot.entity.CacheEntity;
import com.it.boot.mapper.CacheMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CacheService extends ServiceImpl<CacheMapper, CacheEntity> {
    @Resource
    private CacheMapper cacheMapper;

    public CacheEntity getCacheById(Long id) {
        return cacheMapper.getCacheById(id);
    }
}
