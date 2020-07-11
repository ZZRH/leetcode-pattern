package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {
    /**
     * Given an array of characters where each character represents a fruit tree,
     * you are given two baskets and your goal is to put maximum number of fruits in each basket.
     * The only restriction is that each basket can have only one type of fruit.
     * <p>
     * You can start with any tree,
     * but once you have started you can’t skip a tree.
     * You will pick one fruit from each tree until you cannot,
     * i.e., you will stop when you have to pick from a third fruit type.
     * <p>
     * Write a function to return the maximum number of fruits in both the baskets.
     *
     * @param arr
     * @param bucketNum 篮子的数量
     * @return
     */
    public static int findLength(char[] arr, int bucketNum) {
        int maxLength = 0, winStart = 0;
        Map<Character, Integer> buckets = new HashMap<>();
        for (int winEnd = 0; winEnd < arr.length; winEnd++) {
            char endFruit = arr[winEnd];
            buckets.put(endFruit, buckets.getOrDefault(endFruit, 0)+1);

            while (buckets.size() > bucketNum) {
                char startFruit = arr[winStart];
                if (buckets.get(startFruit).equals(1)) {
                    buckets.remove(startFruit);
                } else {
                    buckets.put(startFruit, buckets.get(startFruit)-1);
                }
                winStart++;
            }
            maxLength = Math.max(maxLength, winEnd-winStart+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findLength(new char[]{'A', 'B', 'C', 'A', 'C'}, 2));
        System.out.println(findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}, 2));

    }
}
