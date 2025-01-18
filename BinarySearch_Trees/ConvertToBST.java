package BinarySearch_Trees;

import java.util.ArrayList;

public class ConvertToBST {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    // O(N) && O(H)
    public static void inOrder(TreeNode root, ArrayList<Integer> nodes) {
        if (root == null) {
            return;
        }

        inOrder(root.left, nodes);
        nodes.add(root.val);
        inOrder(root.right, nodes);

    }

    // O(N) && O(H)
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    // O(N) && O(H) + O(N);
    public static TreeNode createBST(ArrayList<Integer> node, int start, int end) {

        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(node.get(mid));
        root.left = createBST(node, start, mid - 1);
        root.right = createBST(node, mid + 1, end);

        return root;

    }

    public static TreeNode balancedBST(TreeNode root) {
        ArrayList<Integer> nodes = new ArrayList<>();
        inOrder(root, nodes);

        System.out.println(nodes);
        root = createBST(nodes, 0, nodes.size() - 1);

        return root;
    }

    public static void main(String[] args) {
        // Create root node
        TreeNode root = new TreeNode(10);

        // Create left child of root
        root.left = new TreeNode(5);

        // Create right child of root
        root.right = new TreeNode(15);

        // Ensure root's left child does not have a right child
        root.left.left = new TreeNode(3);

        // Ensure root's right child does not have a left child
        root.right.right = new TreeNode(20);

        // Add more nodes to the left subtree
        root.left.left.left = new TreeNode(1);

        // Add more nodes to the right subtree
        root.right.right.right = new TreeNode(25);

        // The tree now looks like this:
        // 10
        // / \
        // 5 15
        // / \
        // 3 20
        // / \
        // 1 25

        TreeNode newRoot = balancedBST(root);
        preOrder(newRoot);

    }
}
