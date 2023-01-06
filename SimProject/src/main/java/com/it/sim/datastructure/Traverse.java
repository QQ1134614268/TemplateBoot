package com.it.sim.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traverse {

    /* 递归实现 */
    public static void PreOrderTraverse(TreeNode treeNode) {
        if (treeNode == null)
            return;
        System.out.print(treeNode.getData() + ", ");
        PreOrderTraverse(treeNode.getLeftChild());
        PreOrderTraverse(treeNode.getRightChild());

    }

    public static void InOrderTraverse(TreeNode treeNode) {
        if (treeNode == null)
            return;
        InOrderTraverse(treeNode.getLeftChild());
        System.out.print(treeNode.getData() + ", ");
        InOrderTraverse(treeNode.getRightChild());
    }

    public static void PostOrderTraverse(TreeNode treeNode) {
        if (treeNode == null)
            return;
        PostOrderTraverse(treeNode.getLeftChild());
        PostOrderTraverse(treeNode.getRightChild());
        System.out.print(treeNode.getData() + ", ");
    }

    /* 非递归实现 */
    public static void PreOrderTraverse1(TreeNode treeNode) {

        Stack<TreeNode> treeNodeStack = new Stack<>();

        while (!treeNodeStack.empty())
            treeNodeStack.pop();
        treeNodeStack.push(treeNode);
        while (!treeNodeStack.empty()) {
            TreeNode treeNode1 = treeNodeStack.peek();
            treeNodeStack.pop();
            System.out.print(treeNode1.getData() + ", ");
            if (treeNode1.getRightChild() != null)
                treeNodeStack.push(treeNode1.getRightChild());
            if (treeNode1.getLeftChild() != null)
                treeNodeStack.push(treeNode1.getLeftChild());
        }

    }

    public static void InOrderTraverse1(TreeNode treeNode) {
        Stack<TreeNode> treeNodeStack = new Stack<>();

        while (!treeNodeStack.empty())
            treeNodeStack.pop();
        while (!treeNodeStack.empty() || treeNode != null) {
            if (treeNode == null) {
                TreeNode treeNode1 = treeNodeStack.peek();
                treeNodeStack.pop();
                System.out.print(treeNode1.getData() + ", ");
                treeNode = treeNode1.getRightChild();
            } else {
                treeNodeStack.push(treeNode);
                treeNode = treeNode.getLeftChild();
            }
        }
    }

    public static void PostOrderTraverse1(TreeNode treeNode) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        Stack<TreeNode> treeNodeStack1 = new Stack<>();
        while (!treeNodeStack.empty())
            treeNodeStack.pop();

        while (!treeNodeStack1.empty())
            treeNodeStack1.pop();

        treeNodeStack.push(treeNode);
        while (!treeNodeStack.empty()) {
            TreeNode treeNode1 = treeNodeStack.peek();
            treeNodeStack.pop();
            treeNodeStack1.push(treeNode1);
            if (treeNode1.getLeftChild() != null)
                treeNodeStack.push(treeNode1.getLeftChild());
            if (treeNode1.getRightChild() != null)
                treeNodeStack.push(treeNode1.getRightChild());
        }
        while (!treeNodeStack1.empty()) {
            System.out.print(treeNodeStack1.peek().getData() + ", ");
            treeNodeStack1.pop();
        }
    }

    /* 层序遍历 */
    private static void FloorOrderTraverse(TreeNode treeNode) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode treeNode1 = queue.peek();
            System.out.print(treeNode1.getData() + ", ");

            if (treeNode1.getLeftChild() != null)
                queue.add(treeNode1.getLeftChild());
            if (treeNode1.getRightChild() != null)
                queue.add(treeNode1.getRightChild());

            queue.remove();
        }
    }

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arrayList.add(String.valueOf(i));
        }
        BiTree biTree = new BiTree();
        biTree.createTree(arrayList);
        System.out.println("递归前序遍历：");
        PreOrderTraverse(biTree.getTreeNodes().get(0));
        System.out.println(" ");
        System.out.println("非递归前序遍历：");
        PreOrderTraverse1(biTree.getTreeNodes().get(0));
        System.out.println(" \n");
        System.out.println("递归中序遍历：");
        InOrderTraverse(biTree.getTreeNodes().get(0));
        System.out.println(" ");
        System.out.println("非递归中序遍历：");
        InOrderTraverse1(biTree.getTreeNodes().get(0));
        System.out.println(" \n");
        System.out.println("递归后序遍历");
        PostOrderTraverse(biTree.getTreeNodes().get(0));
        System.out.println(" ");
        System.out.println("非递归后序遍历：");
        PostOrderTraverse1(biTree.getTreeNodes().get(0));
        System.out.println(" \n");
        System.out.println("层序遍历：");
        FloorOrderTraverse(biTree.getTreeNodes().get(0));
    }
}