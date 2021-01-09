package binarysearch;

/**
 * @author ZRH
 * @date 2021/1/5 22:15
 */
public class SearchBitonicArray {
    public static int search(int[] arr, int key) {
        int left = 0, right = arr.length-1;
        while (left < right) {
            int mid = (left+right) >>> 1;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int leftIndex = search(arr, key, 0, left);
        int rightIndex = search(arr, key, left + 1, arr.length - 1);
        if (leftIndex == -1) {
            return rightIndex;
        }
        if (rightIndex == -1) {
            return leftIndex;
        }
        if (leftIndex == -1 && rightIndex == -1) {
            return -1;
        }
        System.out.println("找到两个: " + leftIndex + " " + rightIndex);
        return leftIndex;
    }

    private static int search(int[] arr, int key, int left, int right) {
        if (right < left) {
            return -1;
        }
        boolean ascending = false;
        if (left == 0) {
            ascending = true;
        }
        while (left <= right) {
            int mid = (left+right) >>> 1;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key ^ ascending) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 3, 8, 12, 3, 2}, 3));
        System.out.println(search(new int[]{3, 8, 3, 1}, 8));
        System.out.println(search(new int[]{1, 3, 8, 12}, 12));
        System.out.println(search(new int[]{10, 9, 8}, 33));
    }
}
