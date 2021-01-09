package bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZRH
 * @date 2020/12/25 15:47
 */
public class LetterCaseStringPermutation {
    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        permutations.add(str);
        for (int i = 0; i < str.length(); i++) {
            char lowCase = str.charAt(i);
            if (!Character.isLetter(lowCase)) {
                continue;
            }
            char upperCase = Character.toUpperCase(lowCase);
            int n = permutations.size();
            for (int k = 0; k < n; k++) {
                StringBuilder newStringBuilder = new StringBuilder(permutations.get(k));
                newStringBuilder.setCharAt(i, upperCase);
                permutations.add(newStringBuilder.toString());
            }
        }
        return permutations;
    }

    public static void main(String[] args) {
        List<String> result = findLetterCaseStringPermutations("ad52");
        System.out.println(result);
    }
}
