package com.it.sim.datastructure;

import lombok.Data;

import java.util.ArrayList;

public class BiTree {

    private ArrayList<TreeNode> treeNodes;

    public void createTree(ArrayList<String> arrayList) {

        treeNodes = new ArrayList<>();

        for (String s : arrayList)
            treeNodes.add(new TreeNode(s));

        int length = arrayList.size();

        for (int i = 0; i < length / 2 - 1; i++) {
            treeNodes.get(i).setLeftChild(treeNodes.get(2 * i + 1));
            treeNodes.get(i).setRightChild(treeNodes.get(2 * i + 2));
        }
        int position = length / 2 - 1;
        TreeNode lastParent = treeNodes.get(position);
        lastParent.setLeftChild(treeNodes.get(2 * position + 1));
        if (length % 2 == 1)
            lastParent.setRightChild(treeNodes.get(2 * position + 2));
    }

    public ArrayList<TreeNode> getTreeNodes() {
        return treeNodes;
    }
}

@Data
class TreeNode {
    private String data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(String data) {
        this.data = data;
        leftChild = null;
        rightChild = null;
    }

}