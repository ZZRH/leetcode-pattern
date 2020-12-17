package treebfs;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectLevelOrderSiblings {
    public static void connect(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            while (levelSize-- > 0) {
                TreeNode currentNode = queue.poll();
                if (levelSize == 0) {
                    currentNode.next = null;
                } else {
                    currentNode.next = queue.peek();
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode("12,7,1,9,null,10,5,null,null,null,null,20,17");
        connect(root);
        root.printLevelOrder();
    }
}
