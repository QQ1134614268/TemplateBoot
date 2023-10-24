package com.it.jiangxin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.it.jiangxin.config.enum1.GroupCodeEnum;
import com.it.jiangxin.config.enum1.IEnumDb;
import com.it.jiangxin.config.enum1.ResultEnum;
import com.it.jiangxin.config.enum1.SexEnum;
import com.it.jiangxin.entity.EnumEntity;
import com.it.jiangxin.entity.UserEntity;
import com.it.jiangxin.service.EnumService;
import com.it.jiangxin.service.UserService;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class InitTestEnvDbTest {
    @Resource
    EnumService enumService;
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
    void test_2_customer() {
        List<String> list = Arrays.asList("中式", "日式", "欧式");//"最火", "曾看过"
        for (String v : list) {
            EnumEntity enumEntity = new EnumEntity();
            enumEntity.setGroupCode("IMG-TYPE");
            // enumEntity.setUniCode(UUID.randomUUID().toString());
            enumEntity.setValue(v);
            EnumEntity one = enumService.getOne(new QueryWrapper<>(enumEntity));
            if (one == null) {
                enumService.saveOrUpdate(enumEntity);
            }
        }
    }

    @Test
    void test_3_group_code() {
        List<String> list = Collections.singletonList("imgType");
        for (String v : list) {
            EnumEntity enumEntity = new EnumEntity();
            enumEntity.setGroupCode("GroupCodeEnum");
            enumEntity.setValue(v);
            EnumEntity one = enumService.getOne(new QueryWrapper<>(enumEntity));
            if (one == null) {
                enumService.saveOrUpdate(enumEntity);
            }
        }

        GroupCodeEnum[] va = GroupCodeEnum.values();
        for (GroupCodeEnum groupCodeEnum : va) {
            EnumEntity enumEntity = new EnumEntity();
            enumEntity.setGroupCode("GroupCodeEnum");
            enumEntity.setValue(groupCodeEnum.getUniCode());
            enumEntity.setValue(groupCodeEnum.getValue());
            EnumEntity one = enumService.getOne(new QueryWrapper<>(enumEntity));
            if (one == null) {
                enumService.saveOrUpdate(enumEntity);
            }
        }
    }

    @Test
    void test_3_group2_code() {
        // 反射 获取方法
        Class<?>[] tables = {SexEnum.class, ResultEnum.class};
        for (Class<?> clz : tables) {
            Object[] arr = clz.getEnumConstants();

            for (Object obj : arr) {
                IEnumDb enum1 = (IEnumDb) obj;
                EnumEntity enumEntity = new EnumEntity();
                enumEntity.setGroupCode("GroupCodeEnum");
                enumEntity.setValue(enum1.getUniCode());
                enumEntity.setValue(enum1.getValue());
                enumEntity.setValue(enum1.getLabel());
                EnumEntity one = enumService.getOne(new QueryWrapper<>(enumEntity));
                if (one == null) {
                    enumService.saveOrUpdate(enumEntity);
                }
            }
        }
    }
}