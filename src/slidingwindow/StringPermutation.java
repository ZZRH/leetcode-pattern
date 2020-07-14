package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation {
    /**
     * Given a string and a pattern, find out if the string contains any permutation of the pattern.
     * @param str
     * @param pattern
     * @return
     */
    public static boolean findPermutation(String str, String pattern) {
        int winStart = 0;
        Map<Character, Integer> charRemain = new HashMap<>();
        for (int i = 0; i<pattern.length(); i++) {
            char temp = pattern.charAt(i);
            charRemain.put(temp, charRemain.getOrDefault(temp, 0)+1);
        }
        for (int winEnd = 0; winEnd < str.length(); winEnd++) {
            char rightChar = str.charAt(winEnd);
            charRemain.put(rightChar, charRemain.getOrDefault(rightChar, 0) -1);
            if (charRemain.get(rightChar) == 0) {
                charRemain.remove(rightChar);
            }
            if (winEnd>=pattern.length()) {
                char leftChar = str.charAt(winStart);
                charRemain.put(leftChar, charRemain.getOrDefault(leftChar, 0) + 1);
                if (charRemain.get(leftChar) == 0) {
                    charRemain.remove(leftChar);
                }
                winStart++;
            }
            if (charRemain.size() == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean findPermutation2(String s2, String s1) {
        int winStart = 0;
        Map<Character, Integer> charRemain = new HashMap<>();
        for (int i = 0; i<s1.length(); i++) {
            char temp = s1.charAt(i);
            charRemain.put(temp, charRemain.getOrDefault(temp, 0)+1);
        }
        for (int winEnd = 0; winEnd < s2.length(); winEnd++) {
            char rightChar = s2.charAt(winEnd);
            charRemain.put(rightChar, charRemain.getOrDefault(rightChar, 0) -1);
            if (charRemain.get(rightChar) == 0) {
                charRemain.remove(rightChar);
            }
            if (winEnd>=s1.length()) {
                char leftChar = s2.charAt(winStart);
                charRemain.put(leftChar, charRemain.getOrDefault(leftChar, 0) + 1);
                if (charRemain.get(leftChar) == 0) {
                    charRemain.remove(leftChar);
                }
                winStart++;
            }
            if (charRemain.size() == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(findPermutation("oidbcaf", "abc"));
        System.out.println(findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println(findPermutation("aaacb", "abc"));
        System.out.println(findPermutation("aaacb", "dc"));
    }
}
