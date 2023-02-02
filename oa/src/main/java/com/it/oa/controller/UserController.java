package com.it.oa.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.config.ConstConf;
import com.it.oa.config.Log;
import com.it.oa.config.shiro.JWTToken;
import com.it.oa.controller.dto.UserDTO;
import com.it.oa.controller.dto.UserDTO2;
import com.it.oa.controller.para.*;
import com.it.oa.entity.OrganizationEntity;
import com.it.oa.entity.PostEntity;
import com.it.oa.entity.UserEntity;
import com.it.oa.mapper.UserMapper;
import com.it.oa.service.OrganizationService;
import com.it.oa.service.UserService;
import com.it.oa.util.JwtUtil;
import com.it.oa.util.VerificationCodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.it.oa.util.StringUtil.toBool;


@Api(tags = "人事管理/员工档案")
@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {
    @Resource
    private HttpServletResponse response;
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserService userService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private OrganizationService organizationService;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody UserEntity userEntity) {
        userService.save(userEntity);
        return ApiResult.success();
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<IPage<UserDTO2>> getPage(Page<UserEntity> page, UserQo qo) {
        MPJLambdaWrapper<UserEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.selectAll(UserEntity.class);
        wrapper.select(OrganizationEntity::getOrgName);
        wrapper.select(PostEntity::getPostName);
        wrapper.leftJoin(PostEntity.class, PostEntity::getId, UserEntity::getPostId);
        wrapper.leftJoin(OrganizationEntity.class, OrganizationEntity::getId, UserEntity::getOrgId);

        wrapper.eq(toBool(qo.getSex()), UserEntity::getSex, qo.getSex());
        wrapper.eq(toBool(qo.getAccountStatus()), UserEntity::getAccountStatus, qo.getAccountStatus());
        wrapper.eq(toBool(qo.getStaffStatus()), UserEntity::getStaffStatus, qo.getStaffStatus());
        wrapper.between(toBool(qo.getEntryDateEnd()) || toBool(qo.getEntryDateStart()), UserEntity::getEntryDate, qo.getEntryDateStart(), qo.getEntryDateEnd());
        wrapper.eq(toBool(qo.getOrgId()), UserEntity::getOrgId, qo.getOrgId());


        return ApiResult.success(userMapper.selectJoinPage(page, UserDTO2.class, wrapper));
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody UserEntity userEntity) {
        return ApiResult.success(userService.updateById(userEntity));
    }

    @ApiOperation(value = "根据删除修改")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        return ApiResult.success(userService.removeById(para.getId()));
    }

    @Log("登陆系统")
    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public ApiResult<String> login(@RequestBody UserParam user) {
        // 验证码
        if (user == null) {
            return ApiResult.fail("请求参数为空");
        }
        if (user.getVerificationCode() == null) {
            return ApiResult.fail("请输入验证码");
        }
        if (Boolean.FALSE.equals(stringRedisTemplate.hasKey(ConstConf.REDIS_PREFIX_VERIFICATION_CODE + user.getVerificationCode().toUpperCase()))) {
            return ApiResult.fail("验证码错误或已经过期!");
        }
        UserEntity vo = userService.getUserByName(user.getUserName());
        if (null != vo && null != vo.getPassword() && vo.getPassword().equals(user.getPassword())) {
            String tokenStr = JwtUtil.toToken(vo.getId(), user.getUserName());

            SecurityUtils.getSubject().login(new JWTToken(tokenStr));

            return ApiResult.success(tokenStr);
        } else {
            return ApiResult.fail("账号或者密码错误");
        }
    }

    @Log("退出登录")
    @ApiOperation(value = "退出登录")
    @GetMapping(value = "logOut")
    public ApiResult<Boolean> logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ApiResult.success();
    }

    @ApiOperation(value = "获取验证码")
    @GetMapping("/getVerificationCode")
    public void getVerificationCode() throws IOException {
        String text = VerificationCodeUtil.randomText();
        verificationCodeToRedis(text);
        BufferedImage img = VerificationCodeUtil.getImage(text);
        response.setContentType("image/png");
        VerificationCodeUtil.output(img, response.getOutputStream());
    }

    public void verificationCodeToRedis(String text) {
        stringRedisTemplate.opsForValue().set(ConstConf.REDIS_PREFIX_VERIFICATION_CODE + text.toUpperCase(), text, 60 * 10, TimeUnit.SECONDS);
    }

    @ApiOperation(value = "企业通讯录")
    @GetMapping("/contacts")
    public ApiResult<IPage<UserDTO>> contacts(Page<UserEntity> page, ContactsParam contactsParam) {
        MPJLambdaWrapper<UserEntity> queryWrapper = new MPJLambdaWrapper<>();
        queryWrapper.leftJoin(OrganizationEntity.class, OrganizationEntity::getId, UserEntity::getOrgId);
        queryWrapper.leftJoin(PostEntity.class, PostEntity::getId, UserEntity::getPostId);

        queryWrapper.select(UserEntity::getStaffName, UserEntity::getPhone, UserEntity::getId, UserEntity::getEmail);
        queryWrapper.select(OrganizationEntity::getOrgName);
        queryWrapper.select(PostEntity::getPostName);
        queryWrapper.and(toBool(contactsParam.getSearch()), orWrapper -> orWrapper.like(UserEntity::getPhone, contactsParam.getSearch())
                .or().like(UserEntity::getStaffName, contactsParam.getSearch()));
        queryWrapper.eq(toBool(contactsParam.getOrgId()), OrganizationEntity::getId, contactsParam.getOrgId());
        return ApiResult.success(userMapper.selectJoinPage(page, UserDTO.class, queryWrapper));
    }

    @ApiOperation(value = "获取当前用户信息")
    @GetMapping("/getCurrentUserInfo")
    public ApiResult<UserEntity> getCurrentUserInfo() {
        UserEntity entity = userService.lambdaQuery()
                .eq(UserEntity::getId, JwtUtil.getUserId())
                .select(UserEntity::getId, UserEntity::getStaffName, UserEntity::getAvatar)
                .one();
        return ApiResult.success(entity);
    }

    @ApiOperation("用户树形结构")
    @GetMapping("/getUserTree")
    public ApiResult<List<DepartmentVo>> getUserTree() {
        List<UserEntity> allUser = userService.lambdaQuery().orderByAsc(UserEntity::getStaffName).list();
        List<DepartmentVo> user = allUser.stream().map(entity -> {
            DepartmentVo vo = new DepartmentVo();
            vo.setId(entity.getId());
            vo.setName(entity.getStaffName());
            vo.setParentId(entity.getOrgId());
            vo.setIsOrg(false);
            return vo;
        }).collect(Collectors.toList());

        List<OrganizationEntity> all = organizationService.lambdaQuery()
                .orderByAsc(OrganizationEntity::getParentId)
                .orderByAsc(OrganizationEntity::getOrgOrder)
                .select(OrganizationEntity::getId, OrganizationEntity::getParentId, OrganizationEntity::getOrgName)
                .list();

        List<DepartmentVo> org = all.stream().map(entity -> {
            DepartmentVo vo = new DepartmentVo();
            vo.setId(entity.getId());
            vo.setParentId(entity.getParentId());
            vo.setName(entity.getOrgName());
            vo.setIsOrg(true);
            return vo;
        }).collect(Collectors.toList());

        List<DepartmentVo> tree = new ArrayList<>();
        for (DepartmentVo entity : org) {
            if (entity.getParentId() == null) {
                tree.add(entity);
            }
            for (DepartmentVo entity1 : org) {
                if (Objects.equals(entity.getId(), entity1.getParentId())) {
                    entity.getChildren().add(entity1);
                }
            }
            for (DepartmentVo entity1 : user) {
                if (Objects.equals(entity.getId(), entity1.getParentId())) {
                    entity.getChildren().add(entity1);
                }
            }
        }
        return ApiResult.success(tree);
    }
}