package com.it.boot.config.excel.excel2;

import com.it.boot.config.excel.excel2.ExcelImport;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserImportVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ExcelImport(columnName = "用户id", emptyAble = false)
    private Integer id;

    @ExcelImport(columnName = "姓名", emptyAble = false)
    private String name;

    @ExcelImport(columnName = "生日")
    private Date date;

    @ExcelImport(columnName = "性别")
    private Boolean sex;

    @ExcelImport(columnName = "幸运点")
    private Double luckyNum;

    @ExcelImport(columnName = "姓名副本")
    private String name2;

    private String ignore = "ignore";

}
