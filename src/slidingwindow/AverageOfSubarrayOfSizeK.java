package slidingwindow;

import java.util.Arrays;

/**
 * Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
 */
public class AverageOfSubarrayOfSizeK {
    public static double[] findAveragers(int K, int[] arr) {
        double[] result = new double[arr.length - K + 1];
        int winStart = 0;
        double winSum = 0;
        for (int winEnd = 0; winEnd < arr.length; winEnd++) {
            winSum += arr[winEnd];
            if (winEnd >= K - 1) {
                result[winStart] = winSum / K;
                winSum -= arr[winStart];
                winStart++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        double[] result = AverageOfSubarrayOfSizeK.findAveragers(5, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2});
        System.out.println(Arrays.toString(result));
    }
}
