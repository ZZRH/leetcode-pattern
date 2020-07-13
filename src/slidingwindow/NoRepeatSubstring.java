package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NoRepeatSubstring {
    /**
     * Given a string, find the length of the longest substring which has no repeating characters.
     *
     * @param str
     * @return
     */
    public static int findLength(String str) {
        int maxLength = 0, winStart = 0;
        Set<Character> charSet = new HashSet<>();
        for (int winEnd = 0; winEnd < str.length(); winEnd++) {
            while (charSet.contains(str.charAt(winEnd))) {
                charSet.remove(str.charAt(winStart));
                winStart++;
            }
            charSet.add(str.charAt(winEnd));
            maxLength = Math.max(maxLength, winEnd - winStart +1);
        }
        return maxLength;
    }

    /**
     * 参考答案
     * @param str
     * @return
     */
    public static int findLength2(String str) {
        int maxLength = 0, winStart = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        for (int winEnd = 0; winEnd < str.length(); winEnd++) {
            char charRight = str.charAt(winEnd);
            if (charIndexMap.containsKey(charRight)) {
                winStart = Math.max(winStart, charIndexMap.get(charRight) + 1);
            }
            charIndexMap.put(charRight, winEnd);
            maxLength = Math.max(maxLength, winEnd - winStart +1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findLength2("aabccbb"));
        System.out.println(findLength2("abbbb"));
        System.out.println(findLength2("abccde"));
    }
}
