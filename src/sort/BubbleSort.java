package sort;

import java.util.Arrays;

/**
 * @author ZRH
 * @date 2021/1/19 21:24
 */
public class BubbleSort {
    public static void sort(Comparable[] arr) {
        int lastSwapIndex = 0, arrBoundary = arr.length-1; // 优化2：内部遍历的边界，边界后面的数都是排好序的
        for (int i = 0; i < arr.length; i++) {
            boolean complete = true; // 优化1：使用标志位来判断是否已排好序了，通过一次循环中是否有交换来判断
            for (int j = 0; j < arrBoundary; j++) {
                if ((arr[j].compareTo(arr[j+1])) > 0) {
                    Comparable temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    complete = false;
                    lastSwapIndex = j;
                }
            }
            arrBoundary = lastSwapIndex;
            if (complete) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2,3,6,5,8,1};
        sort(arr);
        Arrays.stream(arr).forEach(i->System.out.print(i + " "));
    }
}
