package cyclicsort;

public class DuplicateNumber {
    public static int findDuplicate(int[] arr) {
        int slow = 0, fast = 0;
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);
        int current = slow;
        int circleLength = 0;
        do {
            current = arr[current];
            circleLength++;
        } while (current != slow);

        int index1 = arr[0], index2 = arr[0];
        while (circleLength > 0) {
            index2 = arr[index2];
            circleLength--;
        }
        while (index1 != index2) {
            index1=arr[index1];
            index2=arr[index2];
        }
        return index1;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 4, 4, 3, 2}));
        System.out.println(findDuplicate(new int[]{2, 1, 3, 3, 5, 4}));
        System.out.println(findDuplicate(new int[]{2, 4, 1, 4, 4}));
    }
}
