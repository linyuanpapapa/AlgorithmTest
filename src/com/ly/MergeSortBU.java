package com.ly;

import static com.ly.Util.SortUtils.*;
/**
 * @Author:LinYuan
 * @Description:
 * @Date: Create in 2019/7/27 18:40
 * @Modified By:
 * 自底向上的归并排序
 */
public class MergeSortBU {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        //进行lgN次两两归并
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz += sz)
            for (int lo = 0; lo < N - sz; lo += sz + sz)
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        //将a[lo,mid]和a[mid+1,hi]进行归并
        int i = lo, j = mid + 1;
        //将数组a的数组都复制到数组aux里
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int p = lo; p <= hi; p++) {
            if (i > mid) a[p] = aux[j++];
            else if (j > hi) a[p] = aux[i++];
            else if (less(aux[i], aux[j])) a[p] = aux[i++];
            else a[p] = aux[j++];
        }
    }

    public static void main(String[] args) {
        String[] a = {"bed", "bug", "yes", "zoo", "panda", "all", "yet", "shit"};
        sort(a);
        if (!isSorted(a)) System.out.println("haimei");
        show(a);

    }

}


