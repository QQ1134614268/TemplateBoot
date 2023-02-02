package com.it.oa.controller;


import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.dto.PostDTO;
import com.it.oa.controller.para.DelPara;
import com.it.oa.controller.para.DelParaList;
import com.it.oa.entity.EnumEntity;
import com.it.oa.entity.PostEntity;
import com.it.oa.entity.PostLevelEntity;
import com.it.oa.entity.UserEntity;
import com.it.oa.mapper.PostMapper;
import com.it.oa.service.PostService;
import com.it.oa.service.UserService;
import com.it.oa.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@Api(tags = "人事管理/职位管理")
@RestController
@RequestMapping("/api/post")
@Slf4j
public class PostController {
    @Resource
    private PostService postService;

    @Resource
    private UserService userService;

    @Resource
    private PostMapper postMapper;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody PostEntity postEntity) {
        return ApiResult.success(postService.save(postEntity));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<List<PostDTO>> getPage() {
        MPJLambdaWrapper<PostEntity> wrapper = new MPJLambdaWrapper();
        wrapper.leftJoin(PostLevelEntity.class, PostLevelEntity::getId, PostEntity::getPostLevelId);
        wrapper.leftJoin(EnumEntity.class, EnumEntity::getId, PostEntity::getPostLevelTypeId);
        wrapper.selectAll(PostEntity.class);
        wrapper.select(PostLevelEntity::getPostLevelName);
        wrapper.select(EnumEntity::getValue);
        return ApiResult.success(postMapper.selectJoinList(PostDTO.class, wrapper));
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody PostEntity postEntity) {
        return ApiResult.success(postService.updateById(postEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        return ApiResult.success(postService.removeById(para.getId()));
    }

    @ApiOperation(value = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody DelParaList para) {
        return ApiResult.success(postService.removeByIds(para.getIds()));
    }

    @ApiOperation(value = "职位说明")
    @GetMapping("/getById")
    public ApiResult<PostEntity> getById() {
        UserEntity user = userService.getById(JwtUtil.getUserId());
        return ApiResult.success(postService.getById(user.getPostId()));
    }
}