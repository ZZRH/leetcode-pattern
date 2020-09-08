package twopointers;

import java.util.Arrays;

public class SortedArraySquares {
    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        if (arr.length == 0) {
            return squares;
        }
        int left = 0, right = arr.length-1;
        for (int i = squares.length - 1; i >= 0; i--) {
            int leftValue = Math.abs(arr[left]);
            int rightValue = Math.abs(arr[right]);
            if (leftValue >= rightValue) {
                squares[i] = leftValue * leftValue;
                left++;
            } else {
                squares[i] = rightValue * rightValue;
                right--;
            }
        }
        return squares;
    }

    public static void main(String[] args) {
        int[] result = makeSquares(new int[]{-2,-1,0,2,3});
        System.out.println(Arrays.toString(result));

        result = makeSquares(new int[]{-3,-1,0,1,2});
        System.out.println(Arrays.toString(result));

    }
}
