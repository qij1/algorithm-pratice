package sort;

/**
 * 选择
 */
public class SelectionSort {

    public static void selectionSort(int arr[]) {
        for(int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for(int j = i; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]) minIndex = j;
            }
            swap(arr, minIndex, i);
        }

    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = generateRandomArray(10, 100);
        printArray(arr);
        selectionSort(arr);
        printArray(arr);
    }
}
