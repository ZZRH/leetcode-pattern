package bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZRH
 * @date 2020/12/29 11:40
 */
public class EvaluateExpression {
    public static Map<String, List<Integer>> valueMap = new HashMap<>();
    public static List<Integer> diffWaysToEvaluateExpression(String input) {
        if (valueMap.containsKey(input)) {
            return valueMap.get(input);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isDigit(currentChar)) {
                //如果是数字，跳过
                continue;
            }
            List<Integer> left = diffWaysToEvaluateExpression(input.substring(0, i));
            List<Integer> right = diffWaysToEvaluateExpression(input.substring(i + 1));
            for (int leftValue : left) {
                for (int rightValue : right) {
                    if (currentChar == '+') {
                        result.add(leftValue + rightValue);
                    } else if (currentChar == '-') {
                        result.add(leftValue - rightValue);
                    } else if (currentChar == '*') {
                        result.add(leftValue * rightValue);
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }
        valueMap.put(input, result);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = diffWaysToEvaluateExpression("1+2*3");
        System.out.println(result);

        result = diffWaysToEvaluateExpression("2*3-4-5");
        System.out.println(result);
    }
}
