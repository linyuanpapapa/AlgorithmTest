package com.ly;

import static com.ly.Util.SortUtils.*;
/**
 * 插入排序
 * 每次都将一个元素与之前的有序序列进行比较
 * 当待排序元素遇到比他大的元素时，就进行交换
 * 直到遇到比他小的，此时，他也插入到有序序列中的正确位置了
 * 最佳时间复杂度：O(n)
 * 最差时间复杂度：O(n^2)
 *
 */
public class Insertion {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
                exch(a, j, j - 1);
        }
    }

    public static void main(String[] args) {
        String[] a = {"bed", "bug", "yes", "zoo", "panda", "all", "yet", "shit"};
        sort(a);
        assert isSorted(a);
        show(a);

    }
}
