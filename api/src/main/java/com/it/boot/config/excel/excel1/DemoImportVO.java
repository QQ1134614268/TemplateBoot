package com.it.boot.config.excel.excel1;

import com.alibaba.excel.annotation.ExcelProperty;
import com.it.boot.config.excel.excel1.valid.ExcelDecimalValid;
import com.it.boot.config.excel.excel1.valid.ExcelIntValid;
import com.it.boot.config.excel.excel1.valid.ExcelStrValid;
import com.it.boot.config.excel.excel1.valid.ExcelValid;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>导入Demo类</p>
 * <p>@ExcelProperty(index = 0) 读下标为0的单元格数据，即第一个单元格</p>
 * <p>@ExcelProperty("字符串标题") 读表头相同的单元格数据,如果名字重复，会导致只有一个字段读取到数据</p>
 * <p>这里不建议 index 和 name 同时用，要么一个对象只用index，要么一个对象只用name去匹配</p>
 *
 */
@Data
public class DemoImportVO {

    /**
     * 读第一个单元格
     */
    @ExcelProperty(index = 0)
    @ExcelValid(message = "no不能为空")
    @ExcelIntValid(min = 1, max = 3, message = "no最小为1，最大为3")
    private Integer no;

    @ExcelProperty(index = 1)
    @ExcelValid(message = "name不能为空")
    @ExcelStrValid(length = 3, message = "name最大为3个长度")
    private String name;

    @ExcelDecimalValid(min = "1", max = "3", message = "价格1最小为1最大为3")
    private BigDecimal price1;
}