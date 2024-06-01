package com.it.boot.controller;

import com.it.boot.config.ApiResult;
import com.it.boot.entity.UserEntity;
import com.it.boot.entity.dto.UserDto;
import com.it.boot.entity.dto.UserOnly;
import com.it.boot.projection.UserProjection;
import com.it.boot.repository.UserJpaRepository;
import com.it.boot.service.UserJpaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "测试/用户Jpa")
@Slf4j
@RestController
@RequestMapping("/api/UserJpaController")
public class UserJpaController {

    @Resource
    private UserJpaService userJpaService;

    @Resource
    private UserJpaRepository userJpaRepository;

    @Operation(summary = "新增")
    @PostMapping("/create")
    public ApiResult<Long> create(@RequestBody UserEntity userEntity) {
        return ApiResult.success(userJpaService.create(userEntity));
    }

    @Operation(summary = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<UserEntity>> getPage(Pageable page, UserEntity userEntity) {
        return ApiResult.success(userJpaService.getPage(page, userEntity));
    }

    @Operation(summary = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Long> updateById(@RequestBody UserEntity userEntity) {
        return ApiResult.success(userJpaService.updateById(userEntity));
    }

    @Operation(summary = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Integer> deleteById(@RequestBody Integer id) {
        return ApiResult.success(userJpaService.removeById(id));
    }

    @Operation(summary = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody List<UserEntity> userEntities) {
        userJpaService.removeByIds(userEntities);
        return ApiResult.success();
    }


    @Operation(summary = "连表")
    @GetMapping("/join")
    public ApiResult<Object> join(UserEntity userEntity) {
        return ApiResult.success(userJpaService.join(userEntity));
    }

    /*
     *测试jpa 投影
     */
    @GetMapping("/projections")
    @Operation(summary = "测试jpa 投影")
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
    @Operation(summary = "testJpaDto")
    public List<UserOnly> testJpaDto() {
        UserEntity userEntity = userJpaRepository.findByUserNameAndEmail("tom", "test@test.com", UserEntity.class);
        System.out.println(userEntity);
        List<UserOnly> userOnlyList = userJpaRepository.findByUserName("tom", UserOnly.class);
        System.out.println(userOnlyList);
        return userOnlyList;
    }

    @GetMapping("/getNativeQuery")
    @Operation(summary = "getNativeQuery")
    public ApiResult<UserEntity> getNativeQuery() {
        return ApiResult.success(userJpaRepository.getNativeQuery(1));
    }

    @GetMapping("/getNativeQuery2")
    @Operation(summary = "getNativeQuery2")
    public ApiResult<UserDto> getNativeQuery2() {
        // bug: org.hibernate.MappingException: Unknown entity
        return ApiResult.success(userJpaRepository.getNativeQuery2(1));
    }
}
