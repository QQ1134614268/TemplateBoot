package com.it.sim.datastructure;

import lombok.Data;

public class SortTree {

    private static SortTreeNode root = null;

    public static void main(String[] args) {
        int[] a = {5, 6, 1, 3, 2, 4, 7, 6, 5};
        for (int j : a) {
            InsertBST(j);
        }
        DeleteBST(root, 5);
        System.out.println("排序结果为：");
        InOrderTraverse(root); // 中序遍历二叉树的结果为顺序

    }

    /* 增加 */
    private static void InsertBST(int k) {

        SortTreeNode treeNode1 = root;
        SortTreeNode treeNode2 = new SortTreeNode();

        while (treeNode1 != null) {
            treeNode2 = treeNode1;
            if (k > treeNode1.getData()) {
                treeNode1 = treeNode1.getRightChild();
            } else if (k < treeNode1.getData()) {
                treeNode1 = treeNode1.getLeftChild();
            } else
                return;
        }

        if (root == null) {
            root = new SortTreeNode(k);
        } else if (k > treeNode2.getData())
            treeNode2.setRightChild(new SortTreeNode(k));
        else if (k < treeNode2.getData())
            treeNode2.setLeftChild(new SortTreeNode(k));

    }

    /* 删除 */
    private static boolean DeleteBST(SortTreeNode treeNode, int k) {
        if (treeNode == null)
            return false;

        if (k == treeNode.getData())
            return delete(treeNode);

        if (k > treeNode.getData())
            return DeleteBST(treeNode.getRightChild(), k);

        return DeleteBST(treeNode.getLeftChild(), k);
    }

    private static boolean delete(SortTreeNode treeNode) {
        SortTreeNode treeNode1 = treeNode;
        SortTreeNode treeNode2 = treeNode;

        if (treeNode.getRightChild() == null) {
            treeNode1 = treeNode.getLeftChild();
            treeNode.setData(treeNode1.getData());
            treeNode.setLeftChild(treeNode1.getLeftChild());
            treeNode.setRightChild(treeNode1.getRightChild());
        } else if (treeNode.getLeftChild() == null) {
            treeNode1 = treeNode.getRightChild();
            treeNode.setData(treeNode1.getData());
            treeNode.setLeftChild(treeNode1.getLeftChild());
            treeNode.setRightChild(treeNode1.getRightChild());
        } else {
            treeNode2 = treeNode2.getLeftChild();
            while (treeNode2.getRightChild() != null) {
                treeNode1 = treeNode2;
                treeNode2 = treeNode2.getRightChild();
            }
            treeNode.setData(treeNode2.getData());
            if (treeNode1 != treeNode) {
                treeNode1.setRightChild(treeNode2.getLeftChild());
            } else {
                treeNode1.setLeftChild(treeNode2.getLeftChild());
            }

        }
        return true;
    }

    /* 查找 */
    public static boolean SearchBST(int k) {

        SortTreeNode current = root;
        while (current != null) {
            if (k == current.getData())
                return true;
            else if (k < current.getData())
                current = current.getLeftChild();
            else
                current = current.getRightChild();
        }
        return false;

    }

    /* 中序遍历 */
    public static void InOrderTraverse(SortTreeNode treeNode) {
        if (treeNode == null)
            return;
        InOrderTraverse(treeNode.getLeftChild());
        System.out.print(treeNode.getData() + ", ");
        InOrderTraverse(treeNode.getRightChild());
    }

    @Data
    private static class SortTreeNode {
        private int data;
        private SortTreeNode leftChild;
        private SortTreeNode rightChild;

        public SortTreeNode() {
        }

        public SortTreeNode(int data) {
            this.data = data;
            leftChild = null;
            rightChild = null;
        }

    }
}