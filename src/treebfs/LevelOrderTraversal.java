package treebfs;

import java.util.*;

public class LevelOrderTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> results = new LinkedList<>();
        if (root == null) {
            return results;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevelResult = new ArrayList<>(levelSize);
            while (levelSize-- > 0) {
                TreeNode currentNode = queue.poll();
                currentLevelResult.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            results.add(currentLevelResult);
        }
        return results;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode("12,7,1,9,null,10,5,null,null,null,null,20,17");
        List<List<Integer>> results = traverse(root);
        for (List<Integer> result : results) {
            String s = Arrays.toString(result.toArray());
            System.out.println(s);
        }
    }
}
