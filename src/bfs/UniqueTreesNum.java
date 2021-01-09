package bfs;

/**
 * @author ZRH
 * @date 2020/12/29 17:44
 */
public class UniqueTreesNum {
    public static int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        int[] result = new int[n+1];
        result[0] = 1;
        for (int i = 1; i <= n; i++) {
            int tempResult = 0;
            for (int k = 1; k <= i; k++) {
                tempResult += result[k-1]*result[i-k];
            }
            result[i] = tempResult;
        }
        return result[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}
