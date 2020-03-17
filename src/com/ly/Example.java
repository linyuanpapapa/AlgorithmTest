package com.ly;

public class Example {
    public static void sort(Comparable[] a) {

    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    //compareTo()方法，v>w时返回1，相等时返回0，v<w时返回-1
    //less()方法，前者大于等于后者时返回0，前者小于后者时返回1；

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + "  ");
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static void main(String[] args) {
        String[] a = {"bed", "bug", "yes", "zoo", "panda", "all", "yet", "shit"};
        sort(a);
        assert isSorted(a);
        show(a);

    }
}
