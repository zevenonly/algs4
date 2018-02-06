package practice.week02;

public class ShellSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = N / 3 + 1;
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
}
