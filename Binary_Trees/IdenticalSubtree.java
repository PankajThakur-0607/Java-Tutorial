package Binary_Trees;

public class IdenticalSubtree {

    static class ListNode {
        int val;
        ListNode left;
        ListNode right;

        public ListNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }

    }

    public static boolean isSubtree(ListNode root, ListNode subRoot) {

        if (root == null) {
            return false;
        }
        if (root.val == subRoot.val) {
            return isIdentical(root, subRoot);
        }

        return isSubtree(root.left, subRoot) ||
                isSubtree(root.right, subRoot);
    }

    public static boolean isIdentical(ListNode node, ListNode subroot) {

        if (node == null && subroot == null) {
            return true;
        } else if (node == null || subroot == null || subroot.val != node.val) {
            return false;
        }

        if (!isIdentical(node.left, subroot.left)) {
            return false;
        }

        if (!isIdentical(node.right, subroot.right)) {
            return false;
        }

        return true;
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

        // topView(root);

        /*
         * 2
         * / \
         * 4 5
         * 
         */

        ListNode subRoot = new ListNode(2);
        subRoot.left = new ListNode(4);
        subRoot.right = new ListNode(5);

        System.out.println(isSubtree(root, subRoot));
    }
}
