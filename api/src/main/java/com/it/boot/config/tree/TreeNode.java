package com.it.boot.config.tree;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// todo
public interface TreeNode {

    <ID> ID getParentId();

    <ID> ID getId();

    <T extends TreeNode> List<T> getChildren();

    static <T extends TreeNode> List<T> getTree(List<T> list) {
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
            Long id;
            Long parentId;
            List<Test> children = new ArrayList<>();

            private Test(Long id, Long parentId) {
                this.id = id;
                this.parentId = parentId;
            }
        }
        @EqualsAndHashCode(callSuper = true)
        @Data
        @NoArgsConstructor
        class TestV2 extends Test {
            Long id;
            Long parentId;
            List<Test> children = new ArrayList<>();
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