package BinarySearch_Trees;

public class Search_IN_BST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    // O(Log N) || O(H) && O(H)
    public static boolean searchKey(TreeNode root, int key) {
        if (root == null) {
            return false;
        }
        if (root.val == key) {
            return true;
        }
        if (key > root.val) {
            return searchKey(root.right, key);
        } else {
            return searchKey(root.left, key);
        }
        // return key < root.val ? searchKey(root.left, key) : searchKey(root.right,
        // key);
    }

    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        // Test the searchKey method
        int key = 11;
        if (searchKey(root, key)) {
            System.out.println("Key " + key + " found in BST.");
        } else {
            System.out.println("Key " + key + " not found in BST.");
        }
    }
}
