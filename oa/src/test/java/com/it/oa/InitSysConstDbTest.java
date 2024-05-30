package com.it.oa;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.config.constant.EnumKeyConf;
import com.it.oa.config.constant.PayEnumKeyConf;
import com.it.oa.config.constant.PayTypeValueEnum;
import com.it.oa.config.constant.PerformanceStatusEnum;
import com.it.oa.config.constant.Score;
import com.it.oa.controller.UserController;
import com.it.oa.entity.*;
import com.it.oa.service.*;
import com.it.oa.util.BuildDataUtil;
import org.apache.shiro.SecurityUtils;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class InitSysConstDbTest {
    @Resource
    private UserController userController;
    @Resource
    private org.apache.shiro.mgt.SecurityManager securityManager;
    @Resource
    private EnumService enumService;
    @Resource
    private PayConfigService payConfigService;

    @Resource
    private PerformancePlanService performancePlanService;
    @Resource
    private UserService service;
    @Resource
    private SystemUserService systemUserService;

    @BeforeEach
    void beforeTest() {
        SecurityUtils.setSecurityManager(securityManager);
    }


    @Test
    void projectInit() {
        // 系统用户
        String phone = "18800000000";
        SystemUserEntity systemUser = systemUserService.lambdaQuery().eq(SystemUserEntity::getPhone, phone).one();
        if (systemUser == null) {
            SystemUserEntity entity = BuildDataUtil.createData(SystemUserEntity.class);
            entity.setId(null);
            entity.setPhone(phone);
            entity.setPassword("test");
            systemUserService.save(entity);
        }

        // 企业员工
        LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserEntity::getUserName, "test");
        UserEntity vo = service.getOne(queryWrapper);
        if (vo == null) {
            UserEntity userEntity = BuildDataUtil.createData(UserEntity.class);
            userEntity.setId(1);
            userEntity.setUserName("test");
            userEntity.setPassword("test");
            userEntity.setOrgId(1);
            ApiResult res = userController.create(userEntity);
            Assertions.assertEquals(1, res.getCode());
        }

        EnumEntity enumEntity;
        String[] codes = new String[]{EnumKeyConf.WORK_BACKGROUND_IMG, EnumKeyConf.COMPANY_CULTURE,};
        for (String code : codes) {
            enumEntity = new EnumEntity();
            enumEntity.setUniqueCode(code);
            // enumEntity.setGroupCode("WORKBENCH");
            EnumEntity db = enumService.getOne(new QueryWrapper<>(enumEntity));
            if (db == null) {
                enumService.save(enumEntity);
            }
        }
        codes = new String[]{PayEnumKeyConf.WECHAT_PAY, PayEnumKeyConf.ALI_PAY, PayEnumKeyConf.BANK_PAY};
        String[] values = new String[]{PayTypeValueEnum.WECHAT_PAY, PayTypeValueEnum.ALI_PAY, PayTypeValueEnum.BANK_PAY};
        payConfigService.remove(new QueryWrapper<>(new PayConfigEntity()));
        for (int i = 0; i < codes.length; i++) {
            PayConfigEntity payConfigEntity = new PayConfigEntity();
            payConfigEntity.setPayNameEn(codes[i]);
            payConfigEntity.setPayNameCn(values[i]);
            payConfigEntity.setIsOpen(true);
            payConfigService.save(payConfigEntity);
        }
    }


    @Test
    void testPerformancePlanEntity() {
        performancePlanService.remove(new QueryWrapper<>());

        String[] types = new String[]{PerformanceStatusEnum.WEEK, PerformanceStatusEnum.MONTH,
                PerformanceStatusEnum.QUARTER, PerformanceStatusEnum.HALF_YEAR, PerformanceStatusEnum.YEAR,};
        for (String type : types) {
            PerformancePlanEntity entity = new PerformancePlanEntity();
            entity.setIsOpen(false);
            entity.setType(type);
            performancePlanService.save(entity);
        }
    }

    @Test
    void testScore() {
        EnumEntity enumEntity;
        String[] codes = new String[]{Score.score_key, Score.desc_key,};
        for (String code : codes) {
            enumEntity = new EnumEntity();
            enumEntity.setUniqueCode(code);
            // enumEntity.setGroupCode("WORKBENCH");
            EnumEntity db = enumService.getOne(new QueryWrapper<>(enumEntity));
            if (db == null) {
                enumService.save(enumEntity);
            }
        }
    }
}