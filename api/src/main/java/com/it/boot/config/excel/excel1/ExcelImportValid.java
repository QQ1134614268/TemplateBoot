package com.it.boot.config.excel.excel1;

import com.it.boot.config.excel.excel1.valid.ExcelDecimalValid;
import com.it.boot.config.excel.excel1.valid.ExcelIntValid;
import com.it.boot.config.excel.excel1.valid.ExcelStrValid;
import com.it.boot.config.excel.excel1.valid.ExcelValid;
import com.it.boot.util.StringUtil;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * <p>Excel导入字段校验</p>
 *
 */
public class ExcelImportValid {

    /**
     * Excel导入字段校验
     *
     * @param object 校验的JavaBean 其属性须有自定义注解
     */
    public static void valid(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            //设置可访问
            field.setAccessible(true);
            //属性的值
            Object fieldValue;
            try {
                fieldValue = field.get(object);
            } catch (IllegalAccessException e) {
                throw new ThrowJsonException(InfoCode.IMPORT_PARAM_CHECK_FAIL, field.getAnnotation(ExcelValid.class).message());
            }

            //是否包含必填校验注解
            boolean isExcelValid = field.isAnnotationPresent(ExcelValid.class);
            if (isExcelValid && Objects.isNull(fieldValue)) {
                throw new ThrowJsonException(InfoCode.IMPORT_PARAM_CHECK_FAIL, field.getAnnotation(ExcelValid.class).message());
            }
            //是否包含字符串长度校验注解
            boolean isExcelStrValid = field.isAnnotationPresent(ExcelStrValid.class);
            if (isExcelStrValid) {
                String cellStr = fieldValue.toString();
                int length = field.getAnnotation(ExcelStrValid.class).length();
                if (!StringUtil.isBlank(cellStr) && cellStr.length() > length) {
                    throw new ThrowJsonException(InfoCode.IMPORT_PARAM_CHECK_FAIL, field.getAnnotation(ExcelStrValid.class).message());
                }
            }
            //是否包含int类型校验注解
            boolean isExcelIntValid = field.isAnnotationPresent(ExcelIntValid.class);
            if (isExcelIntValid) {
                if (fieldValue instanceof Integer) {
                    int cellInt = Integer.parseInt(fieldValue.toString());
                    int min = field.getAnnotation(ExcelIntValid.class).min();
                    int max = field.getAnnotation(ExcelIntValid.class).max();
                    if (cellInt < min || cellInt > max) {
                        throw new ThrowJsonException(InfoCode.IMPORT_PARAM_CHECK_FAIL, field.getAnnotation(ExcelIntValid.class).message());
                    }
                }
            }
            //是否包含decimal类型注解
            boolean isExcelDecimalValid = field.isAnnotationPresent(ExcelDecimalValid.class);
            if (isExcelDecimalValid) {
                if (isBigDecimal(fieldValue.toString())) {
                    BigDecimal cellDecimal = new BigDecimal(fieldValue.toString());
                    BigDecimal min = new BigDecimal(field.getAnnotation(ExcelDecimalValid.class).min());
                    BigDecimal max = new BigDecimal(field.getAnnotation(ExcelDecimalValid.class).max());
                    if (cellDecimal.compareTo(min) < 0 || cellDecimal.compareTo(max) > 0) {
                        throw new ThrowJsonException(InfoCode.IMPORT_PARAM_CHECK_FAIL, field.getAnnotation(ExcelDecimalValid.class).message());
                    }
                } else {
                    throw new ThrowJsonException(InfoCode.IMPORT_PARAM_CHECK_FAIL, "不是小数数字类型");
                }
            }
        }
    }

    private static boolean isBigDecimal(String decimal) {
        try {
            BigDecimal ignore = new BigDecimal(decimal);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}