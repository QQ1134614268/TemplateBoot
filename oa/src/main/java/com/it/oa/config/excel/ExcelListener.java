package com.it.oa.config.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

public class ExcelListener<T> extends AnalysisEventListener<T> {

    List<T> list = new ArrayList<>();

    @Override
    public void invoke(T o, AnalysisContext analysisContext) {
        list.add(o);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    public List<T> getList() {
        return list;
    }
}
