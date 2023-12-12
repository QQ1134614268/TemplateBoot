package com.it.boot.config.excel.excel1;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.event.AnalysisEventListener;
import com.it.boot.config.enum1.ResCodeEnum;
import com.it.boot.config.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>导入工具类 使用EasyExcel</p>
 */
@Slf4j
public class ImportUtil {
    public static <T> void read(MultipartFile file, Class<T> clazz, AnalysisEventListener<T> listener) {
        try {
            EasyExcel.read(file.getInputStream(), clazz, listener).sheet().doRead();
        } catch (Exception e) {
            log.warn("import file error: ", e);
            throw new BizException(ResCodeEnum.RES_FAILURE.getCode(), "导入失败异常信息");
        }
    }
}