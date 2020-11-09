package cyclicsort;

/**
 * Given an unsorted array containing numbers, find the smallest missing positive number in it.
 */
public class FirstMissingPositive {
    public static int findNumber(int[] nums) {
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
        for (int t = 0; t < nums.length; t++) {
            if (nums[t] != t + 1) {
                return t+1;
            }
        }
        return nums.length+1;
    }

    public static void main(String[] args) {
        System.out.println(findNumber(new int[]{-3, 1, 5, 4, 2}));
        System.out.println(findNumber(new int[]{3, -2, 0, 1, 2}));
        System.out.println(findNumber(new int[]{3, 2, 5, 1}));
        System.out.println(findNumber(new int[]{3, 2, 5, 1 ,1, 1, 1, 1}));

    }
}
