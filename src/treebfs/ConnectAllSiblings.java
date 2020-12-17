package treebfs;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAllSiblings {
    public static void connect(TreeNode root) {
        if (root == null) {
            return;
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
            currentNode.next = queue.peek();
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode("12,7,1,9,null,10,5,null,null,null,null,20,17");
        connect(root);
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
