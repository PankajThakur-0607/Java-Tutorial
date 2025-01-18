package BinarySearch_Trees;

import java.util.Stack;

public class BST_Iterator {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static Stack<TreeNode> st = new Stack<>();

    BST_Iterator(TreeNode root) {
        pushAll(root);
    }

    public int next() {
        TreeNode temp = st.pop();
        pushAll(temp.right);
        return temp.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    private static void pushAll(TreeNode node) {
        for (; node != null;node = node.left)  st.push(node) ;
    } 

    public static void main(String[] args) {
        // Create a sample BST
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        // Initialize BST Iterator
        BST_Iterator iterator = new BST_Iterator(root);

        // Use the iterator to traverse the BST
        System.out.println("BST traversal in sorted order:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
