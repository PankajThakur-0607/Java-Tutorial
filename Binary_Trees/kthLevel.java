package Binary_Trees;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class kthLevel {

    static class ListNode {
        int val;
        ListNode left;
        ListNode right;

        ListNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }

    }

    public static void levelOrder(ListNode root) {
        Queue<ListNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        while (!q.isEmpty()) {
            ListNode currNode = q.poll();
            if (currNode == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    System.out.println();
                    q.add(null);
                }
            } else {
                System.out.print(currNode.val + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }

        }
    }

    public static void  kthLevel(ListNode root , int level , int k){
        if (root == null) {
            return;
        }

        if (level == k) {
           System.out.print(root.val + " ");
           return;
        }

        kthLevel(root.left, level+1, k);
        kthLevel(root.right, level+1, k);
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

        // levelOrder(root);

        kthLevel(root, 1, 3);
        

    }
}
