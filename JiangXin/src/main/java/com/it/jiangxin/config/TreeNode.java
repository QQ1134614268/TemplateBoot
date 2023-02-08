package com.it.jiangxin.config;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public interface TreeNode {
    Integer getParentId();

    Integer getId();

    <T> List<T> getChildren();

    static <T extends TreeNode> List<T> getTree(List<T> list) {
        List<T> tree = new ArrayList<>();
        for (T node : list) {
            if (node.getParentId() == 0) {
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

    static <T extends TreeNode> List<T> toList(List<T> tree, List<T> ret) {
        if (tree == null || tree.isEmpty()) {
            return ret;
        }
        ret.addAll(tree);
        for (T node : tree) {
            return toList(node.getChildren(), ret);
        }
        return ret;
    }

    static void main(String[] args) {
        @Data
        @NoArgsConstructor
        class Test implements TreeNode {
            Integer id;
            Integer parentId;
            List<TreeNode> children = new ArrayList<>();

            private Test(Integer id, Integer parentId) {
                this.id = id;
                this.parentId = parentId;
            }
        }
        @Data
        @EqualsAndHashCode(callSuper = true)
        class Test2 extends Test {
            Integer id;
            Integer parentId;
            List<TreeNode> children = new ArrayList<>();
        }
        Test test1 = new Test(1, 0);
        Test test2 = new Test(2, 0);
        Test test3 = new Test(3, 2);
        Test test4 = new Test(4, 2);
        ArrayList<Test> list = new ArrayList<>();
        list.add(test1);
        list.add(test2);
        list.add(test3);
        list.add(test4);
        List<Test> ret = getTree(list);
        ret.forEach(System.out::println);
    }
}