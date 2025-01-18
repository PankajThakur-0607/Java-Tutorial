package BinarySearch_Trees;

import java.util.*;

public class Two_Sum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void getInorder(TreeNode root, ArrayList<Integer> nodes) {
        if (root == null) {
            return;
        }

        getInorder(root.left, nodes);
        nodes.add(root.val);
        getInorder(root.right, nodes);
    }

    public static boolean twoSum_V1(TreeNode root, int k) {

        ArrayList<Integer> nodes = new ArrayList<>();
        getInorder(root, nodes);

        int lp = 0, rp = nodes.size() - 1;

        while (lp < rp) {
            if (nodes.get(lp) + nodes.get(rp) == k) {
                return true;
            } else if (nodes.get(lp) + nodes.get(rp) < k) {
                lp++;
            } else {
                rp--;
            }
        }

        return false;
    }

    public static boolean helper(TreeNode root, int k, HashSet<Integer> set) {
        if (root == null) {
            return false;
        }

        if (set.contains(k - root.val)) {
            return true;
        }

        set.add(root.val);

        return helper(root.left, k, set) || helper(root.right, k, set);

    }

    public static boolean twoSum_V2(TreeNode root, int k) {
        return helper(root, k, new HashSet<>());
    }

    static class BSTIterator {

        Stack<TreeNode> st = new Stack<>();
        boolean reverse = true;

        BSTIterator(TreeNode root, boolean reverse) {
            this.reverse = reverse;
            pushAll(root);

        }

        public int next() {
            TreeNode tempNode = st.pop();
            if (reverse) {
                pushAll(tempNode.left);
            } else {
                pushAll(tempNode.right);
            }
            return tempNode.val;
        }

        public boolean hasNext() {
            return !st.isEmpty();
        }

        private void pushAll(TreeNode node) {
            while (node != null) {
                st.push(node);
                if (reverse) {
                    node = node.right;
                } else {
                    node = node.left;
                }
            }
        }

    }

    public static boolean twoSum_V3(TreeNode root, int k) {
        BSTIterator next = new BSTIterator(root, false);
        BSTIterator before = new BSTIterator(root, true);
        int i = next.next(), j = before.next();
        while (i < j) {
            if (i + j == k) {
                return true;
            } else if (i + j < k) {
                i = next.next();
            } else {
                j = before.next();
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        int k = 28;
        System.out.println(twoSum_V1(root, k));
        System.out.println(twoSum_V2(root, k));
        System.out.println(twoSum_V3(root, k));

    }
}
