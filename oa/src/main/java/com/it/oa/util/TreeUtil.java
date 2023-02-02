package com.it.oa.util;

import com.it.oa.config.TreeNode;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TreeUtil {

    public static <T extends TreeNode<T>> List<T> getTree(List<T> list) {
        List<T> tree = new ArrayList<>();
        for (T node : list) {
            if (node.getParentId() == null) {
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

    public static <T extends TreeNode<T>> List<T> getTree2(List<T> list) {
        List<T> tree = new ArrayList<>();
        for (T node : list) {
            if (node.getParentId() == null) {
                tree.add(node);
            }
            for (T node2 : list) {
                if (Objects.equals(node.getId(), node2.getParentId())) {
                    node.getChildren().add(node2);
                }
            }
        }
        return tree;

        // return null;
    }

    public static <T extends TreeNode<T>> List<T> toList(List<T> tree, List<T> ret) {
        if (tree == null || tree.isEmpty()) {
            return ret;
        }
        ret.addAll(tree);
        for (T node : tree) {
            return toList(node.getChildren(), ret);
        }
        return ret;
    }

    public static void main(String[] args) {
        @Data
        class Test implements TreeNode {
            Integer id;
            Integer parentId;
            List<Test> children = new ArrayList<>();

            private Test(Integer id, Integer parentId) {
                this.id = id;
                this.parentId = parentId;
            }
        }

        Test test1 = new Test(1, null);
        Test test2 = new Test(2, null);
        Test test3 = new Test(3, 2);
        Test test4 = new Test(4, 2);
        ArrayList<Test> list = new ArrayList<>();
        list.add(test1);
        list.add(test2);
        list.add(test3);
        list.add(test4);
        List<Test> ret = getTree(list);
        System.out.println();
    }

}
