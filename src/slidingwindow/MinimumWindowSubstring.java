package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    /**
     * Given a string and a pattern,
     * find the smallest substring in the given string which has all the characters of the given pattern.
     *
     * @param str
     * @param pattern
     * @return
     */
    public static String findSubstring(String str, String pattern) {
        int winStart = 0, matched = 0;
        int minStart = 0, minEnd = str.length();
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char temp = pattern.charAt(i);
            charFrequencyMap.put(temp, charFrequencyMap.getOrDefault(temp, 0) + 1);
        }
        for (int winEnd = 0; winEnd < str.length(); winEnd++) {
            char rightChar = str.charAt(winEnd);
            if (charFrequencyMap.containsKey(rightChar)) {
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) == 0) {
                    matched++;
                }
            }
            while (matched == charFrequencyMap.size()) {
                if (winEnd-winStart+1<minEnd-minStart+1) {
                    minEnd = winEnd;
                    minStart = winStart;
                }
                char leftChar = str.charAt(winStart);
                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap.get(leftChar) == 0) {
                        matched--;
                    }
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) +1);
                }
                winStart++;
            }
        }
        if (minStart == 0 && minEnd == str.length()) {
            return "";
        }
        return str.substring(minStart, minEnd+1);
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("aabdec", "abc"));
        System.out.println(findSubstring("abdabca", "abc"));
        System.out.println(findSubstring("adcad", "abc"));
    }
}
