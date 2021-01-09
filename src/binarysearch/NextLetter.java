package binarysearch;

/**
 * @author ZRH
 * @date 2021/1/4 11:14
 */
public class NextLetter {
    public static char searchNextLetter(char[] letters, char key) {
        if (key < letters[0] || key >= letters[letters.length-1]) {
            return letters[0];
        }
        int left = 0, right = letters.length-1;
        while (left <= right) {
            int mid = (left+right) >>> 1;
            if (letters[mid] == key) {
                return letters[mid+1>=letters.length?0:mid+1];
            } else if (letters[mid] > key) {
                right = mid - 1;
            } else {
                left = mid+1;
            }
        }
        return letters[left];
    }

    public static void main(String[] args) {
        System.out.println(searchNextLetter(new char[]{'b', 'd', 'f', 'w'}, 'a'));
        System.out.println(searchNextLetter(new char[]{'b', 'd', 'f', 'w'}, 'b'));
        System.out.println(searchNextLetter(new char[]{'b', 'd', 'f', 'w'}, 'c'));
        System.out.println(searchNextLetter(new char[]{'b', 'd', 'f', 'w'}, 'd'));
        System.out.println(searchNextLetter(new char[]{'b', 'd', 'f', 'w'}, 'z'));
        System.out.println(searchNextLetter(new char[]{'b', 'd', 'f', 'w'}, 'm'));
    }
}
