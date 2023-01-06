package com.it.boot.config.enumeration;

import com.sun.deploy.panel.IProperty;
import com.sun.deploy.panel.ITreeNode;

/**
 * @date 2022-12-07 14:53
 */
public enum GroupCodeEnum implements ITreeNode {
    // 枚举仿枚举表  // 内嵌还是 config/enum包 ? 提级,公用
    RES_SUCCESS(1, "成功"), RES_FAILURE(2, "失败");
    private final int code;
    private final String note;

    private static  final String tableName = "";

    GroupCodeEnum(int code, String note) {
        this.code = code;
        this.note = note;
    }

    public int getCode() {
        return code;
    }

    public String getNote() {
        return note;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public int getChildNodeCount() {
        return 0;
    }

    @Override
    public ITreeNode getChildNode(int i) {
        return null;
    }

    @Override
    public void addChildNode(ITreeNode iTreeNode) {

    }

    @Override
    public int getPropertyCount() {
        return 0;
    }

    @Override
    public IProperty getProperty(int i) {
        return null;
    }

    @Override
    public void addProperty(IProperty iProperty) {

    }
}
