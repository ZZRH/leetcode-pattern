package twopointers;

public class TripletSumClosetoTarget {
    public static int searchTriplet(int[] arr, int targetSum) {
        int offset = Integer.MAX_VALUE;
        for (int i = 0; i <= arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int tempOffset = getPairOffset(arr, targetSum - arr[i], i + 1);
            if (tempOffset == 0) {
                return targetSum;
            }
            if (Math.abs(offset) > Math.abs(tempOffset)
                    || (Math.abs(offset) == Math.abs(tempOffset) && offset > 0 && tempOffset < 0) ) {
                offset = tempOffset;
            }
        }
        return targetSum + offset;
    }

    private static int getPairOffset(int[] arr, int targetSum, int startIndex) {
        int offset = Integer.MAX_VALUE;
        int left = startIndex, right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] == targetSum) {
                return 0;
            } else if (arr[left] + arr[right] > targetSum) {
                if (Math.abs(arr[left] + arr[right] - targetSum) < Math.abs(offset)
                        || (arr[left] + arr[right] - targetSum == Math.abs(offset) && offset > 0 && arr[left] + arr[right] - targetSum < 0)) {
                    offset = arr[left] + arr[right] - targetSum;
                }
                right--;
            } else {
                if (Math.abs(arr[left] + arr[right] - targetSum) < Math.abs(offset)
                        || (arr[left] + arr[right] - targetSum == Math.abs(offset) && offset > 0 && arr[left] + arr[right] - targetSum < 0)) {
                    offset = arr[left] + arr[right] - targetSum;
                }
                left++;
            }
        }
        return offset;
    }

    public static void main(String[] args) {
        System.out.println(searchTriplet(new int[]{-2, 0, 1, 2}, 2));
        System.out.println(searchTriplet(new int[]{-3, -1, 1, 2}, 1));
        System.out.println(searchTriplet(new int[]{1, 0, 1, 1}, 100));
    }
}
