package sort;

import java.util.Arrays;

/**
 * @author ZRH
 * @date 2021/1/21 21:48
 */
public class HeapSort implements SortInterface{
    public static void sort(Comparable[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = (arr.length >>> 1) - 1; i >= 0 ; i--) {
            heapify(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            SortInterface.swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    private static void heapify(Comparable[] arr, int i, int len) {
        int leftChild = (i << 1) + 1, rightChild = leftChild+1;
        int largestIndex = i;
        if (leftChild < len) {
            largestIndex = arr[largestIndex].compareTo(arr[leftChild])>=0 ? largestIndex : leftChild;
        }
        if (rightChild < len) {
            largestIndex = arr[largestIndex].compareTo(arr[rightChild])>=0 ? largestIndex : rightChild;
        }
        if (largestIndex == i) {
            return;
        } else {
            SortInterface.swap(arr, i, largestIndex);
            heapify(arr, largestIndex, len);
        }
    }

    public static void main(String[] args) {
        int length = 20;
        Integer[] arr = new Integer[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int)(Math.random()*100);
        }
        sort(arr);
        Arrays.stream(arr).forEach(i->System.out.print(i + " "));
    }
}
