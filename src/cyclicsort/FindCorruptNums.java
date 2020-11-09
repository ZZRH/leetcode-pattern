package cyclicsort;

import java.util.Arrays;

public class FindCorruptNums {
    public static int[] findNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            } else {
                i++;
            }
        }
        for (int t = 0; t < nums.length; t++) {
            if (nums[t] - 1 != t) {
                return new int[]{nums[t], t+1};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = findNumbers(new int[]{3, 1, 2, 5, 2});
        Arrays.stream(numbers).forEach(i-> System.out.print(i + "*"));
        System.out.println("\b\n");

        numbers = findNumbers(new int[]{3, 1, 2, 3, 6, 4});
        Arrays.stream(numbers).forEach(i-> System.out.print(i + "*"));
        System.out.println("\b\n");
    }
}
