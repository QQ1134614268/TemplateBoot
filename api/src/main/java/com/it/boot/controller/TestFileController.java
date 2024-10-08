package com.it.boot.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://blog.csdn.net/blueheart20/article/details/79306032
// 从Spring Boot JAR加载文件
// 如果要在Spring Boot JAR中从类路径加载文件，则必须使用该resource.getInputStream()方法将其作为InputStream进行检索。
// 如果您尝试使用，resource.getFile()您将收到错误，因为Spring尝试访问文件系统路径，但它无法访问JAR中的路径。
@Tag(name = "测试/TestFileController")
@RestController
@RequestMapping("/api/TestFileController")
public class TestFileController {
    public static final String FILE = "test/test.txt";
    //	何为classpath
    //	在Maven项目中，所有的resources文件都将被复制到classes目录下。classpath在tomcat项目中就是/classes，/lib和tomcat下的其他路径。
    //	对于开发者来说，一般就是classes所在目录就是classpath路径的起点和base path.

    @Operation(summary = "getFileClasspath")
    @GetMapping("/getFileClasspath")
    public List<String> getFileClasspath() throws IOException {
        File file = ResourceUtils.getFile("classpath:" + FILE);
        FileReader fileReader = new FileReader(file);
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            return getLines(bufferedReader);
        }
    }

    @Operation(summary = "getFileClassPathResource")
    @GetMapping("/getFileClassPathResource")
    public List<String> getFileClassPathResource() throws IOException {
        Resource resource = new ClassPathResource("a.txt");
        File file = resource.getFile();
        try (FileReader fileReader = new FileReader(file); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            return getLines(bufferedReader);
        }
    }

    @Operation(summary = "getFileAsStream")
    @GetMapping("/getFileAsStream")
    public List<String> getFileAsStream() throws IOException {
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(FILE);
        if (inputStream == null) {
            return Collections.emptyList();
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            return getLines(br);
        }
    }

    private List<String> getLines(BufferedReader bufferedReader) throws IOException {
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }

}
