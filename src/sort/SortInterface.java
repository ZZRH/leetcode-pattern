package sort;

/**
 * @author ZRH
 * @date 2021/1/20 12:02
 */
public interface SortInterface {
    static void swap(Comparable[] arr, int i, int j) {
        if (i != j) {
            Comparable temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
