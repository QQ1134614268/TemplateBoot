package com.it.boot.config.tree;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ID: 主键返回类型
 * <T extends TreeNodeV1<ID>>: 存储对象, 使用TreeNodeV1, 向下转型, class类,编辑报错
 * todo 需要,准确性测试, 性能测试,
 * <p>
 * parentID 没有为 null, "", 0;
 * <p>
 * 数字统一映射, 0 == "" == null
 * node.getParentId() == null || Objects.equals(node.getParentId(), 0) || Objects.equals(node.getParentId(), "" )
 */
public interface TreeNodeV1<ID> {
    ID getParentId();

    ID getId();

    <T> List<T> getChildren();

    static <ID, T extends TreeNodeV1<ID>> List<T> getTree(List<T> list) {
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
    static <ID, T extends TreeNodeV1<ID>> List<T> toList(List<T> tree) {
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
    static <ID, T extends TreeNodeV1<ID>> List<T> toListV2(List<T> tree, List<T> ret) {
        if (tree == null || tree.isEmpty()) {
            return ret;
        }
        ret.addAll(tree);
        for (T node : tree) {
            toListV2(node.getChildren(), ret);
        }
        return ret;
    }


    /**
     * 父级-子级,循环
     * 传入List 性能对比,测试
     */
    static <ID, T extends TreeNodeV1<ID>> List<T> toListV3(List<T> tree, List<T> ret) {
        if (tree == null || tree.isEmpty()) {
            return ret;
        }
        for (T node : tree) {
            ret.add(node);
            toListV3(node.getChildren(), ret);
        }
        return ret;
    }

    static <ID, T extends TreeNodeV1<ID>> void toListV4(List<T> tree, List<T> ret) {
        if (tree == null || tree.isEmpty()) {
            return;
        }
        ret.addAll(tree);
        for (T node : tree) {
            toListV4(node.getChildren(), ret);
        }
    }

    static <ID, T extends TreeNodeV1<ID>> List<T> toListV5(List<T> tree) {
        List<T> list = new ArrayList<>();
        return toListV3(tree, list);
    }

    static void main(String[] args) {
        @Data
        class Test implements TreeNodeV1<Long> {
            Long id;
            Long parentId;
            List<Test> children = new ArrayList<>();

            private Test(Long id, Long parentId) {
                this.id = id;
                this.parentId = parentId;
            }
        }

        Test test1 = new Test(1L, null);
        Test test2 = new Test(2L, null);
        Test test3 = new Test(3L, 2L);
        Test test4 = new Test(4L, 2L);
        ArrayList<Test> list = new ArrayList<>();
        list.add(test1);
        list.add(test2);
        list.add(test3);
        list.add(test4);
        List<Test> ret = getTree(list);
        ret.forEach(System.out::println);
    }

}