package com.it.oa.auto;

import com.it.oa.entity.UserOrgEntity;
import com.it.oa.util.GetClassUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * 自定义模板 代码生成器
 */
@Slf4j
@SpringBootTest
public class AutoCodeTestV2 {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Test
    void test() throws IOException, ClassNotFoundException {
        String SRC_MAIN_JAVA = "/src/main/java/";
        String SRC_TEST_JAVA = "/src/test/java/";

        AutoCode.Arg entity = new AutoCode.Arg("com.subin.oa.entity.%sEntity", "templates/entity.java.vm", "huangran", SRC_MAIN_JAVA);
        AutoCode.Arg mapper = new AutoCode.Arg("com.subin.oa.mapper.%sMapper", "templates/mapper.java.vm", "huangran", SRC_MAIN_JAVA);
        AutoCode.Arg service = new AutoCode.Arg("com.subin.oa.service.%sService", "templates/serviceImpl.java.vm", "huangran", SRC_MAIN_JAVA);
        AutoCode.Arg controller = new AutoCode.Arg("com.subin.oa.controller.%sController", "templates/controller.java.vm", "huangran", SRC_MAIN_JAVA);
        AutoCode.Arg test = new AutoCode.Arg("com.subin.oa.controller.%sControllerTest", "templates/test.java.vm", "huangran", SRC_TEST_JAVA);

        // Class[] tables = GetClassUtil.getClassByPackage(BaseEntity.class.getPackage().getName()).stream().toArray(Class[]::new);
        Class[] tables = {UserOrgEntity.class};
        AutoCode.Arg[] args = {mapper, service,};
        for (Class clazz : tables) {
            for (AutoCode.Arg arg : args) {
                String tableName = GetClassUtil.getTableName(clazz);
                if (tableName != null) AutoCode.toFile(jdbcTemplate, tableName, arg);
            }
        }
    }
}

