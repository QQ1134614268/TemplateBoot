package com.it.jiangxin.config;


import java.util.List;


public interface TreeNode {
    Integer getParentId();

    Integer getId();

    <T> List<T> getChildren();
}