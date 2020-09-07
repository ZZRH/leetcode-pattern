package fastslowpointers;

public class CircularArrayLoop {
    public static boolean loopExists(int[] arr) {
        if (arr.length <= 0) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (loopExists(arr, i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean loopExists(int[] arr, int index) {
        int slow = index, fast = index;
        boolean isForward;//循环方向
        if (arr[index] < 0) {
            isForward = false;
        } else if (arr[index] > 0) {
            isForward = true;
        } else {
            return true;
        }
        do {
            slow = move(arr, slow);
            fast = move(arr, fast);
            if (!isSameDirection(arr, fast, isForward)) {
                return false;
            }
            fast = move(arr, fast);
            if (!isSameDirection(arr, fast, isForward)) {
                return false;
            }
            if (slow == fast) {
                return true;
            }
        } while (true);
    }

    private static int move(int[] arr, int index) {
        int value = arr[index];
        int nextIndex = index + value;
        while (nextIndex < 0 || nextIndex >= arr.length) {
            if (nextIndex < 0) {
                nextIndex += arr.length;
            } else if (nextIndex >= arr.length) {
                nextIndex -= arr.length;
            }
        }
        return nextIndex;
    }

    private static boolean isSameDirection(int[] arr, int index, boolean isForward) {
        int value = arr[index];
        if (value == 0) {
            return false;
        }
        if (value > 0 && isForward || value < 0 && !isForward) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(isSameDirection(new int[]{1,2,-1,2,2}, 0, false));

//        System.out.println(loopExists(new int[]{1,2,-1,2,2}));
//        System.out.println(loopExists(new int[]{2,2,-1,2}));
//        System.out.println(loopExists(new int[]{2,1,-1,-2}));

        System.out.println(-5%10);
        System.out.println(-15%10);
    }
}
