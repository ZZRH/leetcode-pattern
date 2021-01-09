package bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZRH
 * @date 2020/12/25 19:39
 */
public class GeneralizedAbbreviation {
    public static List<String> generateGeneralizedAbbreviation(String word) {
        List<String> result = new ArrayList<>();
        if (word.length() == 0) {
            result.add("");
        }
        down(result, word, new StringBuilder(), 0, 0);
        return result;
    }

    private static void down(List<String> result, String word, StringBuilder currentWord, int currentIndex, int currentCount) {
        if (currentIndex == word.length()) {
            if (currentCount != 0) {
                currentWord.append(currentCount);
            }
            result.add(currentWord.toString());
        } else {
            // 缩写下一个字符
            StringBuilder word1 = new StringBuilder(currentWord);
            down(result, word, word1, currentIndex + 1, currentCount + 1);
            // 不缩写
            StringBuilder word2 = new StringBuilder(currentWord);
            if (currentCount != 0) {
                word2.append(currentCount);
            }
            word2.append(word.charAt(currentIndex));
            down(result, word, word2, currentIndex + 1, 0);
        }
    }

    public static void main(String[] args) {
        List<String> result = generateGeneralizedAbbreviation("BAT");
        System.out.println(result);

        result = generateGeneralizedAbbreviation("code");
        System.out.println(result);
    }
}
