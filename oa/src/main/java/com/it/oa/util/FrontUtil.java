package com.it.oa.util;

import com.it.oa.controller.para.EnumParaPara;
import com.it.oa.controller.para.EnumParaPara2;
import com.it.oa.entity.EnumEntity;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

public class FrontUtil {
    //  兼容前端 todo 删除,

    public static <T> T getLast(List<T> list) {
        // 兼容
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static EnumParaPara toEnumParaPara(EnumParaPara2 para2) {
        EnumParaPara para = new EnumParaPara();
        para.setSort(para2.getSort());
        para.setValue(para2.getValue());
        para.setParentId(para2.getParentIds().stream().reduce((first, second) -> second).orElse(null));
        return para;
    }

    public static List<Integer> getParentList(Integer id, List<EnumEntity> list, List<Integer> ret) {
        if (id == null) {
            return ret;
        }
        ret.add(0, id);
        EnumEntity entity = list.stream().filter(vo -> Objects.equals(vo.getId(), id)).findFirst().orElse(null);
        Assert.notNull(entity, "not null");
        return getParentList(entity.getParentId(), list, ret);
    }
}
