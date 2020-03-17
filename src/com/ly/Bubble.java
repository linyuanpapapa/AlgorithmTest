package com.ly;

import static com.ly.Util.SortUtils.*;

/**
 * 冒泡排序
 * 最佳时间复杂度：O(n)
 * 最差时间复杂度：O(n^2)
 * 平均时间复杂度：O(n^2)
 */
public class Bubble {
    public static void sort(Comparable[] a) {
        int N=a.length;
        for(int i=0;i<N;i++){
            for(int j=0;j<N-i-1;j++){
                if(!less(a[j],a[j+1])) exch(a,j,j+1);
            }
        }
    }

    public static void main(String[] args) {
        String[] a = {"bed", "bug", "yes", "zoo", "panda", "all", "yet", "shit"};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
