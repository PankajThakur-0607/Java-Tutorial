package BinarySearch_Trees;

public class Delete_IN_BST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean searchKey(TreeNode root, int key) {
        if (root == null) {
            return false;
        }

        if (root.val == key) {
            return true;
        }

        if (key < root.val) {
            return searchKey(root.left, key);
        } else {
            return searchKey(root.right, key);
        }
    }

    public static TreeNode buildTree(TreeNode root, int values[]) {

        for (int val : values) {
            root = buildTreeNode(root, val);
        }

        return root;
    }

    public static TreeNode buildTreeNode(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }

        if (val < node.val) {
            node.left = buildTreeNode(node.left, val);
        } else {
            node.right = buildTreeNode(node.right, val);
        }

        return node;
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    // O(3H) && O(H)
    public static TreeNode delete(TreeNode root, int val) {
        if (val < root.val) {
            root.left = delete(root.left, val);
        } else if (val > root.val) {
            root.right = delete(root.right, val);
        } else {

            if (root.left == null && root.right == null) {
                return null;
            }

            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;  
            } 

            TreeNode IS = findInorderSuccessor(root.right);
            root.val = IS.val;
            root.right = delete(root.right, IS.val);
        }

        return root;
    }

    public static TreeNode findInorderSuccessor(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    public static void main(String[] args) {

        int values[] = { 8, 5, 3, 1, 4, 6, 7, 10, 11, 14 };
        TreeNode root = buildTree(null, values);
        inOrder(root);

        root = delete(root, 8);
        System.out.println();
        inOrder(root);

        // // Creating the tree nodes manually
        // TreeNode root = new TreeNode(5);
        // root.left = new TreeNode(1);
        // root.left.right = new TreeNode(3);
        // root.left.right.left = new TreeNode(2);
        // root.left.right.right = new TreeNode(4);
        // root.right = new TreeNode(7);

        // System.out.println(searchKey(root, 5));
        // // You can add a method to print or traverse the tree and call it here
        // // For example: printInOrder(root);
    }
}
