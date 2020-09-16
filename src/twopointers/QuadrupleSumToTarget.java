package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuadrupleSumToTarget {
    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        Arrays.sort(arr);
        for (int index1 = 0; index1 <= arr.length - 4; index1++) {
            for (int index2 = index1 + 1; index2 <= arr.length - 3; index2++) {
                int left = index2+1, right = arr.length-1;
                while (left < right) {
                    int tempResult = target-arr[left]-arr[right]-arr[index1]-arr[index2];
                    if (tempResult > 0) {
                        left++;
                    } else if (tempResult < 0) {
                        right--;
                    } else {
                        quadruplets.add(Arrays.asList(arr[index1], arr[index2], arr[left], arr[right]));
                        left++;
                        right--;
                    }
                }
            }
        }
        quadruplets = quadruplets.stream().distinct().collect(Collectors.toList());
        return quadruplets;
    }

    public static void main(String[] args) {
        List<List<Integer>> results = searchQuadruplets(new int[]{4, 1, 2, -1, 1, -3}, 1);
        results.stream().forEach(list->{
            System.out.println(Arrays.toString(list.toArray()));;
        });
        System.out.println(results);

        results = searchQuadruplets(new int[]{2, 0, -1, 1, -2, 2}, 2);
        results.stream().forEach(list->{
            System.out.println(Arrays.toString(list.toArray()));;
        });
    }
}
