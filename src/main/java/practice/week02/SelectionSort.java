package practice.week02;

import edu.princeton.cs.algs4.StdOut;

/**
 * 选择排序
 * 思路：
 * 从左至右取当前元素，从当前元素的右边元素里找到一个最小的元素，并与当前元素交换位置
 * 优劣：
 * （每一个当前元素）比较多次，交换一次
 * (N-1)+(N-2)+...+2+1+0 ~ N2/2 (N2=N的2次方)
 * 当数组是有序的，仍然要做很多无意义的比较
 */
public class SelectionSort {

    public static void sort(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 1, 6, 8, 4, 7, 5, 3, 0, 9};
        SelectionSort.sort(array);
        for (int a : array) {
            StdOut.println("数组内容：" + a);
        }
    }
}
