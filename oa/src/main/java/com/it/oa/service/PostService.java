package com.it.oa.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.oa.entity.PostEntity;
import com.it.oa.mapper.PostMapper;
import org.springframework.stereotype.Service;

/**
 * (Post)表服务接口
 */
@Service
public class PostService extends ServiceImpl<PostMapper, PostEntity> {

}