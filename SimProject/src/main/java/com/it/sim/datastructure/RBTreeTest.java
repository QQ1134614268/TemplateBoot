package com.it.sim.datastructure;

public class RBTreeTest {

    private static final int[] a = {10, 40, 30, 60, 90, 70, 20, 50, 80};
    private static final boolean mDebugInsert = true; // "插入"动作的检测开关(false，关闭；true，打开)
    private static final boolean mDebugDelete = true; // "删除"动作的检测开关(false，关闭；true，打开)

    public static void main(String[] args) {
        int i, i2 = a.length;
        RBTree<Integer> tree = new RBTree<>();

        System.out.print("== 原始数据: ");
        for (i = 0; i < i2; i++)
            System.out.printf("%d ", a[i]);
        System.out.print("\n");

        for (i = 0; i < i2; i++) {
            tree.insert(a[i]);
            // 设置mDebugInsert=true,测试"添加函数"
            if (mDebugInsert) {
                System.out.printf("== 添加节点: %d\n", a[i]);
                System.out.print("== 树的详细信息: \n");
                tree.print();
                System.out.print("\n");
            }
        }

        System.out.print("== 前序遍历: ");
        tree.preOrder();

        System.out.print("\n== 中序遍历: ");
        tree.inOrder();

        System.out.print("\n== 后序遍历: ");
        tree.postOrder();
        System.out.print("\n");

        System.out.printf("== 最小值: %s\n", tree.minValue());
        System.out.printf("== 最大值: %s\n", tree.maxValue());
        System.out.print("== 树的详细信息: \n");
        tree.print();
        System.out.print("\n");

        // 设置mDebugDelete=true,测试"删除函数"
        if (mDebugDelete) {
            for (i = 0; i < i2; i++) {
                tree.remove(a[i]);

                System.out.printf("== 删除节点: %d\n", a[i]);
                System.out.print("== 树的详细信息: \n");
                tree.print();
                System.out.print("\n");
            }
        }
    }

}