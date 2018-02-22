package practice.week02;

import edu.princeton.cs.algs4.StdOut;

public class ShellSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i - h; j >= 0; j -= h) {
                    if (SortUtil.less(a[j], a[j - h])) {
                        SortUtil.exch(a, j, j - h);
                    } else {
                        break;
                    }
                }
            }
            h = h / 3;
        }
    }
    public static void main(String[] args) {
        int[] array = {2, 1, 6, 8, 4, 7, 5, 3, 0, 9};
        SelectionSort.sort(array);
        for (int a : array) {
            StdOut.println("shell数组内容：" + a);
        }
    }
}
