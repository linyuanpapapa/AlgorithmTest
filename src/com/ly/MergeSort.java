package com.ly;

import static com.ly.Util.SortUtils.*;
/**
 * 归并排序
 * 分而治之，先分，后治，治指的是合并
 * 一边分治一边归并
 */
public class MergeSort {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];//算法的开始，申请一个和原数组一样大的数组用于保存
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        //将数组a[lo,hi]排序
        if (hi <= lo) return;
        if (hi - lo <= 4) Insertion.sort(a);//当数组中元素过少时，使用插入排序以节省空间
        int mid = lo + (hi - lo) / 2;//这样计算可以避免溢出
        sort(a, 0, mid);//调用自身把前后两个数组分别排序
        sort(a, mid + 1, hi);
        if (less(a[mid], a[mid + 1])) return;//如果第一个有序子数组的最后一位小于第二个的第一位，跳过归并操作。
        merge(a, lo, hi, mid);//归并

    }

    public static void merge(Comparable[] a, int lo, int hi, int mid) {
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
    //最后一个改进在于节省元素拷贝到辅助数组的时间，每一次递归时转换一下原数组和辅助数组的位置
//    public static void sort(Comparable[] a,Comparable[] aux,int lo,int hi){
//        //将数组a[lo,hi]排序
//        if(hi<=lo) return;
//        int mid=lo+(hi-lo)/2;
//        sort(aux,a,lo,mid);
//        sort(aux,a,mid+1,hi);
//        merge(a,aux,lo,hi,mid);
//
//    }
//    public static void merge(Comparable[] aux,int lo,int hi,int mid){
//        //将a[lo,mid]和a[mid+1,hi]进行归并
//        int i=lo,j=mid+1;
//        //将数组a的数组都复制到数组aux里
//        for(int k=lo;k<=hi;k++){
//            aux[k]=a[k];
//        }
//        for(int p=lo;p<=hi;p++) {
//            if (i > mid)                    aux[p] = a[j++];
//            else if (j > hi)                aux[p] = a[i++];
//            else if (less(aux[i], aux[j]))  aux[p]=a[i++];
//            else                            aux[p]=a[j++];
//        }
//    }


    public static void main(String[] args) {
        String[] a = {"bed", "bug", "yes", "zoo", "panda", "all", "yet", "shit"};
        sort(a);
        if (!isSorted(a)) System.out.println("haimei");
        show(a);

    }

}
