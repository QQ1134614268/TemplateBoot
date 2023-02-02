package com.it.boot.util;

import java.util.Collection;

public class CollectionUtil {
    /**
     * 判断一个集合是否为null或者没有元素
     */
    public static <T> boolean isCollectionEmpty(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }
}
