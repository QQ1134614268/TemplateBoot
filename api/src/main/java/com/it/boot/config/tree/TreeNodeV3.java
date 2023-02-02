package com.it.boot.config.tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface TreeNodeV3<ID> {
    ID getParentId();

    ID getId();

    List<TreeNodeV3<ID>> getChildren();

    default List<TreeNodeV3<ID>> getTree(List<TreeNodeV3<ID>> list) {
        List<TreeNodeV3<ID>> tree = new ArrayList<>();
        for (TreeNodeV3<ID> node : list) {
            if (node.getParentId() == null || Objects.equals(node.getParentId(), 0)) {
                tree.add(node);
            }
            for (TreeNodeV3<ID> node2 : list) {
                if (Objects.equals(node.getId(), node2.getParentId())) {
                    node.getChildren().add(node2);
                }
            }
        }
        return tree;
    }

}
