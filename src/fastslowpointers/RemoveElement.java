package fastslowpointers;

public class RemoveElement {
    public static int remove(int[] arr, int key) {
        int nextElementIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != key) {
                arr[nextElementIndex] = arr[i];
                nextElementIndex++;
            }
        }

        // 显示
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nextElementIndex; i++) {
            stringBuilder.append("," + arr[i]);
        }
        if (stringBuilder.length()>0) {
            stringBuilder.deleteCharAt(0);
        }
        System.out.println(stringBuilder);
        return nextElementIndex;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 2, 3, 6, 3, 10, 9, 3};
        System.out.println(remove(arr, 3));
        arr = new int[] {2, 11, 2, 2, 1};
        System.out.println(remove(arr, 2));
    }
}
