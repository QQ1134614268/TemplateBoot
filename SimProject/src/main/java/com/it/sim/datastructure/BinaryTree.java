package com.it.sim.datastructure;

import lombok.Data;

// todo BinaryTree
public class BinaryTree {
    // 表示根节点
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    // 查找节点
    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (current.data > key) {// 当前值比查找值大，搜索左子树
                current = current.leftChild;
            } else if (current.data < key) {// 当前值比查找值小，搜索右子树
                current = current.rightChild;
            } else {
                return current;
            }
        }
        return null;// 遍历完整个树没找到，返回null
    }

    // 插入节点
    public boolean insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {// 当前树为空树，没有任何节点
            root = newNode;
            return true;
        } else {
            Node current = root;
            Node parentNode;
            while (true) {
                parentNode = current;
                if (current.data > data) {// 当前值比插入值大，搜索左子节点
                    current = current.leftChild;
                    if (current == null) {// 左子节点为空，直接将新值插入到该节点
                        parentNode.leftChild = newNode;
                        return true;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {// 右子节点为空，直接将新值插入到该节点
                        parentNode.rightChild = newNode;
                        return true;
                    }
                }
            }
        }
    }

    // 中序遍历
    public void infixOrder(Node current) {
        if (current != null) {
            infixOrder(current.leftChild);
            System.out.print(current.data + " ");
            infixOrder(current.rightChild);
        }
    }

    // 前序遍历
    public void preOrder(Node current) {
        if (current != null) {
            System.out.print(current.data + " ");
            infixOrder(current.leftChild);
            infixOrder(current.rightChild);
        }
    }

    // 后序遍历
    public void postOrder(Node current) {
        if (current != null) {
            infixOrder(current.leftChild);
            infixOrder(current.rightChild);
            System.out.print(current.data + " ");
        }
    }

    // 找到最大值
    public Node findMax() {
        Node current = root;
        Node maxNode = current;
        while (current != null) {
            maxNode = current;
            current = current.rightChild;
        }
        return maxNode;
    }

    // 找到最小值
    public Node findMin() {
        Node current = root;
        Node minNode = current;
        while (current != null) {
            minNode = current;
            current = current.leftChild;
        }
        return minNode;
    }

    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = false;
        // 查找删除值，找不到直接返回false
        while (current.data != key) {
            parent = current;
            if (current.data > key) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }
        // 如果当前节点没有子节点
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
            return true;

            // 当前节点有一个子节点，右子节点
        } else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
            return true;
            // 当前节点有一个子节点，左子节点
        } else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
            return true;
        } else {
            // 当前节点存在两个子节点
            Node successor = getSuccessor(current);
            if (current == root) {
                successor = root;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return false;

    }

    public Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        // 后继节点不是删除节点的右子节点，将后继节点替换删除节点
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }

        return successor;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.insert(50);
        bt.insert(20);
        bt.insert(80);
        bt.insert(10);
        bt.insert(30);
        bt.insert(60);
        bt.insert(90);
        bt.insert(25);
        bt.insert(85);
        bt.insert(100);
        bt.preOrder(bt.getRoot());

//		bt.infixOrder(bt.getRoot().leftChild);
        bt.getRoot().display();
        bt.getRoot().leftChild.rightChild.display();
        bt.getRoot().rightChild.display();
        bt.delete(10);// 删除没有子节点的节点
        bt.delete(30);// 删除有一个子节点的节点
        bt.delete(80);// 删除有两个子节点的节点
        // System.out.println(bt.findMax().data);
//		System.out.println(bt.findMin().data);
//		System.out.println(bt.find(100));
//		System.out.println(bt.find(200));
    }


}
@Data
class Node {
    int data; // 节点数据
    Node leftChild; // 左子节点的引用
    Node rightChild; // 右子节点的引用
    boolean isDelete;// 表示节点是否被删除

    @Override
    public String toString() {
        return "Node [data=" + data + ", leftChild=" + leftChild + ", rightChild=" + rightChild + ", isDelete="
                + isDelete + "]";
    }

    public Node(int data) {
        this.data = data;
    }

    // 打印节点内容
    public void display() {
        System.out.println(data);
    }
}