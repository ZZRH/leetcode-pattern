package treebfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewTree {
    public static List<TreeNode> traverse(TreeNode root) {
        List<TreeNode> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            while (levelSize-- > 0) {
                TreeNode currentNode = queue.poll();
                if (levelSize == 0) {
                    result.add(currentNode);
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode("12,7,1,9,null,10,5,null,null,null,null,20,17");
        List<TreeNode> result = traverse(root);
        for (TreeNode node : result) {
            System.out.println(node.val);
        }
    }
}
