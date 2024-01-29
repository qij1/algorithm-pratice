package sort;

import static sort.SelectionSort.swap;

public class InsertionSort {

    public void insertSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            for(int j = i-1; j >= 0 && arr[j] > arr[j+1]; j--) {
                swap(arr, j, j+1);
            }
        }
    }
}
