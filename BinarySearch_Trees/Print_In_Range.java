package BinarySearch_Trees;

import BinarySearch_Trees.Binary_Search_Trees.TreeNode;

public class Print_In_Range {

    public static TreeNode buildTree(int values[], TreeNode root) {
        for (int value : values) {
            root = insertIntoBST(root, value);
        }
        return root;
    }

    private static TreeNode insertIntoBST(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }
        if (value < root.val) {
            root.left = insertIntoBST(root.left, value);
        } else {
            root.right = insertIntoBST(root.right, value);
        }
        return root;
    }

    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }


    // O(N) && O(H)
    public static void printInRange(TreeNode root, int k1, int k2) {

        if (root == null) {
            return;
        }
        if (k1 <= root.val && k2 >= root.val) {
            printInRange(root.left, k1, k2);
            System.out.println(root.val);
            printInRange(root.right, k1, k2);
        } else if (k1 > root.val) {
            printInRange(root.right, k1, k2);
        } else if(k2 < root.val) {
            printInRange(root.left, k1, k2);
        }
    }



    public static void main(String[] args) {
        int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        TreeNode root = buildTree(values, null);
        // Test the inorderTraversal method
        System.out.print("Inorder Traversal: ");
        inorderTraversal(root);
        System.out.println();

        printInRange(root, 10, 14);

    }
}





