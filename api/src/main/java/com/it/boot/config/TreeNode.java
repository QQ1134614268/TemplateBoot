package com.it.boot.config;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface TreeNode<ID> {

    ID getParentId();

    ID getId();

    <T extends TreeNode<ID>> List<T> getChildren();
    // <T> List<T> getChildren();

    static <ID, T extends TreeNode<ID>> List<T> getTree(List<T> list) {
        return getTree(list, null);
    }

    static <ID, T extends TreeNode<ID>> List<T> getTree(List<T> list, Object nullParentId) {
        List<T> tree = new ArrayList<>();
        for (T node : list) {
            if (node.getParentId() == null || Objects.equals(node.getParentId(), nullParentId)) {
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


    static <ID, T extends TreeNode<ID>> List<T> toList(List<T> tree) {
        List<T> list = new ArrayList<>();
        return toList(tree, list);
    }

    /**
     * 遍历树 前序 中序 后序
     */
    static <ID, T extends TreeNode<ID>> List<T> toList(List<T> tree, List<T> ret) {
        if (tree == null || tree.isEmpty()) {
            return ret;
        }
        for (T node : tree) {
            ret.add(node);
            toList(node.getChildren(), ret);
        }
        return ret;
    }
}