package com.it.boot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.it.boot.config.enum1.GroupCodeEnum;
import com.it.boot.config.enum1.IEnumDb;
import com.it.boot.config.enum1.SexEnum;
import com.it.boot.entity.SysEnumEntity;
import com.it.boot.entity.UserEntity;
import com.it.boot.service.SysEnumService;
import com.it.boot.service.UserService;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class InitTestEnvDbTest {
    @Resource
    SysEnumService sysEnumService;
    @Resource
    UserService userService;

    @Test
    void test_1_customer() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("admin");
        userEntity.setPassword("123456");
        userEntity.setAvatar("");
        LocalDate localDate = LocalDate.of(2000, 1, 1);
        userEntity.setBirthDay(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        long count = userService.count(new QueryWrapper<>(userEntity));
        if (count == 0) {
            userService.saveOrUpdate(userEntity);
        }
    }


    @Test
    void test_3_group_code() {
        List<String> list = Collections.singletonList("imgType");
        for (String v : list) {
            SysEnumEntity sysEnumEntity = new SysEnumEntity();
            sysEnumEntity.setGroupCode("GroupCodeEnum");
            sysEnumEntity.setValue(v);
            SysEnumEntity one = sysEnumService.getOne(new QueryWrapper<>(sysEnumEntity));
            if (one == null) {
                sysEnumService.saveOrUpdate(sysEnumEntity);
            }
        }

        GroupCodeEnum[] va = GroupCodeEnum.values();
        for (GroupCodeEnum groupCodeEnum : va) {
            SysEnumEntity sysEnumEntity = new SysEnumEntity();
            sysEnumEntity.setGroupCode("GroupCodeEnum");
            sysEnumEntity.setValue(groupCodeEnum.getValue());
            SysEnumEntity one = sysEnumService.getOne(new QueryWrapper<>(sysEnumEntity));
            if (one == null) {
                sysEnumService.saveOrUpdate(sysEnumEntity);
            }
        }
    }

    @Test
    void test_3_group2_code() {
        // 反射 获取方法
        Class<?>[] tables = {SexEnum.class};
        for (Class<?> clz : tables) {
            Object[] arr = clz.getEnumConstants();

            for (Object obj : arr) {
                IEnumDb enum1 = (IEnumDb) obj;
                SysEnumEntity sysEnumEntity = new SysEnumEntity();
                sysEnumEntity.setGroupCode("GroupCodeEnum");
                sysEnumEntity.setValue(String.valueOf(enum1.getValue()));
                sysEnumEntity.setValue(enum1.getLabel());
                SysEnumEntity one = sysEnumService.getOne(new QueryWrapper<>(sysEnumEntity));
                if (one == null) {
                    sysEnumService.saveOrUpdate(sysEnumEntity);
                }
            }
        }
    }
}