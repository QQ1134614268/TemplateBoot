package com.it.sim.algorithm;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zero DateTime 2018年6月25日 下午8:41:10
 * <p>
 * <a href="https://www.cnblogs.com/onepixel/articles/7674659.html">...</a>
 */

public class SortsMethodTest {

    /* 冒泡 */
    public static void bubble(int[] array) {
        int len = array.length;
        int temp;
        for (int i = 0; i < len - 1; i++) {
            for (int j = len - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    /* 直接选择排序 */
    public static void straightSelectSort(int[] array) {
        int len = array.length;
        int temp, n;
        for (int i = 0; i < len - 1; i++) {
            temp = i;
            for (int j = i + 1; j <= len - 1; j++) {
                if (array[temp] > array[j]) {
                    temp = j;
                }
            }
            n = array[temp];
            array[temp] = array[i];
            array[i] = n;
        }
    }

    /* 插入排序 */
    public static void insertSort(int[] array) {
        int len = array.length;
        int temp;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] < array[j]) {
                    temp = array[i];
                    System.arraycopy(array, j, array, j + 1, i - j);
                    // for (j = i; j > 0 && A[j - 1] > temp; j--)
                    // {
                    // A[j] = A[j - 1];
                    // }
                    array[j] = temp;
                    break;
                }
            }
        }
    }

    /**
     * 快速排序
     * <p>
     * 挖坑填数,递归 --分治法
     */
    public static void quickSort(int[] array, int start, int end) {
        if (start >= end)
            return;
        int left = start, right = end;
        int std = array[start];
        while (left != right) {
            while (left < right && array[right] >= std)// 跳出循环 left==right 或者std>array[right]
                right--;
            if (left < right) {
                // 判断跳出循环原因
                array[left] = array[right];
            }
            while (left < right && array[left] < std)
                left++;
            if (left < right) {
                array[right] = array[left];
            }
        }
        array[left] = std;
        quickSort(array, start, left - 1);
        quickSort(array, right + 1, end);
    }

    /* 快速排序 */
    public static void quickSort2(int[] array, int start, int end) {
        // 交换排序---快速排序

//        快速排序是交互排序的一种，实质上是对冒泡排序的一种改进，快速排序的基本思想是，在n个记录中取某一个记录的键值为标准，
//		通常取第一个记录键值为基准，通过一趟排序将待排的记录分为小于或等于这个键值的两个独立的部分，这是一部分的记录键值均比另一部分记录的键值小，
//		然后，对这两部分记录继续分别进行快速排序，以达到整个序列有序
    }

    /* 希尔排序 */// 找一个数列 插入排序,数列最终为1,插入排序...
    public static void shellSort(int[] array) {

        int temp, j, len = array.length;
        for (int step = len / 2; step > 0; step = step / 2) {
            for (int i = 0; i < len - step; i++) {
                temp = array[i + step];
                for (j = i + step; j >= step && array[j - step] > temp; j = j - step) {
                    array[j] = array[j - step];
                }
                array[j] = temp;
            }
        }
    }

    /* 计数排序 */
    public static void countSort(int[] array) {
        int min = array[0], max = array[0];
        for (int j : array) {
            min = Math.min(j, min);
            max = Math.max(j, max);
        }
        int[] tempArray = new int[max - min + 1];
        for (int j : array) {
            tempArray[j - min]++;
        }
        int temp = 0;
        for (int i = 0; i < tempArray.length; i++) {
            while (tempArray[i]-- > 0) {
                array[temp] = i + min;
                temp++;
            }
        }
    }

    /* 归并排序 递归算法 */
    public static void mergeSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (end + start) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);
        sort(array, start, mid, end);
    }

    private static void sort(int[] array, int start, int mid, int end) {
        int[] tempArray = new int[array.length];

        int left = start, temp = start, right = mid + 1;
        while (left <= mid && right <= end) {
            if (array[left] < array[right]) {
                tempArray[temp++] = array[left++];
            } else {
                tempArray[temp++] = array[right++];
            }
        }
        if (left > mid) {
            System.arraycopy(array, right, tempArray, temp, end - right + 1);
        } else {
            System.arraycopy(array, left, tempArray, temp, mid - left + 1);
        }
        System.arraycopy(tempArray, start, array, start, end - start + 1);
    }

    /* 堆排序 树形结构 */
    public static void heapSort(int[] array) {
        // 堆排序算法
        int i, len = array.length;
        // 先把A[]数组构建成一个大顶堆。
        // 从完全二叉树的最下层最右边的非终端结点开始构建。
        for (i = len / 2 - 1; i >= 0; i--) {
            heapAdjust(array, i, len);
        }

        // 开始遍历
        for (i = len - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            // 每交换一次得到一个最大值然后丢弃
            heapAdjust(array, 0, i);
        }
    }

    // A[i]代表的是下标为i的根结点
    private static void heapAdjust(int[] A, int i, int n) {
        // 【注意】这里下标从0开始
        int temp;
        // 存储根结点
        temp = A[i];
        // 沿根结点的左右孩子中较大的往下遍历,由于完全二叉树特性 i的左子节点2i+1 i的右子节点2i+2
        for (int j = 2 * i + 1; j < n; j = j * 2 + 1) {

            if (j < n - 1 && A[j] < A[j + 1]) {
                ++j;
            }

            if (temp >= A[j]) {
                break;
            }
            // 将子节点赋值给根结点
            A[i] = A[j];
            // 将子节点下标赋给i
            i = j;
        }
        // 将存储的根结点的值赋给子节点
        A[i] = temp;

    }

    /* 桶排序 */
    public static void bucketSort(int[] arr) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int k : arr) {
            max = Math.max(max, k);
            min = Math.min(min, k);
        }

        // 桶数
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<>());
        }

        // 将每个元素放入桶
        for (int j : arr) {
            int num = (j - min) / (arr.length);
            bucketArr.get(num).add(j);
        }

        // 对每个桶进行排序
        for (ArrayList<Integer> integers : bucketArr) {
            Collections.sort(integers);
        }
        int count = 0;
        for (ArrayList<Integer> arrayList : bucketArr) {
            for (int num : arrayList) {
                arr[count] = num;
                count++;
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random(20);
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = random.nextInt(20);
        }
        for (int j = 0; j < 100; j++) {
            arr = shuffle(arr);
            int[] a = arr.clone();
            bucketSort(arr);
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    System.err.println(
                            "排序错误:" + Arrays.toString(a) + System.getProperty("line.separator") + Arrays.toString(arr));
                    break;
                }
            }
        }
        System.err.println("排序结束");
        System.err.println(Arrays.toString(arr));
        int[] a = arr.clone();
        arr[0] = 100;
        System.err.println(Arrays.toString(a));
        System.err.println(Arrays.toString(arr));
    }

    private static int[] shuffle(int[] arr) { // 传入一个数组,如果数组没有重新赋值,修改就会返回,重新赋值需要return
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.shuffle(list);
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    @Test
    public void run() {

        Integer[] arrayTest = {6, 1, 9, 2, 5, 7, 6, 10, 6, 12};

        // 以下是单线程算法，处理数组

        //1.
        // 查找数组中为 key 的 下标 ：binarySearch 二分法查找，数组必须有序，且存在此数组中，否则返回负数下标
        Integer[] arr = {1, 2, 3, 4, 5, 6};
        int binarySearch = Arrays.binarySearch(arr, 3);
        System.out.println(binarySearch);
        // 在指定范围内查找 key 的 下标
        int binarySearch0 = Arrays.binarySearch(arr, 0, 3, 3);
        System.out.println(binarySearch0);

        //2.
        // 复制出新的数组，复制长度由 newLength 决定,长度可大于被复制数组的长度
        Integer[] copyArray1 = Arrays.copyOf(arrayTest, 5);
        arrayPrint(copyArray1);
        // 复制指定下标范围内的值,含头不含尾
        Integer[] copyArray2 = Arrays.copyOfRange(arrayTest, 2, 7);
        arrayPrint(copyArray2);

        //3.
        // 在指定下标内，对数组进制默认升序排序，这将改变原数组，下标含头不含尾
        Integer[] sortArray1 = Arrays.copyOf(arrayTest, arrayTest.length);
        Arrays.sort(sortArray1, 0, 5);
        arrayPrint(sortArray1);
        // 数组内全部排序
        Arrays.sort(sortArray1);
        arrayPrint(sortArray1);
        Integer[] sortArray2 = Arrays.copyOf(arrayTest, arrayTest.length);
        // 使用比较器降序排序，在指定下标范围内
        Arrays.sort(sortArray2, 0, 5, Comparator.reverseOrder());

        arrayPrint(sortArray2);
        // 使用比较器全部降序排序
        Arrays.sort(sortArray2, Comparator.reverseOrder());
        arrayPrint(sortArray2);

        //4.
        // 数组toString
        System.out.println(Arrays.toString(arrayTest));
        Integer[][] stuGrades = {{1, 3, 5, 7, 9}, {2, 4, 6, 8}, {1, 5, 10}};
        // 二维数组toString
        System.out.println(Arrays.deepToString(stuGrades));

        // 5.
        Integer[] equals1 = Arrays.copyOf(arrayTest, arrayTest.length);
        // 比较一维数组内容是否相等
        System.out.println(Arrays.equals(equals1, arrayTest));

        Integer[][] equals2 = Arrays.copyOf(stuGrades, stuGrades.length);
        // 比较二维数组内容是否相等
        System.out.println(Arrays.deepEquals(stuGrades, equals2));

        //6.
        Integer[] fillArr = new Integer[5];
        // 将一个数组置为 val(5)
        Arrays.fill(fillArr, 5);
        arrayPrint(fillArr);
        // 将一个数组指定范围内置为 val(10) 含头不含尾
        Arrays.fill(fillArr, 2, 3, 10);
        arrayPrint(fillArr);

        // 7.
        Integer[] setAllArr = Arrays.copyOf(arrayTest, arrayTest.length);
        // 一个数组全部做表达式操作
        Arrays.setAll(setAllArr, a -> a * 3);
        System.out.println(Arrays.toString(setAllArr));

        //8.
        // Java8新特性，对array进行流式处理，可用一切流式处理的方法(将专门一篇来讲Lambda与Stream)
        Arrays.stream(arrayTest).map(a -> a * 2).filter(a -> a > 10).sorted().distinct().limit(6)
                .forEach(a -> System.out.print(a + " "));
        System.out.println();

        // 以下是多线程算法，处理数组(大多以parallel做为开头的方法，可以充分利用现代CPU多核，处理大规模庞大的数组很有效)
        // 9.
        Integer[] arrayPP1 = Arrays.copyOf(arrayTest, arrayTest.length);
        arrayPrint(arrayPP1);
        // 二元迭代，对原数组内容进行二元操作
        Arrays.parallelPrefix(arrayPP1, (x, y) -> x * y);
        arrayPrint(arrayPP1);
        Integer[] arrayPP2 = Arrays.copyOf(arrayTest, arrayTest.length);
        // 在指定下标范围内，对原数组内容进行二元操作，下标含头不含尾
        Arrays.parallelPrefix(arrayPP2, 0, 5, (x, y) -> x * y);
        arrayPrint(arrayPP2);

        //10.
        Integer[] arrayPSA = Arrays.copyOf(arrayTest, arrayTest.length);
        // 对原有数组对每个元素重新赋值，下面例子是 下标*5 然后赋到数组对应元素
        Arrays.parallelSetAll(arrayPSA, a -> a * 5);
        arrayPrint(arrayPSA);

        //11.
        Integer[] arrayPS1 = Arrays.copyOf(arrayTest, arrayTest.length);
        // 对数组进行升序排序
        Arrays.parallelSort(arrayPS1);
        arrayPrint(arrayPS1);
        // 对指定下标范围内的元素进行指定排序方法的排序，含头不含尾
        Arrays.parallelSort(arrayPS1, 0, 5, Comparator.reverseOrder());
        arrayPrint(arrayPS1);

        //12.
        // 返回一个Spliterator进行其它操作
        Spliterator<Integer> spliterator = Arrays.spliterator(arrayPS1);
        // 将原有Spliterator切出一部分为新的Spliterator，不可切时返回null
        Spliterator<Integer> integerSpliterator = spliterator.trySplit();
        // estimateSize 还有几个元素要处理
        while (spliterator.estimateSize() > 0) {
            // 对每个元素进行处理
            spliterator.tryAdvance(x -> System.out.print(x * 2 + " "));
        }

        System.out.println();

        // 对Spliterator遍历操作
        integerSpliterator.forEachRemaining(a -> System.out.print(a + " "));
        System.out.println();

        // 还有几个要遍历
        System.out.println(integerSpliterator.getExactSizeIfKnown());

        // 表示该Spliterator有那些特性，用于优化
        System.out.println(spliterator.characteristics());

    }

    // 懒人癌晚期
    private static void arrayPrint(Object[] oArray) {
        System.out.println(Arrays.toString(oArray));
    }
}
