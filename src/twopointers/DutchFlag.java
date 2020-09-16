package twopointers;

import java.util.Arrays;

public class DutchFlag {
    public static void sort(int[] arr) {
        int left = 0, right = arr.length-1;
        for (int i = 0; i <= right; i++) {
            if (arr[i] == 0) {
                int temp = arr[i];
                arr[i] = arr[left];
                arr[left] = temp;
                if (i != left) {
                    i--;
                }
                left++;
            } else if (arr[i] == 2) {
                int temp = arr[i];
                arr[i] = arr[right];
                arr[right] = temp;
                if (i != left) {
                    i--;
                }
                right--;
            }
//            System.out.println(Arrays.toString(arr));
        }
    }

    public static void sort2(int[] arr) {
        int low = 0, high = arr.length - 1;
        for (int i = 0; i <= high; ) {
            if (arr[i] == 0) {
                swap(arr, i, low);
                i++;
                low++;
            } else if (arr[i] == 1) {
                i++;
            } else {
                swap(arr, i, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 1, 0};
        sort2(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{2, 2, 0, 1, 2, 0};
        sort2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
