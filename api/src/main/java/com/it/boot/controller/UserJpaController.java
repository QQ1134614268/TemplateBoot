package com.it.boot.controller;

import com.it.boot.config.ApiResult;
import com.it.boot.projection.UserProjection;
import com.it.boot.repository.UserJpaRepository;
import com.it.boot.entity.dto.UserDto;
import com.it.boot.entity.dto.UserOnly;
import com.it.boot.entity.UserEntity;
import com.it.boot.service.UserJpaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "测试/用户Jpa")
@Slf4j
@RestController
@RequestMapping("/api/UserJpaController")
public class UserJpaController {

    @Resource
    private UserJpaService userJpaService;

    @Resource
    private UserJpaRepository userJpaRepository;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Long> create(@RequestBody UserEntity userEntity) {
        return ApiResult.success(userJpaService.create(userEntity));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<UserEntity>> getPage(Pageable page, UserEntity userEntity) {
        return ApiResult.success(userJpaService.getPage(page, userEntity));
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Long> updateById(@RequestBody UserEntity userEntity) {
        return ApiResult.success(userJpaService.updateById(userEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Integer> deleteById(@RequestBody Integer id) {
        return ApiResult.success(userJpaService.removeById(id));
    }

    @ApiOperation(value = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody List<UserEntity> userEntities) {
        userJpaService.removeByIds(userEntities);
        return ApiResult.success();
    }


    @ApiOperation(value = "连表")
    @GetMapping("/join")
    public ApiResult<Object> join(@RequestBody List<Integer> ids) {
        return ApiResult.success(userJpaService.join(ids));
    }

    /*
     *测试jpa 投影
     */
    @GetMapping("/projections")
    @ApiOperation(value = "测试jpa 投影")
    public Map<String, Object> projection() {
        Map<String, Object> map = new HashMap<>();
        Collection<UserProjection> projections = userJpaRepository.findAllNameAndEmail();
        System.out.println(projections);
        System.out.println(projections.size());
        for (UserProjection u : projections) {
            map.put("userName:", u.getUserName());
            map.put("email:", u.getEmail());
            map.put("information:", u.getInformation());
        }
        return map;
    }


    /*
     *测试jpa dto
     */
    @GetMapping("/testJpaDto")
    @ApiOperation(value = "testJpaDto")
    public List<UserOnly> testJpaDto() {
        UserEntity userEntity = userJpaRepository.findByUserNameAndEmail("tom", "test@test.com", UserEntity.class);
        System.out.println(userEntity);
        List<UserOnly> userOnlyList = userJpaRepository.findByUserName("tom", UserOnly.class);
        System.out.println(userOnlyList);
        return userOnlyList;
    }

    @GetMapping("/getNativeQuery")
    @ApiOperation("getNativeQuery")
    public ApiResult<UserEntity> getNativeQuery() {
        return ApiResult.success(userJpaRepository.getNativeQuery(1));
    }

    @GetMapping("/getNativeQuery2")
    @ApiOperation("getNativeQuery2")
    public ApiResult<UserDto> getNativeQuery2() {
        // bug: org.hibernate.MappingException: Unknown entity
        return ApiResult.success(userJpaRepository.getNativeQuery2(1));
    }
}
