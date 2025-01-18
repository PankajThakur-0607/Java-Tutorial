package Binary_Trees;

import java.util.List;

public class kthAncestor {

    static class ListNode {
        int value;
        ListNode left, right;

        ListNode(int value) {
            this.value = value;
            left = right = null;
        }
    }

    public static int kthAncestorsDist(ListNode root, int k, int n) {

        if (root == null) {
            return -1;
        }

        if (root.value == n) {
            return 0;
        }

        int left = kthAncestorsDist(root.left, k, n);
        int right = kthAncestorsDist(root.right, k, n);

        if (left == -1 && right == -1) {
            return -1;
        }

        int max = Math.max(left, right);
        if (max + 1 == k) {
            System.out.println(root.value);
        }
        return max + 1;
    }

    public static void main(String[] args) {
        /*
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         */

        ListNode root = new ListNode(1);
        root.left = new ListNode(2);
        root.right = new ListNode(3);
        root.left.left = new ListNode(4);
        root.left.right = new ListNode(5);
        root.right.left = new ListNode(6);
        root.right.right = new ListNode(7);
        root.right.right.left = new ListNode(8);

        System.out.println(kthAncestorsDist(root, 2, 8));
    }
}
