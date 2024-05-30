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
        userEntity.setUserName("test");
        userEntity.setPassword("test");
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
}