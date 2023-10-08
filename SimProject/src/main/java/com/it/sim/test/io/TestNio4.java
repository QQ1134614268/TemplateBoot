package com.it.sim.test.io;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @date 2022-09-30 11:46
 */
public class TestNio4 {
    @Test
    public void readResourceDirFile() throws IOException, URISyntaxException {
        String path = "a.txt";
        // String path = "/a.txt";
        URI uri = this.getClass().getClassLoader().getResource(path).toURI();
        List<String> lines = Files.readAllLines(Paths.get(uri));
        lines.forEach(System.out::println);
    }

    @Test
    public void test_3() throws IOException {
        // 获取 resources 文件流
        Resource classPathResource = new ClassPathResource("a.txt");
        InputStream inputStream = classPathResource.getInputStream();

        String outFilePath = (new File(".")).getCanonicalPath().concat(String.format("/tmp-file-%s", System.currentTimeMillis()));
        // 将 InputStream 复制输出到 指定文件上
        File file = new File(outFilePath);
        Files.copy(inputStream, file.toPath());
        // 关闭输入流
        inputStream.close();
        System.out.printf("文件是否存在: %s%n", file.exists());
    }


    @Test
    public void test6() {
        System.out.println(TestNio4.class);
        System.out.println(TestNio4.class.getPackage().getName());
        System.out.println(TestNio4.class.getName());
        System.out.println(TestNio4.class.getSimpleName());
        System.out.println(System.getProperty("user.dir")); // 项目目录

        // Class.getResource() : 如果以 "/" 开头，就在classpath根目录下找;
        //      如果不以 "/" 开头，就在调用getResource的字节码对象所在目录下找
        // ClassLoader.getResource() ??
        // Class.getClassLoader() ??
        // URL.getPath
        // this.getClass() 与 TestFilePath.class 相同
        // Thread.currentThread().getContextClassLoader()
        String className = TestNio4.class.getSimpleName();
        System.out.println(TestNio4.class.getResource(""));
        System.out.println(TestNio4.class.getResource("."));
        System.out.println(TestNio4.class.getResource("/"));
        System.out.println(TestNio4.class.getResource(className));
        System.out.println(TestNio4.class.getResource("/" + className)); // null

        System.out.println(TestNio4.class.getClassLoader());
        System.out.println(TestNio4.class.getClassLoader().getResource(""));
        System.out.println(TestNio4.class.getClassLoader().getResource(className));
        System.out.println(TestNio4.class.getClassLoader().getResource("/")); // null

        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));

    }
}
