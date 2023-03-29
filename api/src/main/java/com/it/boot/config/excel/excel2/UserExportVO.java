package com.it.boot.config.excel.excel2;

import com.it.boot.config.excel.excel2.ExcelExport;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserExportVO implements Serializable {

    @ExcelExport(position = 0, columnName = "用户id")
    private Integer id;

    @ExcelExport(position = 1, columnName = "姓名")
    private String name;

    @ExcelExport(position = 2, columnName = "生日")
    private Date date;

    @ExcelExport(position = 3, columnName = "性别")
    private Boolean sex;

    @ExcelExport(position = 4, columnName = "幸运点")
    private Double luckyNum;

    @ExcelExport(position = 5, columnName = "姓名副本")
    private String name2;

    private String ignore = "ignore";

}
