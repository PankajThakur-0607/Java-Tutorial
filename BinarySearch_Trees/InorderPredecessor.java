
package BinarySearch_Trees;

import java.util.ArrayList;

public class InorderPredecessor {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
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

    public static TreeNode predecessor_V1(TreeNode root, int k) {
        ArrayList<Integer> values = new ArrayList<>();
        TreeNode ans = null;
        getInorder(root, values);

        for (int i = values.size() - 1; i >= 0; i--) {
            if (values.get(i) < k) {
                ans = new TreeNode(values.get(i));
                break;
            }
        }

        return ans;
    }

    public static TreeNode predecessor_V2(TreeNode root, int k) {
        if (root == null) {
            return null;
        }

        if (root.val < k) {
            TreeNode right = predecessor_V1(root.right, k);
            return right != null ? right : root;
        }

        return predecessor_V1(root.left, k);
    }

    public static TreeNode predecessor_V3(TreeNode root, int k) {
        TreeNode curr = root;
        TreeNode predecessor = null;
        TreeNode prev = null;
        while (curr != null) {
            if (curr.left == null) {

                // statemtns
                if (curr.val == k) {
                    predecessor = prev;
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
                    temp.right = null;
                    if (curr.val == k) {
                        predecessor = prev;
                        break;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        return predecessor;

    }

    public static TreeNode predecessor_V4(TreeNode root, int k) {
        TreeNode curr = root;
        TreeNode predecessor = null;

        while (curr != null) {

            if (curr.val < k) {
                predecessor = curr;
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return predecessor;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        int k = 10;

        System.out.println(predecessor_V1(root, k).val);
        System.out.println(predecessor_V1(root, k).val);
        System.out.println(predecessor_V3(root, k).val);
        System.out.println(predecessor_V4(root, k).val);

        // ...additional code to find the inorder predecessor...
    }
}
