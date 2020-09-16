package twopointers;

public class BackspaceCompare {
    public static final char BACKSPACE = '#';

    public static boolean compare(String str1, String str2) {
        int index1 = str1.length() - 1, index2 = str2.length() - 1;
        while (index1 >= 0 && index2 >= 0) {
            Character character1 = null, character2 = null;
            int backtimes1 = 0, backtimes2 = 0;
            while (index1 >= 0) {
                char temp = str1.charAt(index1);
                if (temp == BACKSPACE) {
                    backtimes1++;
                    index1--;
                } else {
                    if (backtimes1 == 0) {
                        character1 = temp;
                        index1--;
                        break;
                    } else {
                        index1--;
                        backtimes1--;
                    }
                }
            }
            while (index2 >= 0) {
                char temp = str2.charAt(index2);
                if (temp == BACKSPACE) {
                    backtimes2++;
                    index2--;
                } else {
                    if (backtimes2 == 0) {
                        character2 = temp;
                        index2--;
                        break;
                    } else {
                        index2--;
                        backtimes2--;
                    }
                }
            }
            if (character1 == null || character2 == null) {
                return false;
            }
            if (!character1.equals(character2)) {
                return false;
            }
        }
        if (index1 == -1 && index2 == -1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(compare("xy#z","xzz#"));
        System.out.println(compare("xy#z","xyz#"));
        System.out.println(compare("xp#","xyz##"));
        System.out.println(compare("xywrrmp","xywrrmu#p"));
    }
}
