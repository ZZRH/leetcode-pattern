package cyclicsort;

import java.util.*;

/**
 * Given an unsorted array containing numbers and a number ‘k’, find the first ‘k’ missing positive numbers in the array.
 */
public class FirstKMissingPositive {
    public static List<Integer> findNumbers(int[] nums, int k) {
        List<Integer> result = new ArrayList<>(k);
        int i = 0;
        while (i < nums.length) {
            //跳过的情况：数字不是正数或需要交换的数字相同
            if (nums[i] <= 0 || nums[i] > nums.length || nums[nums[i] - 1] == nums[i]) {
                i++;
            } else {// 交换的情况：当前数字为正且交换的数字不能相同
                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;
            }
        }
//        Arrays.stream(nums).forEach(q-> System.out.print(q+" "));
//        System.out.println("\b\n");
        Set<Integer> hashSet = new HashSet<>(); //存储大于nums.length的数
        for (int t = 0; t < nums.length; t++) {
            if (nums[t] != t + 1) {
                result.add(t+1);
                if (result.size() == k) {
                    return result;
                }
            }
            if (nums[t] > nums.length) {
                hashSet.add(nums[t]);
            }
        }
        int temp = nums.length+1;
        while (result.size() < k) {
            if (!hashSet.contains(temp)) {
                result.add(temp);
            }
            temp++;
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = findNumbers(new int[]{3, -1, 4, 5, 5}, 3);
        System.out.println(numbers);

        numbers = findNumbers(new int[]{2, 3, 4}, 3);
        System.out.println(numbers);

        numbers = findNumbers(new int[]{-2, -3, 4}, 2);
        System.out.println(numbers);
    }
}
