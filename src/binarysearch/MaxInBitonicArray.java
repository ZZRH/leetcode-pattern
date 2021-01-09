package binarysearch;

/**
 * @author ZRH
 * @date 2021/1/5 21:10
 */
public class MaxInBitonicArray {
    public static int findMax(int[] arr) {
        return findMax(arr, 0, arr.length-1);
    }

    private static int findMax(int[] arr, int left, int right) {
        while (left < right-1) {
            int mid = (left+right) >>> 1;
            if (arr[left] == arr[right]) {
                int leftValue = findMax(arr, left, mid);
                int rightValue = findMax(arr, mid + 1, right);
                return Math.max(leftValue, rightValue);
            } else if (arr[left] < arr[right]) {
                if (arr[mid] <= arr[right]) {
                    left = mid;
                } else {
                    int leftValue = findMax(arr, left, mid);
                    int rightValue = findMax(arr, mid + 1, right);
                    return Math.max(leftValue, rightValue);
                }
            } else {
                if (arr[mid] <= arr[left]) {
                    right = mid;
                } else {
                    int leftValue = findMax(arr, left, mid);
                    int rightValue = findMax(arr, mid + 1, right);
                    return Math.max(leftValue, rightValue);
                }
            }
        }
        return Math.max(arr[left], arr[right]);
    }

    public static void main(String[] args) {
        System.out.println(findMax(new int[]{1, 3, 8, 12, 4, 2}));
        System.out.println(findMax(new int[]{3, 8, 3, 1}));
        System.out.println(findMax(new int[]{1, 3, 8, 12}));
        System.out.println(findMax(new int[]{10, 9, 8}));
    }
}
