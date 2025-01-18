package Binary_Trees;

import java.util.List;

public class DiameterOfATree {

    static class ListNode {

        int val;
        ListNode left;
        ListNode right;

        public ListNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }

    }

    static class Info {
        int height;
        int diameter;

        Info(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static int height(ListNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }


    // O(N) && O(H)
    public static Info diameter(ListNode root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        int diam = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter), leftInfo.height + rightInfo.height + 1);

        return new Info(height, diam);
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

        System.out.println(diameter(root).diameter);
    }
}
