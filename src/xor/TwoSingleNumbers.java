package xor;

import java.util.Arrays;

/**
 * @author ZRH
 * @date 2021/1/10 13:56
 */
public class TwoSingleNumbers {
    public static int[] findSingleNumbers(int[] nums) {
        int x = 0;
        for (int i : nums) {
            x ^= i;
        }
        int rightIndex = 1;
        while ((x & rightIndex) == 0) {
            rightIndex = rightIndex << 1;
        }
        int x1 = 0, x2 = 0;
        for (int i : nums) {
            if ((i & rightIndex) == 0) {
                x1 ^= i;
            } else {
                x2 ^= i;
            }
        }
        return new int[]{x1, x2};
    }

    public static void main(String[] args) {
        int[] arr = findSingleNumbers(new int[]{1, 4, 2, 1, 3, 5, 6, 2, 3, 5});
        System.out.println(Arrays.toString(arr));
        arr = findSingleNumbers(new int[]{2, 1, 3, 2});
        System.out.println(Arrays.toString(arr));
    }
}
