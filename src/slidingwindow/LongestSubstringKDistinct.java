package slidingwindow;

import sun.applet.Main;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    /**
     * Given a string, find the length of the longest substring in it with no more than K distinct characters
     * @param str
     * @param k
     * @return
     */
    public static int findLength(String str, int k) {
        if (str == null) {
            return 0;
        }
        Map<Character, Integer> charMap = new HashMap<>();
        int winStart = 0;
        int longestLen = 0;
        for (int winEnd = 0; winEnd < str.length(); winEnd++) {
            if (charMap.containsKey(str.charAt(winEnd))) {
                Integer times = charMap.get(str.charAt(winEnd));
                charMap.put(str.charAt(winEnd), ++times);
            } else {
                charMap.put(str.charAt(winEnd), 1);
            }

            while (charMap.size()>k) {
                Integer times = charMap.get(str.charAt(winStart));
                if (times == null) {
                    System.out.println();
                }
                if (times.equals(1)) {
                    charMap.remove(str.charAt(winStart));
                } else {
                    times--;
                }
                winStart++;
            }
            longestLen = Math.max(longestLen, winEnd-winStart+1);
        }
        return longestLen;
    }

    public static void main(String[] args) {
        System.out.println(findLength("araaci", 2));
        System.out.println(findLength("araaci", 1));
        System.out.println(findLength("cbbebi", 3));
        System.out.println(findLength("cbbebi", 12));

    }
}
