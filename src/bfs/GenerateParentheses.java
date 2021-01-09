package bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZRH
 * @date 2020/12/25 17:10
 */
public class GenerateParentheses {
    public static List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder("(");
        down(result, path, 1, 0, num);
        return result;
    }

    public static void down(List<String> result, StringBuilder path, int leftParenthesisNum, int rightParenthesisNum, int num) {
        if (leftParenthesisNum == num) {
            for (int i = rightParenthesisNum; i < num; i++) {
                path.append(")");
            }
            result.add(path.toString());
            path.delete(leftParenthesisNum + rightParenthesisNum, path.length());
        } else {
            path.append("(");
            down(result, path, leftParenthesisNum + 1, rightParenthesisNum, num);
            path.deleteCharAt(path.length()-1);
            if (leftParenthesisNum > rightParenthesisNum) {
                path.append(")");
                down(result, path, leftParenthesisNum, rightParenthesisNum + 1, num);
                path.deleteCharAt(path.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        List<String> result = generateValidParentheses(3);
        System.out.println(result);
    }
}
