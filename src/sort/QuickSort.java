package sort;

import java.util.Arrays;

/**
 * @author ZRH
 * @date 2021/1/19 22:16
 */
public class QuickSort {
    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length-1);
    }

    private static void sort(Comparable[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            sort(arr, left, partitionIndex-1);
            sort(arr, partitionIndex+1, right);
        }
    }

    private static int partition(Comparable[] arr, int left, int right) {
        int minIndex = left+1;
        for (int i = left+1; i <= right; i++) {
            if (arr[i].compareTo(arr[left]) < 0) {
                swap(arr, minIndex, i);
                minIndex++;
            }
        }
        swap(arr, left, minIndex-1);
        return minIndex-1;
    }

    private static void swap(Comparable[] arr, int i, int j) {
        if (i != j) {
            Comparable temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
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
