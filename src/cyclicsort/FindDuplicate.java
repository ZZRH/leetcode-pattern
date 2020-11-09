package cyclicsort;

public class FindDuplicate {
    public static int findNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 == i) {
                continue;
            } else if (nums[nums[i] - 1] == nums[i]) {
                return nums[i];
            } else {
                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;
                i--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findNumber(new int[]{1, 4, 4, 3, 2}));
        System.out.println(findNumber(new int[]{2, 1, 3, 3, 5, 4}));
        System.out.println(findNumber(new int[]{2, 4, 1, 4, 4}));
    }
}
