package com.it.boot.config.gen;

import com.it.boot.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class ScriptTest {
    String systemPath = System.getProperty("user.dir");

    @Test
    void createEntity() throws IOException {
        String src = "/src/main/java/";
        func2(src, UserEntity.class, "/templates/entity.java.vm");
    }

    // @Test
    // void createMapper() throws IOException {
    //     String src = "/src/main/java/";
    //     func(src, UserMapper.class, "/templates/mapper.java.vm");
    // }
    //
    // @Test
    // void createService() throws IOException {
    //     String src = "/src/main/java/";
    //     func(src, UserService.class, "/templates/serviceImpl.java.vm");
    // }
    //
    // @Test
    // void createController() throws IOException {
    //     String src = "/src/main/java/";
    //     func(src, UserController.class, "/templates/controller.java.vm");
    // }
    //
    // @Test
    // void createTest() throws IOException {
    //     String src = "/src/test/java/";
    //     func(src, UserControllerTest.class, "/templates/test.java.vm");
    // }

    public void func2(String src, Class<?> clazz, String outPath) throws IOException {
        String s = getPath(clazz, src);

        List<String> ss;
        try (BufferedReader bfr = Files.newBufferedReader(Paths.get(s))) {
            ss = bfr.lines().collect(Collectors.toList());
        }
        String txt = String.join(System.lineSeparator(), ss);
        String pPath = clazz.getPackage().getName();

        String newTxt = txt.replace("员工模块", "${tableComment}")
                .replace(pPath.substring(0, pPath.lastIndexOf(".")), "${packageName}")
                .replace("user", "${tableLowerCamel}")
                .replace("User", "${tableUpperCamel}")
                .replace("String", "${column.javaType}")
                .replace("phone", "${column.javaColumnName}")
                .replace("手机号", "${column.column_comment}")
                .replace("javaColumnExample", "${column.javaColumnExample}")
                .replace("varchar(255)", "${column.data_type}")
                .replace("unique = false", "unique = ${column.unique}")
                .replace("require = false", "require = ${column.nullable}")
                .replace("nullable = false", "nullable = ${column.nullable}")
                .replace("// ", "");
        String oPath = getOutPath(outPath);
        try (BufferedWriter bfw = Files.newBufferedWriter(Paths.get(oPath), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            bfw.write(newTxt);
        }
    }

    public String getPath(Class<?> clazz, String src) {
        String packagePath = clazz.getName();
        return systemPath + src + packagePath.replace(".", "/") + ".java";
    }

    public String getOutPath(String tPath) {
        String rSrc = "/src/main/resources";
        return systemPath + rSrc + tPath;
    }
}
