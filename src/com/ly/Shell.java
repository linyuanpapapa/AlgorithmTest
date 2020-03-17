package com.ly;

import static com.ly.Util.SortUtils.*;
/**
 * 希尔排序 快速排序的改进版
 * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序
 * 待整个序列中的记录"基本有序"时，再对全体记录进行依次直接插入排序
 * 平均时间复杂度：O(n log n)
 */
public class Shell {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;//1,4,13,40,121,364,1093....确认当前数组所能取的最大h值
        while (h >= 1){//在数组被分为一组之前，继续循环
            //此时数组以及被分成N/3组分别进行比较
            for (int i = h; i < N; i++) {//每一次循环保证每隔h个元素的元素组成的数组都有序
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    exch(a, j, j - h);
            }
            h = h / 3;
        }
    }


    public static void main(String[] args) {
        String[] a = {"bed", "bug", "yes", "zoo", "panda", "all", "yet", "shit"};
        sort(a);
        assert isSorted(a);
        show(a);

    }
}
