package xor;

/**
 * @author ZRH
 * @date 2021/1/9 21:18
 */
public class MissingNumber {
    public static int findMissingNumber(int[] arr) {
        int x = 1;
        for (int i = 2; i <= arr.length+1; i++) {
            x^=i;
        }
        for (int j : arr) {
            x ^= j;
        }
        return x;
    }

    public static int findMissingNumber2(int[] arr) {
        int n = arr.length + 1;
        int x1 = 1;
        for (int i = 2; i <= n; i++) {
            x1 = x1 ^ i;
        }

        int x2 = arr[0];
        for (int i = 1; i < n - 1; i++) {
            x2 = x2 ^ arr[i];
        }
        return x1 ^ x2;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 6, 4, 3};
        System.out.println(findMissingNumber(arr));
        System.out.println(findMissingNumber2(arr));
    }
}
