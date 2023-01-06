package com.it.jiangxin.config;


import java.util.List;


public interface TreeNode {
    Integer getParentId();

    Integer getId();

    <T extends TreeNode> List<T> getChildren();
}