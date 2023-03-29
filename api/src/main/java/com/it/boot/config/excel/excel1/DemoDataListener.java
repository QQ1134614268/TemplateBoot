package com.it.boot.config.excel.excel1;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.exception.ExcelDataConvertException;
import com.baomidou.mybatisplus.extension.service.IService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>EasyExcel监听的demo</p>
 *
 */
@Slf4j
public class DemoDataListener extends AnalysisEventListener<DemoImportVO> {
    // service的名称
    private IService<DemoImportVO> iService;
    List<DemoImportVO> list = new ArrayList<>();

    // 构造函数，也是控制层进来的时候需要传入两个参数
    public DemoDataListener(IService<DemoImportVO> iService) {
        this.iService = iService;
    }

    /**
     * <p>每一条数据解析后，调用此方法</p>
     */
    @Override
    public void invoke(DemoImportVO data, AnalysisContext context) {
        // 通用方法数据校验
        ExcelImportValid.valid(data);
        // 将解析完的数据加入到list中
        list.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        // 方法名 阿落是只要涉及导入操作，都会在业务层接口和实现类定义方法为`saveBatch`
        // 这样可以在方法中扩展比如不存在则插入
        int READ_BATCH_COUNT_10 = 10000;
        if (list.size() >= READ_BATCH_COUNT_10) {
            this.execute();
        }
    }

    /**
     * <p>所有数据解析完成后调用此方法</p>
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 保存数据，确保最后的遗留数据也能保存到数据库或者进行其他操作
        this.execute();
    }

    /**
     * <p>数据转换异常时的处理，比如required是Integer，provided是"sss"的字符串</p>
     */
    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {
        if (exception instanceof ExcelDataConvertException) {
            Integer columnIndex = ((ExcelDataConvertException) exception).getColumnIndex() + 1;
            Integer rowIndex = ((ExcelDataConvertException) exception).getRowIndex() + 1;
            String message = String.format("第%s行，第%s列数据格式有误，请核实", rowIndex, columnIndex);
            throw new ThrowJsonException(InfoCode.IMPORT_PARAM_ERROR, message);
        } else if (exception instanceof RuntimeException) {
            throw exception;
        } else {
            super.onException(exception, context);
        }
    }

    // 执行数据保存的操作
    public void execute() {
        iService.saveBatch(list);
        // 存储完成清理 list
        list.clear();
    }
}