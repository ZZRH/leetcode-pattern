package treebfs;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {
    public static TreeNode findSuccessor(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
            if (currentNode.val == key) {
                return queue.poll();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode("12,7,1,9,null,10,5,null,null,null,null,20,17");
        TreeNode successor = findSuccessor(root, 17);
        if (successor == null) {
            System.out.println("null");
        } else {
            System.out.println(successor.val);
        }
    }
}
