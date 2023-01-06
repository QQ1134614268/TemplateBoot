package com.it.sim.datastructure;

public class AVLTree {

    private AvlNode root;

    public AVLTree() {
        root = null;
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        int[] a = {3, 2, 1, 4, 5, 6, 7, 10, 9, 8};
        for (int i = 0; i < 10; i++) {
            avlTree.insert(a[i]);
        }

        InOrderTraverse(avlTree.root);

    }

    public void insert(Integer x) {
        root = insert(x, root);
    }

    public int height() {
        return height(root);
    }

    // return the height of node t, or -1, if null.
    private int height(AvlNode t) {
        return t == null ? -1 : t.height;
    }

    private AvlNode insert(Integer x, AvlNode t) {

        if (t == null)
            return new AvlNode(x, null, null);

        int compareResult = x.compareTo(t.data);

        if (compareResult < 0) {

            t.leftChild = insert(x, t.leftChild);
            if (height(t.leftChild) - height(t.rightChild) == 2)
                if (x.compareTo(t.leftChild.data) < 0)
                    t = rotateWithLeftChildChild(t); // 左—左单旋转
                else
                    t = doubleWithLChildChild(t); // 左—右双旋转
        } else if (compareResult > 0) {

            t.rightChild = insert(x, t.rightChild);
            if (height(t.rightChild) - height(t.leftChild) == 2)
                if (x.compareTo(t.rightChild.data) > 0)
                    t = rotateWithRightChildChild(t); // 右—右单旋转
                else
                    t = doubleWithRChildChild(t); // 右—左双旋转
        }

        t.height = Math.max(height(t.leftChild), height(t.rightChild)) + 1;

        return t;
    }

    private AvlNode rotateWithLeftChildChild(AvlNode k2) {

        AvlNode k1 = k2.leftChild;
        k2.leftChild = k1.rightChild;
        k1.rightChild = k2;
        k2.height = Math.max(height(k2.leftChild), height(k2.rightChild)) + 1;
        k1.height = Math.max(height(k1.leftChild), k2.height) + 1;

        return k1;
    }

    private AvlNode rotateWithRightChildChild(AvlNode k1) {

        AvlNode k2 = k1.rightChild;
        k1.rightChild = k2.leftChild;
        k2.leftChild = k1;

        k1.height = Math.max(height(k1.leftChild), height(k1.rightChild)) + 1;
        k2.height = Math.max(height(k2.rightChild), k1.height) + 1;

        return k2;

    }

    private AvlNode doubleWithLChildChild(AvlNode k3) {

        k3.leftChild = rotateWithRightChildChild(k3.leftChild);
        return rotateWithLeftChildChild(k3);
    }

    private AvlNode doubleWithRChildChild(AvlNode k1) {
        k1.rightChild = rotateWithLeftChildChild(k1.rightChild);
        return rotateWithRightChildChild(k1);
    }

    public static void InOrderTraverse(AvlNode treeNode) {
        if (treeNode == null)
            return;
        InOrderTraverse(treeNode.leftChild);
        System.out.print(treeNode.data + ", ");
        InOrderTraverse(treeNode.rightChild);
    }


}

class AvlNode {

    Integer data;
    AvlNode leftChild;
    AvlNode rightChild;
    int height; // 高度

    public AvlNode(Integer integer, AvlNode lt, AvlNode rt) {
        data = integer;
        leftChild = lt;
        rightChild = rt;
    }

}