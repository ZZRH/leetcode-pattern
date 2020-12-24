package treedfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindAllTreePaths {
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new LinkedList<>();
        addPaths(root, allPaths, sum, null);
        return allPaths;
    }

    public static void addPaths(TreeNode root, List<List<Integer>> allPaths, int sum, List<Integer> currentPath) {
        if (root == null) {
            return;
        }
        if (currentPath == null) {
            currentPath = new ArrayList<>();
        }
        ArrayList<Integer> tempPath = new ArrayList<>(currentPath);
        tempPath.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            allPaths.add(tempPath);
        }
        addPaths(root.left, allPaths, sum - root.val, tempPath);
        addPaths(root.right, allPaths, sum - root.val, tempPath);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode("12,7,1,4,null,10,5");
        List<List<Integer>> paths = findPaths(root, 23);
        for (List<Integer> path : paths) {
            System.out.println(Arrays.toString(path.toArray()));
        }
    }
}
