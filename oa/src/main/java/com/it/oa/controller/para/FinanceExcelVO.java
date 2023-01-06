package com.it.oa.controller.para;


import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.it.oa.config.ConstConf;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class FinanceExcelVO {
    @ExcelProperty(value = {"账目类型"}, index = 0)
    private String category;
    @ExcelProperty(value = "账目分类", index = 1)
    private String type;
    @ExcelProperty(value = "备注信息", index = 2)
    private String note;
    @ExcelProperty(value = "收支时间", index = 3)
    @DateTimeFormat(value = ConstConf.DATE_TIME_FORMAT)
    private Date payTime;
    @ExcelProperty(value = "支付方式", index = 4)
    private String payType;
    @ExcelProperty(value = "金额(元)", index = 5)
    private BigDecimal financeMoney;
}