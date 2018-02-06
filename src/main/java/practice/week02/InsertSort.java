package practice.week02;

import edu.princeton.cs.algs4.StdOut;

/**
 * 插入排序
 * 思路：
 * 从左至右取当前元素，从当前元素的左边元素里依次与当前元素比较大小，若大于当前元素就交换位置
 * 优劣：
 * （每一个当前元素）比较多次，交换多次
 *  ~ N2/4 (N2=N的2次方)
 * 当数组是有序的，不需要做无意义的比较
 */
public class InsertSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i ; j > 0; j--) {
                if (SortUtil.less(a[j], a[j-1])) {
                    SortUtil.exch(a, j, j-1);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 6, 1, 8, 4, 7, 5, 3, 0, 9};
        SelectionSort.sort(array);
        for (int a : array) {
            StdOut.println("数组内容：" + a);
        }
    }
}
