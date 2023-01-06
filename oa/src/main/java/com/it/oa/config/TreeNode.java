package com.it.oa.config;


import java.util.List;


public interface TreeNode<T> {
    Integer getParentId();

    Integer getId();

    List<T> getChildren();
}