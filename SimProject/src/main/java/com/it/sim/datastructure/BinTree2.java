package com.it.sim.datastructure;

import java.util.ArrayList;
import java.util.List;

public class BinTree2 {
    public static void main(String[] args) {
        BinTree2 binTree = new BinTree2();
        Object[] objs = {0, 1, 2, 3, 4, 5, 6, 7};
        binTree.createTree(objs);
        // binTree.preorder(binTree.getRoot()); 先序遍历
        // binTree.inorder(binTree.getRoot()); 中序遍历
        binTree.afterOrder(binTree.getRoot()); // 后序遍历
    }

    private BinTree2 lChild;// 左孩子
    private BinTree2 rChild;// 右孩子
    private BinTree2 root;// 根节点
    private Object data; // 数据域

    public BinTree2(BinTree2 lChild, BinTree2 rChild, Object data) {
        super();
        this.lChild = lChild;
        this.rChild = rChild;
        this.data = data;
    }

    public BinTree2(Object data) {
        this(null, null, data);
    }

    public BinTree2() {
        super();
    }

    public void createTree(Object[] objs) {
        // 存储所有的节点
        List<BinTree2> dataList = new ArrayList<>();
        for (Object object : objs) {
            dataList.add(new BinTree2(object));
        }
        root = dataList.get(0);// 将第一个作为根节点
        for (int i = 0; i < objs.length / 2; i++) {
            dataList.get(i).lChild = dataList.get(i * 2 + 1);
            if (i * 2 + 2 < dataList.size()) {// 避免偶数的时候 下标越界
                dataList.get(i).rChild = dataList.get(i * 2 + 2);
            }
        }
    }

    // 先序遍历
    public void preorder(BinTree2 root) {
        if (root != null) {
            visit(root.getData());
            preorder(root.lChild);
            preorder(root.rChild);
        }

    }

    // 中序遍历
    public void inorder(BinTree2 root) {
        if (root != null) {
            inorder(root.lChild);
            visit(root.getData());
            inorder(root.rChild);
        }

    }

    // 后序遍历
    public void afterOrder(BinTree2 root) {
        if (root != null) {
            afterOrder(root.lChild);
            afterOrder(root.rChild);
            visit(root.getData());
        }

    }

    private void visit(Object obj) {
        System.out.print(obj + " ");
    }

    public Object getData() {
        return data;
    }

    public BinTree2 getRoot() {
        return root;
    }
}
