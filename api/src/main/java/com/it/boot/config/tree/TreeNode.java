package com.it.boot.config.tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

}