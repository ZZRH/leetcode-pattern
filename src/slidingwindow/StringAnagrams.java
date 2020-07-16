package slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagrams {
    /**
     * Given a string and a pattern,
     * find all anagrams of the pattern in the given string.
     * @param str
     * @param pattern
     * @return
     */
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<>();
        int winStart = 0;
        Map<Character, Integer> charOccurrences = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char tempChar = pattern.charAt(i);
            charOccurrences.put(tempChar, charOccurrences.getOrDefault(tempChar, 0) + 1);
        }
        int matchs = 0;
        for (int winEnd = 0; winEnd < str.length(); winEnd++) {
            char rightChar = str.charAt(winEnd);
            if (charOccurrences.containsKey(rightChar)) {
                int temp = charOccurrences.get(rightChar);
                charOccurrences.put(rightChar, temp - 1);
                if (temp == 1) {
                    matchs++;
                } else if (temp == 0) {
                    matchs--;
                }
            }
            if (winEnd>=pattern.length()) {
                char leftChar = str.charAt(winStart);
                if (charOccurrences.containsKey(leftChar)) {
                    int temp = charOccurrences.get(leftChar);
                    charOccurrences.put(leftChar, temp +1);
                    if (temp == -1) {
                        matchs++;
                    } else if (temp == 0) {
                        matchs--;
                    }
                }
                winStart++;
            }
            if (matchs == charOccurrences.size()) {
                resultIndices.add(winStart);
            }
        }
        return resultIndices;
    }

    /**
     * 参考答案
     * @param str
     * @param pattern
     * @return
     */
    public static List<Integer> findStringAnagrams2(String str, String pattern) {
        int windowStart = 0, matched = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray()) {
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
        }
        List<Integer> resultIndices  = new ArrayList<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charFrequencyMap.containsKey(rightChar)) {
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) -1);
                if (charFrequencyMap.get(rightChar) == 0) {
                    matched++;
                }
            }
            if (matched == charFrequencyMap.size()) {
                resultIndices.add(windowStart);
            }
            if (windowEnd >= pattern.length()-1) {
                char leftChar = str.charAt(windowStart++);
                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap.get(leftChar) == 0) {
                        matched--;
                    }
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
            }
        }



        return resultIndices;
    }

    public static void main(String[] args) {
//        System.out.println(findStringAnagrams2("ppqp", "pq"));
//        System.out.println(findStringAnagrams2("abbcabc", "abc"));
        System.out.println(findStringAnagrams2("abccccdcccdef", "dc"));
        System.out.println(findStringAnagrams("abccccdcccdef", "dc"));
    }
}
