package slidingwindow;

public class ReplacingOnes {
    /**
     * Given an array containing 0s and 1s,
     * if you are allowed to replace no more than ‘k’ 0s with 1s,
     * find the length of the longest contiguous subarray having all 1s.
     * @param arr
     * @param k
     * @return
     */
    public static int findLength(int[] arr, int k) {
        int winStart = 0, maxLength = 0, zeroTimes = 0;
        for (int winEnd = 0; winEnd < arr.length; winEnd++) {
            if (arr[winEnd] == 0) {
                zeroTimes++;
            }
            if (zeroTimes > k) {
                if (arr[winStart] == 0) {
                    zeroTimes--;
                }
                winStart++;
            }
            maxLength = Math.max(maxLength, winEnd - winStart +1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findLength(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2));
        System.out.println(findLength(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3));
    }
}
