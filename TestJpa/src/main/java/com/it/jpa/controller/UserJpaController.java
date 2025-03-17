package com.it.jpa.controller;

import com.it.jpa.config.ApiResult;
import com.it.jpa.dto.UserDto;
import com.it.jpa.entity.UserEntity;
import com.it.jpa.dto.UserOnly;
import com.it.jpa.dto.UserProjection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/UserJpaController")
public class UserJpaController {

    @Resource
    private UserJpaService userJpaService;

    @Resource
    private UserJpaRepository userJpaRepository;

    @PostMapping("/create")
    public ApiResult<Long> create(@RequestBody UserEntity userEntity) {
        return ApiResult.success(userJpaService.create(userEntity));
    }

    @GetMapping("/getPage")
    public ApiResult<Page<UserEntity>> getPage(Pageable page, UserEntity userEntity) {
        return ApiResult.success(userJpaService.getPage(page, userEntity));
    }

    @PostMapping("/updateById")
    public ApiResult<Long> updateById(@RequestBody UserEntity userEntity) {
        return ApiResult.success(userJpaService.updateById(userEntity));
    }

    @PostMapping("/deleteById")
    public ApiResult<Integer> deleteById(@RequestBody Integer id) {
        return ApiResult.success(userJpaService.removeById(id));
    }

    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody List<UserEntity> userEntities) {
        userJpaService.removeByIds(userEntities);
        return ApiResult.success();
    }


    @GetMapping("/join")
    public ApiResult<Object> join(UserEntity userEntity) {
        return ApiResult.success(userJpaService.join(userEntity));
    }

    /*
     *测试jpa 投影
     */
    @GetMapping("/projections")
    public Map<String, Object> projection() {
        Map<String, Object> map = new HashMap<>();
        Collection<UserProjection> projections = userJpaRepository.testJpaSql();
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
    public List<UserOnly> testJpaDto() {
        UserEntity userEntity = userJpaRepository.findByUserNameAndEmail("tom", "test@test.com", UserEntity.class);
        System.out.println(userEntity);
        List<UserOnly> userOnlyList = userJpaRepository.findByUserName("tom", UserOnly.class);
        System.out.println(userOnlyList);
        return userOnlyList;
    }

    @GetMapping("/getNativeQuery")
    public ApiResult<UserEntity> getNativeQuery() {
        return ApiResult.success(userJpaRepository.testNativeQuery(1));
    }

    @GetMapping("/getNativeQuery2")
    public ApiResult<UserDto> getNativeQuery2() {
        // bug: org.hibernate.MappingException: Unknown entity
        return ApiResult.success(userJpaRepository.getNativeQuery2(1));
    }
}
