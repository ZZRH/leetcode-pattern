package treebfs;

import java.util.*;

/**
 * 之字形搜索树
 */
public class ZigzagTraversal {

    @Deprecated
    public static List<List<Integer>> traverse2(TreeNode root) {
        LinkedList<List<Integer>> results = new LinkedList<>();
        if (root == null) {
            return results;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        while (queue.size() > 0) {
            int index = queue.size()-1;
            List<Integer> currentLevelResult = new LinkedList<>();
            while (index >= 0) {
                TreeNode currentNode = queue.remove(index--);
                if (leftToRight) {
                    if (currentNode.right != null) {
                        queue.offer(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        queue.offer(currentNode.left);
                    }
                } else {
                    if (currentNode.left != null) {
                        queue.offer(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.offer(currentNode.right);
                    }
                }
                currentLevelResult.add(0, currentNode.val);
            }
            leftToRight = !leftToRight;
            results.add(currentLevelResult);
        }
        return results;
    }

    public static List<List<Integer>> traverse(TreeNode root) {
        LinkedList<List<Integer>> results = new LinkedList<>();
        if (root == null) {
            return results;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        while (queue.size() > 0) {
            int size = queue.size();
            ArrayList<Integer> currentLevelResult = new ArrayList<>(size);
            while (size-- > 0) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
                if (leftToRight) {
                    currentLevelResult.add(currentNode.val);
                } else {
                    currentLevelResult.add(0, currentNode.val);
                }
            }
            leftToRight = !leftToRight;
            results.add(currentLevelResult);
        }
        return results;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode("12,7,1,9,null,10,5,null,null,null,null,20,17");
//        PrintTree.print(root);
        List<List<Integer>> results = traverse(root);
        for (List<Integer> result : results) {
            String s = Arrays.toString(result.toArray());
            System.out.println(s);
        }
    }
}
