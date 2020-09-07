package fastslowpointers;

public class HappyNumber {
    public static boolean find(int num) {
        if (num <= 0) {
            return false;
        }
        int slow = num, fast = num;
        do {
            slow = next(slow);
            fast = next(next(fast));
            if (fast == 1) {
                return true;
            }
        } while (slow != fast);
        return false;
    }

    private static int next(int n) {
        int sum = 0;
        int divisor = 10;
        while (n != 0) {
            int remainder = n%divisor;
            n = (n-remainder)/divisor;
            sum += remainder*remainder;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(find(23));
        System.out.println(find(12));
        System.out.println(find(313));

//        System.out.println(next(313));
    }
}
