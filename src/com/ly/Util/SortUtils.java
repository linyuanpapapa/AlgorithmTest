package com.ly.Util;

public class  SortUtils {
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    //compareTo()方法，v>w时返回1，相等时返回0，v<w时返回-1
    //less()方法，前者大于等于后者时返回0，前者小于后者时返回1；

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + "  ");
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;//前者大于后者时，返回false
        return true;//排序正确时返回true
    }
}
