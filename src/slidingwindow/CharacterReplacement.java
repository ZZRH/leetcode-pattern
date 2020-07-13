package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {
    /**
     * Given a string with lowercase letters only,
     * if you are allowed to replace no more than ‘k’ letters with any letter,
     * find the length of the longest substring having the same letters after replacement.
     *
     * @param str
     * @param k
     * @return
     */
    public static int findLength(String str, int k) {
        int maxLength = 0, winStart = 0;
        Map<Character, Integer> charTimes = new HashMap<>();
        for (int winEnd = 0; winEnd < str.length(); winEnd++) {
            char rightChar = str.charAt(winEnd);
            charTimes.put(rightChar, charTimes.getOrDefault(rightChar, 0) + 1);
            while (true) {
                int maxTimes = 0, totalTimes = 0;
                char maxChar = '0';
                for (Map.Entry<Character, Integer> entry : charTimes.entrySet()) {
                    totalTimes+=entry.getValue();
                    if (maxTimes<entry.getValue()) {
                        maxTimes = entry.getValue();
                        maxChar = entry.getKey();
                    }
                }
                if (totalTimes - charTimes.get(maxChar) > k) {
                    char startChar = str.charAt(winStart);
                    charTimes.put(startChar, charTimes.getOrDefault(startChar, 0) -1);
                    if (charTimes.get(startChar) == 0) {
                        charTimes.remove(startChar);
                    }
                    winStart++;
                } else {
                    break;
                }
            }
            maxLength = Math.max(maxLength, winEnd - winStart +1);
        }
        return maxLength;
    }

    /**
     * reference answer
     * @param str
     * @param k
     * @return
     */
    public static int findLength2(String str, int k) {
        int winStart = 0, maxLength = 0, maxRepeatTimes = 0;
        Map<Character, Integer> charRepeatFrequencyMap = new HashMap<>();
        for (int winEnd = 0; winEnd < str.length(); winEnd++) {
            char rightChar = str.charAt(winEnd);
            charRepeatFrequencyMap.put(rightChar, charRepeatFrequencyMap.getOrDefault(rightChar, 0) + 1);
            maxRepeatTimes = Math.max(maxRepeatTimes, charRepeatFrequencyMap.get(rightChar));
            if (winEnd - winStart + 1 - maxRepeatTimes > k) {
                char leftChar = str.charAt(winStart);
                charRepeatFrequencyMap.put(leftChar, charRepeatFrequencyMap.get(leftChar)-1);
                winStart++;
            }
            maxLength = Math.max(maxLength, winEnd-winStart+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findLength2("aabccbb", 2));
        System.out.println(findLength2("abbcb", 1));
        System.out.println(findLength2("abccde", 1));
    }
}
