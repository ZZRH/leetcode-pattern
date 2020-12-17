package treebfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelAverage {
    public static List<Double> findLevelAverages(TreeNode root) {
        List<Double> results = new LinkedList<>();
        if (root == null) {
            return results;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int currentLevelSum = 0, size = levelSize;
            while (levelSize-- > 0) {
                TreeNode current = queue.poll();
                currentLevelSum+=current.val;
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            results.add(((double)currentLevelSum)/size);
        }
        return results;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode("12,7,1,9,2,10,5");
        List<Double> levelAverages = findLevelAverages(root);
        for (Double result : levelAverages) {
            System.out.println(result);
        }
    }
}
