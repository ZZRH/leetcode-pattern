package slidingwindow;

public class MinSizeSubArraySum {
    /**
     * Given an array of positive numbers and a positive number ‘S’,
     * find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
     * Return 0, if no such subarray exists.
     * @param S
     * @param arr
     * @return
     */
    public static int findMinSubArray(int S, int[] arr) {
        int startPosintion = 0, endPosition = 0, winSum = 0;
        while (winSum < S && endPosition<arr.length) {
            winSum+=arr[endPosition];
            endPosition++;
        }
        if (winSum<S) {
            return 0;
        }
        if (endPosition-startPosintion==1) {
            return 1;
        }
        if (endPosition == arr.length) {
            return arr.length;
        }
        while (endPosition <= arr.length || startPosintion == endPosition) {
            if (winSum>=S) {
                winSum-=arr[startPosintion];
                startPosintion++;
            } else {
                if (endPosition == arr.length) {
                    break;
                }
                winSum = winSum -arr[startPosintion] + arr[endPosition];
                startPosintion++;
                endPosition++;
            }
        }
        return endPosition-startPosintion+1;
    }

    /**
     * 标准
     * @param S
     * @param arr
     * @return
     */
    public static int findMinSubArray2(int S, int[] arr) {
        int winStart = 0, minLenth = Integer.MAX_VALUE, winSum = 0;
        for (int winEnd = 0; winEnd < arr.length; winEnd++) {
            winSum += arr[winEnd];
            while (winSum>=S) {
                minLenth = Math.min(minLenth, winEnd-winStart+1);
                winSum-=arr[winStart];
                winStart++;
            }
        }
        return minLenth;
    }

    public static void main(String[] args) {
        int result = findMinSubArray2(7, new int[]{2, 1, 5, 2, 3, 2});
        System.out.println(result);
        result = findMinSubArray2(7, new int[]{2, 1, 5, 2, 8});
        System.out.println(result);
        result = findMinSubArray2(8, new int[]{3, 4, 1, 1, 6});
        System.out.println(result);
    }
}
