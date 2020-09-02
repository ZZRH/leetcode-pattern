package fastslowpointers;

public class RemoveDuplicates {
    /**
     * Given an array of sorted numbers, remove all duplicates from it.
     * You should not use any extra space; after removing the duplicates in-place return the new length of the array.
     *
     * @param arr
     * @return
     */
    public static int remove(int[] arr) {
        if (arr.length <= 2) {
            return arr.length;
        }
        int nextNoDuplicateIndex = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[nextNoDuplicateIndex - 1] != arr[i]) {
                arr[nextNoDuplicateIndex] = arr[i];
                nextNoDuplicateIndex++;
            }
        }
        return nextNoDuplicateIndex;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2, 3, 3, 3, 6, 9, 9};
        System.out.println(remove(arr));
        arr = new int[] {2, 2, 2, 11};
        System.out.println(remove(arr));
    }
}
