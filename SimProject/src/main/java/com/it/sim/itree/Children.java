package com.it.sim.itree;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface Children extends Path {
    // List<Children> children = null;
    //
    <T extends Children> List<T> getChildren();

    static <T extends Children> List<T> getTree(List<T> list) {
        List<T> tree = new ArrayList<>();
        for (T children1 : list) {
            if (children1.getParentId() == null) {
                tree.add(children1);
            }
            for (T children2 : list) {
                if (Objects.equals(children1.getId(), children2.getParentId())) {
                    children1.getChildren().add(children2);
                }
            }
        }
        return tree;
    }
}