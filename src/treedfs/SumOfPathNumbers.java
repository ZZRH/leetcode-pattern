package treedfs;

import java.util.LinkedList;
import java.util.List;

public class SumOfPathNumbers {
    public static int findSumOfPathNumbers(TreeNode root) {
        List<String> paths = new LinkedList<>();
        int result = 0;
        addPath(root, paths, new StringBuilder());
        for (String path : paths) {
            Integer v = Integer.valueOf(path);
            result+=v;
        }
        return result;
    }

    private static void addPath(TreeNode root, List<String> paths, StringBuilder currentPath) {
        if (root == null) {
            return;
        }
        currentPath.append(root.val);
        if (root.left == null && root.right == null) {
            paths.add(currentPath.toString());
        }
        addPath(root.left, paths, currentPath);
        addPath(root.right, paths, currentPath);
        currentPath.deleteCharAt(currentPath.length()-1);
    }


    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode("1,0,1,1,null,6,5");
        System.out.println(findSumOfPathNumbers(root));
    }
}
