package twopointers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TripletWithSmallerSum {
    public static int searchTriplets(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i <= arr.length - 3; i++) {
            for (int right = arr.length - 1; right > i; right--) {
                for (int left = right - 1; left > i; left--) {
                    if (arr[left] + arr[right] < target - arr[i]) {
                        count += left - i;
                        break;
                    }
                }
            }
        }
        return count;
    }

    public static List<List<Integer>> searchTripletsWithDetail(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new LinkedList<>();
        for (int i = 0; i <= arr.length - 3; i++) {
            for (int right = arr.length - 1; right > i; right--) {
                for (int left = right - 1; left > i; left--) {
                    if (arr[left] + arr[right] < target - arr[i]) {
                        for (int k = i + 1; k <= left; k++) {
                            triplets.add(Arrays.asList(arr[i], arr[k], arr[right]));
                        }
                        break;
                    }
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
//        System.out.println(searchTriplets(new int[]{-1, 0, 2, 3}, 3));
//        System.out.println(searchTriplets(new int[]{-1, 4, 2, 1, 3}, 5));
//
//        List<List<Integer>> lists = searchTripletsWithDetail(new int[]{-1, 0, 2, 3}, 3);
//        lists.stream().forEach(list->{
//            String s = Arrays.toString(list.toArray());
//            System.out.println(s);
//        });

        List<List<Integer>> lists = searchTripletsWithDetail(new int[]{-1, 4, 2, 1, 3}, 5);
        lists.stream().forEach(list->{
            String s = Arrays.toString(list.toArray());
            System.out.println(s);
        });
    }
}
