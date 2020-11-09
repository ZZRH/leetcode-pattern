package cyclicsort;

public class MissingNumber {
    public static int findMissingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i || nums[i] >= nums.length) {
                i++;
            } else {
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j) {
                return j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findMissingNumber(new int[]{4, 0, 3, 1}));
        System.out.println(findMissingNumber(new int[]{8, 3, 5, 2, 4, 6, 0, 1}));
    }
}
