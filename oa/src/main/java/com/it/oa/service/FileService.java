package com.it.oa.service;

import com.it.oa.config.exception.OaGlobalException;
import com.it.oa.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {
    private static final String UPLOAD_PATH = Paths.get(System.getProperty("user.dir"), "data/upload").toString();
    @Resource
    HttpServletResponse response;

    public String upload(MultipartFile file) throws IOException {
        Path uploadDir = Paths.get(UPLOAD_PATH);
        if (!Files.isDirectory(uploadDir)) {
            Files.createDirectories(uploadDir);
        }
        String newName = FileUtil.getFileName(file.getOriginalFilename());
        Path path = Paths.get(UPLOAD_PATH, newName);
        Files.write(path, file.getBytes());
        return newName;
    }

    public void download(String path, String fileName) throws IOException {
        Path filePath = Paths.get(UPLOAD_PATH, path);
        if (!Files.exists(filePath)) {
            throw new OaGlobalException("文件不存在!");
        }
        try (ServletOutputStream outputStream = response.getOutputStream()) {
            byte[] bytes = Files.readAllBytes(filePath);
            response.reset(); // 清空response
            response.setCharacterEncoding("UTF-8");
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            outputStream.write(bytes);
        }
    }

    public void download(String path) throws IOException {
        download(path, path);
    }

    public long getSize(String path) throws IOException {
        return Files.size(Paths.get(path));
    }
}
