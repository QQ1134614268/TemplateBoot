package com.it.jiangxin.config.enum1;

import com.it.jiangxin.service.EnumService;


/**
 * @date 2023-02-01 11:00
 */
public interface IEnumDb<T extends IEnumDb<T>> {

    String getUniCode();

    String getValue();

    // T[] values();

    default void getEnum(EnumService enumService) {

        // 根据当前类获取包名, 获取所有类, 判断枚举, 反射调用values方法, 同步到数据库;
        // 数据库引用,所以只能新增?? todo
        // for (T accountEnum : values()) {
        //     EnumEntity entity = new EnumEntity();
        //     entity.setUniCode(accountEnum.getUniCode());
        //     entity.setValue(accountEnum.getValue());
        //     enumService.save(entity);
        // }
    }
}
