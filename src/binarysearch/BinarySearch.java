package binarysearch;

/**
 * @author ZRH
 * @date 2020/12/30 15:10
 */
public class BinarySearch {
    public static int search(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        boolean ascending = false;
        if (arr[0] < arr[arr.length-1]) {
            ascending = true;
        }
        int left = 0, right = arr.length - 1;
        while (left <= right) {
//            int middle = left + (right-left)/2;
            int middle = (left + right) >>> 1;
            if (arr[middle] == key) {
                return middle;
            } else if ((arr[middle] < key) ^ ascending){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        // 此时left,right将key夹在中间，如果没有找到的话
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,6,10}, 10));
        System.out.println(search(new int[]{1,2,3,4,5,6,7}, 5));
        System.out.println(search(new int[]{10,6,4}, 10));
        System.out.println(search(new int[]{10,6,4}, 4));
    }
}
