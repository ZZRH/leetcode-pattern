package treedfs;

public class TreePathSum {
    public static boolean hasPath(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }
        return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode("12,7,1,9,null,10,5");
        System.out.println(hasPath(root, 23));
        System.out.println(hasPath(root, 16));
    }
}
