package practice.week02;

public class SelectionSort {

    public static void sort(int[] a){
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if(a[j]<a[min]){
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {2,1,6,8,4,7,5,3,0,9};
        SelectionSort.sort(array);
    }
}
