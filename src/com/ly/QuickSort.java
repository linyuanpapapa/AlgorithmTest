package com.ly;

import edu.princeton.cs.algs4.StdRandom;
import static com.ly.Util.SortUtils.*;

/**
 * @Author:LinYuan
 * @Description:
 * @Date: Create in 11:26 2019/7/31
 * @Modified By:
 * 快速排序，应用最广泛的排序算法
 * 哨兵算法
 * 最好情况是每次都正好能将数组对半分
 */
public class QuickSort {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);//消除对输入的依赖
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int t = partition(a, lo, hi);
        sort(a, lo, t - 1);//递归对分区的两个子数组进行快排
        sort(a, t + 1, hi);

    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int k = lo, i = lo, j = hi + 1;//将第一个元素作为基准元素
        while (true) {
            while (less(a[++i], a[k])) if (i == hi) break;//左哨兵往右移动知道找到i位置小于k位置的元素
            while (less(a[k], a[--j])) if (j == lo) break;//右哨兵往左移动知道找到j位置大于k位置的元素
            if (i >= j) break;//哨兵相遇时结束迭代
            exch(a, i, j);
        }
        exch(a, lo, j);//将基准元素和中间元素做交换
        return j;
    }


    public static void main(String[] args) {
        String[] a = {"bed", "bug", "yes", "zoo", "panda", "all", "yet", "shit"};
        sort(a);
        assert isSorted(a);
        show(a);

    }
}
