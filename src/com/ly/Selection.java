package com.ly;

import static com.ly.Util.SortUtils.*;
/**
 * 选择排序：
 * 最佳时间复杂度：O(n^2)
 * 最差时间复杂度：O(n^2)
 */
public class Selection {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++){
            int min = i;
            for (int j = i + 1; j < N; j++)
                if (less(a[j], a[min])) min = j;//找出元素中最小的哪一个，跟i进行交换
            exch(a, i, min);//每一趟循环后，最小值就会被交换到i的位置
        }

    }

    public static void main(String[] args) {
        String[] a = {"bed", "bug", "yes", "zoo", "panda", "all", "yet", "shit"};
        sort(a);
        assert isSorted(a);
        show(a);

    }
}
