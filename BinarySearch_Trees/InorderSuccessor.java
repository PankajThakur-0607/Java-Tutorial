package BinarySearch_Trees;

import java.util.ArrayList;

public class InorderSuccessor {
    // TreeNode class definition
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int item) {
            val = item;
            left = right = null;
        }
    }

    public static void getInorder(TreeNode root, ArrayList<Integer> values) {
        if (root == null) {
            return;
        }

        getInorder(root.left, values);
        values.add(root.val);
        getInorder(root.right, values);
    }

    // O(N) && O(2N)
    public static int inOrderSuccessor_V1(TreeNode root, TreeNode node) {
        ArrayList<Integer> values = new ArrayList<>();
        getInorder(root, values);
        int ans = -1;
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) > node.val) {
                ans = values.get(i);
                break;
            }
        }

        return ans;
    }

    // O(N) && O(N)
    public static int inOrderSuccessor_V2(TreeNode root, TreeNode node) {
        if (root == null) {
            return -1;
        }

        if (root.val > node.val) {
            int left = inOrderSuccessor_V2(root.left, node);
            return left != -1 ? left : root.val;
        }

        return inOrderSuccessor_V2(root.right, node);
    }

    // O(2N) && O(1)
    public static int inOrderSuccessor_V3(TreeNode root, TreeNode node) {
        TreeNode curr = root;
        TreeNode prev = null;
        int successor = -1;
        while (curr != null) {
            if (curr.left == null) {

                if (prev != null && prev.val == node.val) {
                    successor = curr.val;
                    break;
                }
                prev = curr;
                curr = curr.right;
            } else {
                TreeNode temp = curr.left;
                while (temp.right != null && temp.right != curr) {
                    temp = temp.right;
                }

                if (temp.right == null) {
                    temp.right = curr;
                    curr = curr.left;
                } else {
                    // Visit the Node
                    if (prev != null && prev.val == node.val) {
                        successor = curr.val;
                        break;
                    }
                    prev = curr;
                    temp.right = null;
                    curr = curr.right;
                }
            }
        }
        return successor;
    }

    public static int inOrderSuccessor_V4(TreeNode root, TreeNode node) {

        int successor = -1;
        while (root != null) {

            if (root.val > node.val) {
                successor = root.val;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return successor;
    }

    public static void main(String[] args) {
        // Input: root = [20, 8, 22, 4, 12, N, N, N, N, 10, 14], k = 8
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        System.out.println(inOrderSuccessor_V1(root, new TreeNode(22)));
        System.out.println(inOrderSuccessor_V2(root, new TreeNode(8)));
        System.out.println(inOrderSuccessor_V3(root, new TreeNode(22)));
        System.out.println(inOrderSuccessor_V4(root, new TreeNode(22)));
        // ...existing code...
    }
}
