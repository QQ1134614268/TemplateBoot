package com.it.sim.algorithm;

import java.util.ArrayList;

public class SortRadix {
    public int[] radixSort(int[] A, int n) {
        // 基于桶排序的基数排序

        // 确定排序的趟数，即排序数组中最大值为809时，趟数为3
        int max = A[0];
        for (int i = 0; i < n; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        // 算出max的位数
        int time = 0;
        while (max > 0) {
            max /= 10;
            time++;
        }
        // 【桶】初始化十个链表作为桶，用户分配时暂存
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> Item = new ArrayList<>();
            list.add(Item);
        }

        // 进行time次分配和收集
        for (int i = 0; i < time; i++) {

            // 分配元素，按照次序优先，从个位数开始
            for (int j = 0; j < n; j++) {
                int index = A[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                list.get(index).add(A[j]);
            }
            // 收集元素，一个一个桶地收集
            int count = 0;
            // 10个桶
            for (int k = 0; k < 10; k++) {
                // 每个桶收集
                if (list.get(k).size() > 0) {
                    for (int a : list.get(k)) {
                        A[count] = a;
                        count++;
                    }
                    // 清除数据，以便下次收集
                    list.get(k).clear();
                }
            }
        }
        return A;
    }
}