package sort;

/**
 * 冒泡
 */
public class BubbleSort {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sorted = new int[m+n];
        int p1 = 0, p2=0, i=0;
        while(p1<m || p2<n) {
            if(p1 == m) {
                sorted[i++] = nums2[p2++];
            } else if(p2 == n) {
                sorted[i++] = nums1[p1++];
            } else if(nums1[p1] > nums2[p2]) {
                sorted[i++] = nums2[p2++];
            } else {
                sorted[i++] = nums1[p1++];
            }
        }

        nums1 = sorted;
        System.out.println(nums1);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{4,5,6};
        merge(nums1, 3, nums2, 3);
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for(int e = arr.length; e > 0; e--) {
            for(int j = 0; j < e; j++) {
                if(arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    // 前提 i、j位置值不一样，不然变成 0 了
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
