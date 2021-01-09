package bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZRH
 * @date 2020/12/29 17:56
 */
public class UniqueTrees {
    public static List<TreeNode> findUniqueTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            List<TreeNode> left = findUniqueTrees(1, i - 1);
            List<TreeNode> right = findUniqueTrees(i + 1, n);
            for (TreeNode leftRoot : left) {
                for (TreeNode rightRoot : right) {
                    TreeNode root = new TreeNode(i, leftRoot, rightRoot);
                    result.add(root);
                }
            }
        }
        return result;
    }

    private static List<TreeNode> findUniqueTrees(int leftIndex, int rightIndex) {
        List<TreeNode> result = new ArrayList<>();
        for (int i = leftIndex; i <= rightIndex; i++) {
            List<TreeNode> left = findUniqueTrees(leftIndex, i - 1);
            List<TreeNode> right = findUniqueTrees(i + 1, rightIndex);
            for (TreeNode leftRoot : left) {
                for (TreeNode rightRoot : right) {
                    TreeNode root = new TreeNode(i, leftRoot, rightRoot);
                    result.add(root);
                }
            }
        }
        if (result.size() == 0) {
            result.add(null);
        }
        return result;
    }

    public static void main(String[] args) {
        boolean a = false;
        boolean b = !a;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
