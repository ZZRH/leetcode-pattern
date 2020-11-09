package cyclicsort;

import java.util.ArrayList;
import java.util.List;

public class AllMissingNumbers {
    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1 && nums[nums[i] - 1] - 1 != nums[i] - 1) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
                i--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                missingNumbers.add(i+1);
            }
        }
        return missingNumbers;
    }

    public static void main(String[] args) {
        List<Integer> missing = findNumbers(new int[]{2, 3, 1, 8, 2, 3, 5, 1});
        System.out.println(missing);

        missing = findNumbers(new int[]{2, 4, 1, 2});
        System.out.println(missing);

        missing = findNumbers(new int[]{2, 3, 2, 1});
        System.out.println(missing);
    }
}
