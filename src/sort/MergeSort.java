package sort;

import java.util.Arrays;

/**
 * @author ZRH
 * @date 2021/1/20 22:21
 */
public class MergeSort implements SortInterface{
    public static void sort(Comparable[] arr) {
        mergeSort(arr, 0, arr.length-1);
    }

    private static void mergeSort(Comparable[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left+right) >>> 1;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(Comparable[] arr, int left, int mid, int right) {
        Comparable[] comparables = new Comparable[right - left + 1];
        int a = left, b = mid+1;
        for (int i = 0; i < comparables.length; i++) {
            if (a > mid) {
                comparables[i] = arr[b++];
                continue;
            }
            if (b > right) {
                comparables[i] = arr[a++];
                continue;
            }
            if (arr[a].compareTo(arr[b]) <= 0) {
                comparables[i] = arr[a++];
            } else {
                comparables[i] = arr[b++];
            }
        }
        for (int i = 0; i < comparables.length; i++) {
            arr[left+i] = comparables[i];
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
