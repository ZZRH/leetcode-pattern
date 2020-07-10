package slidingwindow;

public class MaxSumSubArrayOfSizeK {
    /**
     * Given an array of positive numbers and a positive number ‘k’,
     * find the maximum sum of any contiguous subarray of size ‘k’.
     * @param k
     * @param arr
     * @return
     */
    public static int findMaxSumSubArray(int k, int[] arr) {
        int maxValue = 0;
        int winSum = 0;
        int startPosition = 0;
        for (int endPosition = 0; endPosition < arr.length; endPosition++) {
            winSum += arr[endPosition];
            if (endPosition >= k-1) {
                maxValue = Math.max(maxValue, winSum);
                winSum -= arr[startPosition];
                startPosition++;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int result = findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2});
        System.out.println(result);
        result = findMaxSumSubArray(2, new int[]{2, 3, 4, 1, 5});
        System.out.println(result);
    }
}
