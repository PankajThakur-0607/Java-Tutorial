package Binary_Trees;

import java.util.List;

public class MinDistBetween2Nodes {

    static class ListNode {
        int val;
        ListNode left, right;

        ListNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static ListNode lca(ListNode root, int n1, int n2) {

        if (root == null || root.val == n1 || root.val == n2) {
            return root;
        }

        ListNode left = lca(root.left, n1, n2);
        ListNode right = lca(root.right, n1, n2);

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        return root;

    }

    public static int getDist(ListNode root, int n) {
        if (root == null) {
            return -1;
        }

        if (root.val == n) {
            return 0;
        }

        int left = getDist(root.left, n);
        int right = getDist(root.right, n);

        
        if (left != -1) {
            return left + 1;
        } 

        if(right != -1) {
            return right + 1;
        }

        return -1 ; // TargetNot found
    }

     // O(3N) && O(3H)
    public static int minDist(ListNode root, int n1, int n2) {
        ListNode lca = lca(root, n1, n2); // O(N)
        int dist1 = getDist(lca, n1);  //  O(N)
        int dist2 = getDist(lca, n2);  // O(N)

        return dist1 + dist2;
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

        System.out.println(minDist(root, 4, 6));

    }
}
