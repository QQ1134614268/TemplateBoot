package com.it.boot.config.mybatis;

import com.alibaba.fastjson2.TypeReference;
import com.it.boot.dto.AddressDtoJson;

import java.util.List;

public class TestDtoJsonListTypeHandler extends ListTypeHandler<AddressDtoJson> {
    @Override
    protected TypeReference<List<AddressDtoJson>> specificType() {
        return new TypeReference<List<AddressDtoJson>>() {
        };
    }
}