package binarysearch;

/**
 * @author ZRH
 * @date 2021/1/5 20:25
 */
public class SearchInfiniteSortedArray {
    public static int search(ArrayReader reader, int key) {
        int left = 0, right = 1;
        while (true) {
            int value = reader.get(right);
            if (value < key) {
                left = right + 1;
                right = right << 1;
            } else if (value == key) {
                return right;
            } else {
                right--;
                break;
            }
        }
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int v = reader.get(mid);
            if (v > key) {
                right = mid - 1;
            } else if (v == key) {
                return mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayReader reader = new ArrayReader(new int[]{4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30});
        System.out.println(search(reader, 16));
        System.out.println(search(reader, 11));

        reader = new ArrayReader(new int[]{1, 3, 8, 10, 15});
        System.out.println(search(reader, 15));
        System.out.println(search(reader, 200));
    }
}

class ArrayReader {
    int[] arr;

    public ArrayReader(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        if (index >= arr.length) {
            return Integer.MAX_VALUE;
        }
        return arr[index];
    }
}