package com.it.boot.config.excel.excel2;

import com.it.boot.config.Conf;
import com.it.boot.config.exception.ExcelException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ExcelImportUtil<T> {


    public List<T> importExcelDetail(MultipartFile file, Class<T> clazz) throws Exception {
        assertFileType(file);

        Workbook wb = WorkbookFactory.create(file.getInputStream());
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(0);
        // 标题总列数
        int colNum = row.getPhysicalNumberOfCells();
        HashMap<Field, String> fieldColMap = new HashMap<>();
        List<Field> fields = getExcelImportField(clazz); // 有ExcelExport注解的信息属性保留
        for (Field field : fields) {
            ExcelImport excelImport = field.getAnnotation(ExcelImport.class);
            String string = excelImport.columnName();
            fieldColMap.put(field, string);
        }

        HashMap<String, Integer> nameIndexMap = new HashMap<>();

        for (int i = 0; i < colNum; i++) {
            nameIndexMap.put(getCellValue(row.getCell(i)), i);
        }
        assertExcelException(sheet.getLastRowNum() < 1, "文件没有内容");

        List<T> list = new ArrayList<>();
        for (int j = 1; j <= sheet.getLastRowNum(); j++) {// 从第2行开始取数据,默认第一行是表头.
            row = sheet.getRow(j);
            T entity = clazz.newInstance();// 如果不存在实例则新建.
            for (Field field : fields) {
                String name = fieldColMap.get(field);
                Integer index = nameIndexMap.get(name);
                String c = getCellValue(row.getCell(index));// 当前单元格数据--字符串
                ExcelImport excelImport = field.getAnnotation(ExcelImport.class);

                // 1 根据类型值直接转换
                // 对数值型,,,转回double 再转目标类型
                boolean accessible = field.isAccessible();
                field.setAccessible(true);

                assertExcelException(!excelImport.emptyAble() && c == null, "必填列不能为空");
                if (c == null) {
                    continue;
                }

                Class<?> fieldType = field.getType();

                if (String.class == fieldType) {
                    field.set(entity, c);
                } else if ((Integer.TYPE == fieldType) || (Integer.class == fieldType)) {
                    field.set(entity, Double.valueOf(c).intValue());
                } else if ((Long.TYPE == fieldType) || (Long.class == fieldType)) {
                    field.set(entity, Double.valueOf(c).longValue());
                } else if ((Float.TYPE == fieldType) || (Float.class == fieldType)) {
                    field.set(entity, Double.valueOf(c).floatValue());
                } else if ((Short.TYPE == fieldType) || (Short.class == fieldType)) {
                    field.set(entity, Double.valueOf(c).shortValue());
                } else if ((Double.TYPE == fieldType) || (Double.class == fieldType)) {
                    field.set(entity, Double.valueOf(c));
                } else if ((Boolean.TYPE == fieldType) || (Boolean.class == fieldType)) {
                    field.set(entity, Boolean.valueOf(c));
                } else if (Date.class == fieldType) {// Date 数据类型 eg: 2019-02-21 20:57:38
                    // 1.使用字符串类型
                    // 2 在Excel中是数字类型,转data
                    SimpleDateFormat sdf = new SimpleDateFormat(Conf.DATE_TIME_FORMAT);
                    field.set(entity, sdf.parse(c));
                } else if (Character.TYPE == fieldType) {
                    if (c.length() > 0) {
                        field.set(entity, c.charAt(0));
                    }
                }
                field.setAccessible(accessible);
            }
            list.add(entity);
        }
        return list;
    }

    private static void assertExcelException(boolean condition, String errMsg) throws ExcelException {
        // Assertions.assertTrue(condition, errMsg);
        if (condition) {
            throw new ExcelException(errMsg);
        }
    }

    private static void assertFileType(MultipartFile file) throws ExcelException {
        String fileName = file.getOriginalFilename();
        assertExcelException(fileName == null || !(fileName.endsWith(".xls") || fileName.endsWith(".xlsx")), "文件只能为 xls xlsx 格式");
    }

    /**
     * 获取excel 单元格数据
     */
    private String getCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        String value = null;
        switch (cell.getCellType()) {
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {// 时间格式
                    Date date = cell.getDateCellValue();
                    SimpleDateFormat sdf = new SimpleDateFormat(Conf.DATE_TIME_FORMAT);
                    value = sdf.format(date);
                    break;
                }

                value = String.valueOf(cell.getNumericCellValue());
                break;
            case BOOLEAN:
                value = String.valueOf(cell.getBooleanCellValue());
                break;
            case STRING:
            case BLANK:
                value = cell.getStringCellValue();
                break;
            default:
                break;
        }
        return value;
    }

    private List<Field> getExcelImportField(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        List<Field> list = new ArrayList<>(fields.length);
        for (Field f : fields) { // 遍历tClass中的属性
            if (f.isAnnotationPresent(ExcelImport.class)) { // 有ExcelExport注解的信息属性保留
                list.add(f);
            }
        }
        return list;
    }

    /**
     * @return 获取字符串数组的元素的位置 ; 不存在时 ,返回 -1
     */
    public static int getValueIndex(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isRowEmpty(Row row, int start, int end) {
        for (int c = start; c < end; c++) {
            Cell cell = row.getCell(c);
            if (cell != null && cell.getCellType() != CellType.BLANK)
                return false;
        }
        return true;
    }
}
