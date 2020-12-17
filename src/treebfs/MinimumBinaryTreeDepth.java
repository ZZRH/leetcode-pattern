package treebfs;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumBinaryTreeDepth {
    public static int findDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int currentLevel = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            currentLevel++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left == null && currentNode.right == null) {
                    return currentLevel;
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return currentLevel;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode("12,7,1,null,null,10,5");
        int depth = findDepth(root);
        System.out.println(depth);
    }

}
