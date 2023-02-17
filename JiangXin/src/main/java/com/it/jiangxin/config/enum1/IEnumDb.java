package com.it.jiangxin.config.enum1;

import com.it.jiangxin.entity.EnumEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @date 2023-02-01 11:00
 */
public interface IEnumDb<T extends IEnumDb<T>> {

    String getUniCode();

    String getValue();

    T[] values2();

    default List<IEnumDb<T>> values3(){
        T[] a =  values2();
        return new ArrayList<>(Arrays.asList(a));
    }

    default List<EnumEntity> getEnum() {
        List<EnumEntity> list = new ArrayList<>();
        // 根据当前类获取包名, 获取所有类, 判断枚举, 反射调用values方法, 同步到数据库;
        // 数据库引用,所以只能新增?? todo
        for (T accountEnum : values2()) {
            EnumEntity entity = new EnumEntity();
            entity.setUniCode(accountEnum.getUniCode());
            entity.setValue(accountEnum.getValue());
            list.add(entity);
        }
        return list;
    }
}
