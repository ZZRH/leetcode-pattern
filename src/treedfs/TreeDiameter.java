package treedfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TreeDiameter {
    static int diameter = 0;
    public static int findDiameter(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        maxDepth(root, map);
//        for (Map.Entry<TreeNode, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey().val + " " + entry.getValue());
//        }
        traverse(root, map);
        return diameter;
    }

    private static void traverse(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return;
        }
        int temp = map.getOrDefault(root.left, 0) + map.getOrDefault(root.right, 0) + 1;
        if (temp > diameter) {
            diameter = temp;
        }
        traverse(root.left, map);
        traverse(root.right, map);
    }

    private static int maxDepth(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int depth = Math.max(maxDepth(root.left, map), maxDepth(root.right, map)) + 1;
        map.put(root, depth);
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode("1,2,3,4,null,5,6");
        System.out.println(findDiameter(root));

        /*LinkedList<Integer> list = new LinkedList<>();
        list.add(null);
        int i = list.getFirst();
        System.out.println(i);*/
    }
}
