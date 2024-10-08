package com.it.sim.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @date 2022-09-30 11:46
 * 读取:
 *      Class.getResourceAsStream
 *      ClassLoad.getResourceAsStream
 *      ClassLoad.getResource  -> 没有/会添加basePackage,
 *      URL.open
 *      InputStream
 * --
 *      Class.getResource:
 *          判断name是否以 / 开头, 没有添加basePackage, 返回去掉/的路径
 *          ClassLoader.getResource 使用父ClassLoader加载路径
 */
@Slf4j
public class TestReadJarFile {

    public static final String TEST_TEST_TXT = "test/test.txt";
    public static final String DATA = "Hello,World!";

    @Test
    public void readClassResource() {
        Class<?> clz = TestReadJarFile.class; // Test.class;
        String className = clz.getSimpleName() + ".class";
        // 1 返回 target/classes/package
        System.out.println(clz.getResource(""));
        // 2 同级（编译路径）下，是否存在对应文件，存在则返回该地址
        System.out.println(clz.getResource(className));
        // 3 不存在，返回 null
        System.out.println(clz.getResource("no" + className));

        // 4 返回 target/classes/
        System.out.println(clz.getResource("/"));
        // 5 target/classes/ 目录下存在 test
        System.out.println(clz.getResource("/test"));
        // 6 target/classes/ 目录下不存在 testNo
        System.out.println(clz.getResource("/no" + "testNoExist"));
    }

    @Test
    public void readClassLoaderResource() {
        Class<?> clz = TestReadJarFile.class;// Test.class;
        String className = clz.getSimpleName() + ".class";
        ClassLoader classLoader = clz.getClassLoader();
        System.out.println(classLoader.getResource(""));
        System.out.println(classLoader.getResource(className));
        System.out.println(classLoader.getResource("no" + className));

        System.out.println(classLoader.getResource("/"));
        System.out.println(clz.getResource("/test"));
        System.out.println(clz.getResource("/" + "testNoExist"));

        // ---------------------------
        System.out.println(clz.getPackage().getName());
        System.out.println(clz.getName());
        System.out.println(clz.getSimpleName());
        System.out.println(System.getProperty("user.dir")); // 项目目录

    }

    @Test
    public void testClass() throws IOException {
        Class<?> clazz = TestReadJarFile.class;
        // 当前jar包下文件
        InputStream inputStream = clazz.getResourceAsStream("/" + TEST_TEST_TXT); // 本质时ClassLoader
        String data = readFromInputStream(inputStream);
        System.out.println(data);

        // junit jar包下 LICENSE-junit.txt文件
        InputStream inputStream2 = clazz.getResourceAsStream("/LICENSE-junit.txt");
        String data2 = readFromInputStream(inputStream2);
        System.out.println(data2);
    }

    @Test
    public void testClassLoader() throws IOException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(TEST_TEST_TXT);
        String data = readFromInputStream(inputStream);
        Assert.assertEquals(DATA, data.trim());
    }


    @Test
    public void testClassPathResource() throws IOException {
        // 获取 resources 文件流
        Resource classPathResource = new ClassPathResource(TEST_TEST_TXT);
        InputStream inputStream = classPathResource.getInputStream();
        String data = readFromInputStream(inputStream);
        Assert.assertEquals(DATA, data.trim());
    }

    private String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
}
