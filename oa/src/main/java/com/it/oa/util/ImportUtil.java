package com.it.oa.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.event.AnalysisEventListener;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class ImportUtil {
    public static <T> void read(MultipartFile file, Class<T> clazz, AnalysisEventListener<T> listener) throws IOException {
        EasyExcel.read(file.getInputStream(), clazz, listener).sheet().doRead();
    }
}