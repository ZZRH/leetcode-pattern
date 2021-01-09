package binarysearch;

/**
 * @author ZRH
 * @date 2020/12/30 16:01
 */
public class CeilingOfANumber {
    public static int searchCeilingOfANumber(int[] arr, int key) {
        if (arr == null || arr.length == 0 || key > arr[arr.length-1]) {
            return -1;
        }
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int v = arr[middle];
            if (v == key) {
                return middle;
            } else if (v < key) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(searchCeilingOfANumber(new int[]{4,6,10}, 6));
        System.out.println(searchCeilingOfANumber(new int[]{1,3,8,10,15}, 12));
        System.out.println(searchCeilingOfANumber(new int[]{4,6,10}, 17));
        System.out.println(searchCeilingOfANumber(new int[]{4,6,10}, -1));
    }
}
