package com.it.boot.config.tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface TreeNodeV2<ID, T extends TreeNodeV2<ID, T>> {
    ID getParentId();

    ID getId();

    List<T> getChildren();

    default List<T> getTree(List<T> list) {
        List<T> tree = new ArrayList<>();
        for (T node : list) {
            if (node.getParentId() == null || Objects.equals(node.getParentId(), 0)) {
                tree.add(node);
            }
            for (T node2 : list) {
                if (Objects.equals(node.getId(), node2.getParentId())) {
                    node.getChildren().add(node2);
                }
            }
        }
        return tree;
    }

    /**
     * 父级-子级,循环
     * 每次都 new ArrayList<>()
     * <p>
     * 传入list不易阅读, new list似乎影响性能
     */
    default List<T> toList(List<T> tree) {
        List<T> ret = new ArrayList<>();
        if (tree == null || tree.isEmpty()) {
            return ret;
        }
        for (T node : tree) {
            ret.add(node);
            ret.addAll(toList(node.getChildren()));
        }
        return ret;
    }

    /**
     * 先所有父级,再子集
     * 传入List 性能对比,测试
     */
    default void toListV2(List<T> tree, List<T> ret) {
        if (tree == null || tree.isEmpty()) {
            return;
        }
        ret.addAll(tree);
        for (T node : tree) {
            toListV2(node.getChildren(), ret);
        }
    }


    /**
     * 父级-子级,循环
     * 传入List 性能对比,测试
     */
    default List<T> toListV3(List<T> tree, List<T> ret) {
        if (tree == null || tree.isEmpty()) {
            return ret;
        }
        for (T node : tree) {
            ret.add(node);
            toListV3(node.getChildren(), ret);
        }
        return ret;
    }

    default void toListV4(List<T> tree, List<T> ret) {
        if (tree == null || tree.isEmpty()) {
            return;
        }
        ret.addAll(tree);
        for (T node : tree) {
            toListV4(node.getChildren(), ret);
        }
    }

    default List<T> toListV5(List<T> tree) {
        List<T> list = new ArrayList<>();
        return toListV3(tree, list);
    }
}
