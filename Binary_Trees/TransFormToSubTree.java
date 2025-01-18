package Binary_Trees;

import java.util.LinkedList;
import java.util.Queue;

public class TransFormToSubTree {

    static class ListNode {
        int val;
        ListNode left;
        ListNode right;

        ListNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void levelOrder(ListNode root) {
        Queue<ListNode> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()) {
            ListNode currNode = q.poll();
            System.out.print(currNode.val + " ");

            if (currNode.left != null) {
                q.add(currNode.left);
            }

            if (currNode.right != null) {
                q.add(currNode.right);
            }
        }
    }

    public static int transFormSumTree(ListNode root) {
        if (root == null) {
            return 0;
        }

        int leftChild = transFormSumTree(root.left);
        int rightChild = transFormSumTree(root.right);

        int currData = root.val;
        int newLeft = root.left == null ? 0 : root.left.val;
        int newRight = root.right == null ? 0 : root.right.val;
        root.val = newLeft +newRight + leftChild + rightChild;

        return currData;
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

        levelOrder(root);

        System.out.println(transFormSumTree(root));

        levelOrder(root);

    }
}
