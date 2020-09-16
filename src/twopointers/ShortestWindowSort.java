package twopointers;

public class ShortestWindowSort {
    public static int sort(int[] arr) {
        int resultLeftIndex = arr.length - 1;//待查找数组的第一个元素的前一个的下标
        int currentMin = arr[resultLeftIndex];
        for (int i = resultLeftIndex - 1; i >= 0; i--) {
            if (arr[i] <= currentMin) {
                currentMin = arr[i];
                continue;
            }
            i--;
            resultLeftIndex = -1;
            while (i >= 0) {
                if (arr[i] > currentMin) {
                    i--;
                } else {
                    currentMin = arr[i];
                    resultLeftIndex = i;
                    break;
                }
            }
        }
        int resultRightIndex = 0, currentMax = arr[resultRightIndex];
        for (int i = resultRightIndex + 1; i < arr.length; ) {
            if (arr[i] >= currentMax) {
                currentMax = arr[i];
                i++;
                continue;
            }
            resultRightIndex = arr.length;
            while (i < arr.length) {
                if (arr[i] >= currentMax) {
                    resultRightIndex = i;
                    i++;
                    break;
                } else {
                    i++;
                }
            }
        }
        System.out.println("debug: " + resultLeftIndex + " " + resultRightIndex);
        int resultLength = resultRightIndex - resultLeftIndex - 1;
        if (resultLength<=0) {
            return 0;
        }
        return resultLength;
    }

    public static int sort1(int[] arr) {
        int left = 0, right = arr.length-1;
        while (left < arr.length-1) {
            if (arr[left] <= arr[left + 1]) {
                left++;
            } else {
                break;
            }
        }
        if (left == arr.length - 1) {//数组已排序
            return 0;
        }
        while (right > 0) {
            if (arr[right] >= arr[right - 1]) {
                right--;
            } else {
                break;
            }
        }

        //寻找两者之间的最大值和最小值
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = left + 1; i < right; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        while (left >= 0) {
            if (arr[left] <= min) {
                break;
            } else {
                left--;
            }
        }
        while (right < arr.length) {
            if (arr[right] >= max) {
                break;
            } else {
                right++;
            }
        }
        return right-left-1;
    }

    public static void main(String[] args) {
        System.out.println(sort1(new int[]{1, 2, 5, 3, 7, 10, 9, 12}));
        System.out.println(sort1(new int[]{1, 3, 2, 0, -1, 7, 10}));
        System.out.println(sort1(new int[]{1, 2, 3}));
        System.out.println(sort1(new int[]{3, 2, 1}));
    }
}
