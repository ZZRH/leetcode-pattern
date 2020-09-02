package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    public static void main(String[] args) {
        /*String s = "a\\.";
        System.out.println(s);*/

        String matchText = null;
//        String matchText = "(T|t)he(?=\\sfat)";
        matchText = "(T|t)he(?<=\\sfat)";
        String expression = "The fat cat sat on the mat.";
        Pattern pattern = Pattern.compile(matchText);
        Matcher matcher = pattern.matcher(expression);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "--");
            System.out.println(matcher.group());
        }
        matcher.appendTail(stringBuffer);
        System.out.println(stringBuffer.toString());
    }
}
