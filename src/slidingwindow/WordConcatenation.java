package slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordConcatenation {
    /**
     * Given a string and a list of words,
     * find all the starting indices of substrings in the given string
     * that are a concatenation of all the given words exactly once without any overlapping of words.
     * It is given that all words are of the same length.
     *
     * @param str
     * @param words
     * @return
     */
    public static List<Integer> findWordConcatenation(String str, String[] words) {
        List<Integer> resultIndices = new ArrayList<>();
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : words) {
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }
        int wordCount = words.length, wordLength = words[0].length();
        for (int winStart = 0; winStart <= str.length() - wordCount * wordLength; winStart++) {
            Map<String, Integer> exitingWordFrequencyMap = new HashMap<>();
            boolean tempSucceed = true;
            for (int k = 0; k < wordCount; k++) {
                int wordStartIndex = winStart + wordLength * k;
                String currentWord = str.substring(wordStartIndex, wordStartIndex + wordLength);
                if (wordFrequencyMap.containsKey(currentWord)) {
                    exitingWordFrequencyMap.put(currentWord, exitingWordFrequencyMap.getOrDefault(currentWord, 0) + 1);
                } else {
                    tempSucceed = false;
                    break;
                }
                if (exitingWordFrequencyMap.get(currentWord) > wordFrequencyMap.get(currentWord)) {
                    tempSucceed = false;
                    break;
                }
            }
            if (tempSucceed) {
                resultIndices.add(winStart);
            }
        }
        return resultIndices;
    }

    public static void main(String[] args) {
        System.out.println(findWordConcatenation("catfoxcat", new String[]{"cat", "fox"}));
        System.out.println(findWordConcatenation("catcatfoxfox", new String[]{"cat", "fox"}));
    }
}
