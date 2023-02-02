package com.it.boot.config.excel.excel2;

import com.it.boot.config.exception.ExcelException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelImportUtil<T> {

    private Class<T> clazz;
    String dateFormat = "yyyy-MM-dd HH:mm:ss";

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public ExcelImportUtil(Class<T> clazz) {
        this.clazz = clazz;
    }

    public List<T> importExcelDetail(MultipartFile file, T t) throws Exception {
        String fileName = file.getOriginalFilename();
        if (fileName == null || !(fileName.endsWith(".xls") || fileName.endsWith(".xlsx"))) {
            throw new ExcelException();
        }
        Workbook wb = WorkbookFactory.create(file.getInputStream());
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(0);
        // 标题总列数
        int colNum = row.getPhysicalNumberOfCells();
        List<Field> fields = getField(t.getClass()); // 有ExcelExport注解的信息属性保留
        String[] title = new String[colNum];// 表格头,顺序
        for (int i = 0; i < colNum; i++) {
            title[i] = getCellValue(row.getCell(i));
        }
        if (sheet.getLastRowNum() < 1) {
            throw new ExcelException();
        }
        int[] index = new int[fields.size()];
        for (int i = 0; i < fields.size(); i++) {
            ExcelImport excelImport = fields.get(i).getAnnotation(ExcelImport.class);
            String string = excelImport.columnName();
            index[i] = getValueIndex(title, string);// 字段上columnName对应 表格头中 位置
        }

        List<T> list = new ArrayList<>();
        for (int j = 1; j <= sheet.getLastRowNum(); j++) {// 从第2行开始取数据,默认第一行是表头.
            row = sheet.getRow(j);
            T entity = clazz.newInstance();// 如果不存在实例则新建.
            for (int i = 0; i < fields.size(); i++) {
                String c = getCellValue(row.getCell(i));// 当前单元格数据--字符串
                ExcelImport excelImport = fields.get(i).getAnnotation(ExcelImport.class);
                if (excelImport.emptyAble()) {
                    // TODO emptyAble 的逻辑
                }

                // 1 根据类型值直接转换
                // 对数值型,,,转回double 再转目标类型

                boolean b = fields.get(i).isAccessible();
                fields.get(i).setAccessible(true);

                Field field = fields.get(i);
                Class<?> fieldType = field.getType();

                if (String.class == fieldType) {
                    field.set(entity, String.valueOf(c));
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
                    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
                    field.set(entity, sdf.parse(c));
                } else if (Character.TYPE == fieldType) {
                    if ((c != null) && (c.length() > 0)) {
                        field.set(entity, Character.valueOf(c.charAt(0)));
                    }
                }
                fields.get(i).setAccessible(b);
            }
            list.add(entity);
        }
        return list;
    }

    /**
     * 获取excel 单元格数据
     */
    private String getCellValue(Cell cell) { // 直接获取单元格类型,转换???? TODO
        if (cell == null) {
            return "";
        }
        String value = "";
        switch (cell.getCellType()) {
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {// 时间格式
                    Date date = cell.getDateCellValue();
                    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
                    value = sdf.format(date);
//				DataFormatter dataFormatter = new DataFormatter();
//				Format format = dataFormatter.createFormat(cell);
//				value = format.format(date);
                    break;
                }

                value = String.valueOf(cell.getNumericCellValue());
                break;
            case BOOLEAN:
                value = String.valueOf(cell.getBooleanCellValue());
                break;
            case STRING:
                value = cell.getStringCellValue();
                break;
            case BLANK:
                value = "";
                break;
            default:
                value = "";
                break;
        }
        return value;
    }

    private List<Field> getField(Class<?> clazz) {
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
