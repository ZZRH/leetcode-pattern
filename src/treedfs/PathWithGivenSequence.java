package treedfs;

public class PathWithGivenSequence {
    public static boolean findPath(TreeNode root, int[] sequence) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }
        return findPath(root, sequence, 0);
    }

    private static boolean findPath(TreeNode root, int[] sequence, int index) {
        if (root == null) {
            if (index == sequence.length) {
                return true;
            } else {
                return false;
            }
        }
        if (root.val != sequence[index]) {
            return false;
        }
        return findPath(root.left, sequence, index + 1) || findPath(root.right, sequence, index + 1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode("1,0,1,1,null,6,5");
        System.out.println(findPath(root, new int[]{1,0,7}));
        System.out.println(findPath(root, new int[]{1,1,6}));
    }
}
