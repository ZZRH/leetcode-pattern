package cyclicsort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicate {
    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> duplicateNumbers = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            if (nums[i] - 1 != i && nums[nums[i] - 1] - 1 != nums[i] - 1) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            } else {
                i++;
            }
        }
        Set<Integer> numSet = new HashSet<>();
        for (int t = 0; t < nums.length; t++) {
            if (nums[t] - 1 != t) {
                numSet.add(nums[t]);
            }
        }
        duplicateNumbers.addAll(numSet);
        return duplicateNumbers;
    }

    public static void main(String[] args) {
        List<Integer> numbers = findNumbers(new int[]{3, 4, 4, 5, 5});
        System.out.println(numbers);

        numbers = findNumbers(new int[]{5, 4, 7, 2, 3, 5, 3});
        System.out.println(numbers);
    }

}
