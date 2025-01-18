package BinarySearch_Trees;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class MirrorBST {

    // O(H) && O(H) 
    public static TreeNode mirrorBST(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = mirrorBST(root.left);
        TreeNode right = mirrorBST(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(11);

        System.out.print("Inorder Traversal : ");
        inOrder(root);
        System.out.println();

        System.out.print("Inorder Traversal : ");
        mirrorBST(root);
        inOrder(root);
        System.out.println();

    }
}
