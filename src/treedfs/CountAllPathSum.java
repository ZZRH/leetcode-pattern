package treedfs;

import java.util.LinkedList;

public class CountAllPathSum {
    public static int countPaths(TreeNode root, int S) {
        if (root == null) {
            return 0;
        }
        return countPaths(root, S, new LinkedList<Integer>());
    }

    public static int countPaths(TreeNode root, int S, LinkedList<Integer> path) {
        if (root == null) {
            return 0;
        }
        path.add(root.val);
        int sum = 0;
        int numberOfPaths = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == S) {
                numberOfPaths++;
            }
        }
        numberOfPaths += countPaths(root.left, S, path) + countPaths(root.right, S, path);
        path.pollLast();
        return numberOfPaths;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode("12,7,1,4,null,10,5");
        System.out.println(countPaths(root, 29));
    }
}
