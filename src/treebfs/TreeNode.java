package treebfs;

import java.util.Scanner;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;

    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode getTreeNode(String s) {
        return getTreeNode(s.split(","));
    }

    public static TreeNode getTreeNode(String[] nodes) {
        return getTreeNode(nodes, 0);
    }

    private static TreeNode getTreeNode(String[] nodes, int index) {
        if (nodes == null || nodes.length <= 0 || index >= nodes.length || index < 0) {
            return null;
        }
        String value = nodes[index];
        if (value == null || value.isEmpty() || !value.matches("^[-]?[\\d]+$")) {
            return null;
        }
        Integer val = Integer.valueOf(value);
        TreeNode result = new TreeNode(val);
//        System.out.println(result.val);
        result.left = getTreeNode(nodes, 2*index+1);
        result.right = getTreeNode(nodes, 2*index+2);
        return result;
    }

    void printLevelOrder() {
        TreeNode nextLevelRoot = this;
        while (nextLevelRoot != null) {
            TreeNode current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null) {
                        nextLevelRoot = current.left;
                    } else if (current.right != null) {
                        nextLevelRoot = current.right;
                    }
                }
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        /*String value = "-789";
        boolean matches = value.matches("^[-]?[\\d]+$");
        System.out.println(matches);*/

        /*String value = null;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            value = scanner.nextLine();
            if (value.equals("exit")) {
                break;
            }
            boolean matches = value.matches("^[-]?[\\d]+$");
            System.out.println("result: " + matches);
        }*/

        TreeNode root = getTreeNode("3,9,20,null,null,15,7");
        PrintTree.print(root);
    }
}
