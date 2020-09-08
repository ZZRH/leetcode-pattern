package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TripletSumToZero {
    public static List<List<Integer>> searchTripletsDirectly(int[] arr) {
        //暴力解决法
        if (arr == null || arr.length < 3) {
            return null;
        }
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        /*while (left < right) {
            int temp = -arr[left] - arr[right];
            int index = Arrays.binarySearch(arr, left + 1, right, temp);
            if (index == -1) {
                continue;
            }
            List<Integer> list = Arrays.asList(arr[left], arr[index], arr[right]);
            triplets.add(list);
        }*/
        for (; left < arr.length - 1; left++) {
            for (right = left + 1; right < arr.length; right++) {
                int temp = -arr[left] - arr[right];
                int index = Arrays.binarySearch(arr, left + 1, right, temp);
                if (index < 0) {
                    continue;
                }
                List<Integer> list = Arrays.asList(arr[left], arr[index], arr[right]);
                triplets.add(list);
            }
        }
        List<List<Integer>> collect = triplets.stream().distinct().collect(Collectors.toList());
        return collect;
    }

    /**
     * 依次固定一个数，将剩余的数组使用双指针的方法来获取结果
     * @param arr
     * @return
     */
    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i <= arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            searchPair(arr, -arr[i], i+1, triplets);
        }
        return triplets;
    }

    private static void searchPair(int[] arr, int target, int left, List<List<Integer>> triplets) {
        int right = arr.length-1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                triplets.add(Arrays.asList(-target, arr[left], arr[right]));
                do {
                    left++;
                } while (left < right && arr[left] == arr[left - 1]);
                do {
                    right--;
                } while (left < right && arr[right] == arr[right + 1]);
            }
        }
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean changed = false;
            for (int j = arr.length - 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    changed = true;
                }
            }
            if (!changed) {
                return;
            }
        }
    }

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 3);
//        System.out.println(Arrays.toString(list.toArray()));

//        System.out.println(searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2}));
//        System.out.println(searchTriplets(new int[]{-5, 2, -1, -2, 3}));

//        int[] arr = {-3, 0, 1, 2, -1, 1, -2};
        int[] arr = {1,2,3,5,4,6};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
