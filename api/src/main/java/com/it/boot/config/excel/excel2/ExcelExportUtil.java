package com.it.boot.config.excel.excel2;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class ExcelExportUtil<T> {

    public static final String DATE_FORMAT_STR = "yyyy-MM-dd";

    public SXSSFWorkbook exportExcel(String title, String[] headers, String[] beanFields, Collection<T> dataset,
                                     String pattern) {
        SXSSFWorkbook workbook = new SXSSFWorkbook();// 生成一个excel
        writeToSheet(workbook, title, headers, beanFields, dataset, pattern);
        return workbook;
    }

    public void writeToSheet(SXSSFWorkbook workbook, String title, String[] headers, String[] beanFields,
                             Collection<T> dataset, String pattern) {
        if (pattern == null) {
            pattern = DATE_FORMAT_STR;
        }
        SXSSFSheet sheet = workbook.createSheet(title);// 生成一个表格

        sheet.setDefaultColumnWidth(20);// 设置表格默认列宽度为15个字节
        int rowNum = 0;
        SXSSFRow row = sheet.createRow(rowNum);
        SXSSFCell cell;
        for (int i = 0; i < headers.length; i++) {
            cell = row.createCell(i);
//			cell.setCellStyle(style);	// 设置样式 
            cell.setCellValue(new XSSFRichTextString(headers[i]));
        }

        // 遍历集合数据，产生数据行
        Iterator<T> it = dataset.iterator();
        T t;
        Object value;
        String textValue;
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        while (it.hasNext()) {
            rowNum++;
            row = sheet.createRow(rowNum);
            t = (T) it.next();
            for (int i = 0; i < beanFields.length; i++) {
                cell = row.createCell(i);
                value = getFieldValueByFieldName(beanFields[i], t);
                textValue = null;
                if (value instanceof Integer) { // int
                    cell.setCellValue((Integer) value);
                } else if (value instanceof Float) {
                    textValue = String.valueOf((Float) value);
                    cell.setCellValue(textValue);
                } else if (value instanceof Double) {
                    textValue = String.valueOf((Double) value);
                    cell.setCellValue(textValue);
                } else if (value instanceof Long) {
                    cell.setCellValue((Long) value);
                } else if (value instanceof Boolean) {
                    textValue = "是";
                    if (!(Boolean) value) {
                        textValue = "否";
                    }
                    cell.setCellValue(textValue);
                } else if (value instanceof Date) {
                    textValue = sdf.format((Date) value);
                    cell.setCellValue(textValue);
                } else {
                    // 其它数据类型都当作字符串简单处理
                    if (value != null) {
                        textValue = value.toString();
                        cell.setCellValue(new XSSFRichTextString(textValue));
                    } else {
                        cell.setCellValue(""); // value=null 设置空串,或者不设值
                    }
                }
            }
        }
    }

    public CellStyle getHeaderStyle(SXSSFWorkbook workbook) {
        CellStyle style = workbook.createCellStyle();

        // 设置这些样式
//		style.setFillForegroundColor( );
//		style.setFillPattern(SXSSFCellStyle.SOLID_FOREGROUND);
//		style.setBorderBottom(SXSSFCellStyle.BORDER_THIN);
//		style.setBorderLeft(SXSSFCellStyle.BORDER_THIN);
//		style.setBorderRight(SXSSFCellStyle.BORDER_THIN);
//		style.setBorderTop(SXSSFCellStyle.BORDER_THIN);
//		style.setAlignment(SXSSFCellStyle.ALIGN_CENTER);
//		// 生成一个字体
//		SXSSFFont font = workbook.createFont();
//		font.setColor(SXSSFColor.VIOLET.index);
//		font.setFontHeightInPoints((short) 12);
//		font.setBoldweight(SXSSFFont.BOLDWEIGHT_BOLD);
//		// 把字体应用到当前的样式
//		style.setFont(font);

        return style;

    }

    public CellStyle getStyle(SXSSFWorkbook workbook) {
        CellStyle style = workbook.createCellStyle();
//		style.setFillForegroundColor(SXSSFColor.LIGHT_YELLOW.index);
//		style.setFillPattern(SXSSFCellStyle.SOLID_FOREGROUND);
//		style.setBorderBottom(SXSSFCellStyle.BORDER_THIN);
//		style.setBorderLeft(SXSSFCellStyle.BORDER_THIN);
//		style.setBorderRight(SXSSFCellStyle.BORDER_THIN);
//		style.setBorderTop(SXSSFCellStyle.BORDER_THIN);
//		style.setAlignment(SXSSFCellStyle.ALIGN_CENTER);
//		style.setVerticalAlignment(SXSSFCellStyle.VERTICAL_CENTER);
//		// 生成另一个字体
//		SXSSFFont font2 = workbook.createFont();
//		font2.setBoldweight(SXSSFFont.BOLDWEIGHT_NORMAL);
//		// 把字体应用到当前的样式
//		style.setFont(font2);
        return style;

    }

    public void writeToResponse(Workbook workbook, String fileName, HttpServletResponse response) throws IOException {
        fileName = new String(fileName.getBytes(), "iso8859-1") + ".xlsx";
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setContentType("application/force-download");// 设置强制下载不打开
        response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
        try (OutputStream os = new BufferedOutputStream(response.getOutputStream());) {
            workbook.write(os);// 将excel写入到输出流中
            os.flush();
        }
    }

    /**
     * 根据属性名获取属性值
     *
     * @param fieldName object
     */
    public static Object getFieldValueByFieldName(String fieldName, Object object) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            // 设置对象的访问权限，保证对private的属性的访问
            field.setAccessible(true); // 恢复原来的可见性
            return field.get(object);
        } catch (Exception e) {
            String message = String.format("类 [%s] 反射访问属性 [%s] 异常!", object.getClass().getCanonicalName(), fieldName);
            throw new RuntimeException(message, e);
        }
    }
}
