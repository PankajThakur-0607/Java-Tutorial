package Binary_Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BuildTree {

    static class ListNode {
        int val;
        ListNode left;
        ListNode right;

        public ListNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }

    }

    static class BinaryTree {
        static int idx = -1;

        // O(N)
        public static ListNode buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            ListNode node = new ListNode(nodes[idx]);
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);

            return node;
        }

        // O(N) && O(H)
        public static void preOrder(ListNode root) {
            if (root == null) {
                System.out.print("-1" + " ");
                return;
            }
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(ListNode root) {
            if (root == null) {
                System.out.print("-1" + " ");
                return;
            }

            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }

        public static void postOrder(ListNode root) {
            if (root == null) {
                System.out.print("-1" + " ");
                return;
            }

            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");

        }

        // Level Order Traversal

        // O(N) && O(N)
        public static void levelOrder(ListNode root) {
            if (root == null) {
                return;
            }

            Queue<ListNode> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                ListNode currNode = q.poll();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.val + " ");
                    if (currNode.left != null) {
                        q.offer(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.offer(currNode.right);
                    }
                }
            }
        }
    }


    // O(N) && O(H)
    public static int height(ListNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }


    // O(N) && O(H)
    public static int countNodes(ListNode root) {
        if (root == null) {
            return 0;
        }

        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        return leftCount + rightCount + 1; 
    }


    // O(N) && O(H)
    public static int sumOfNodes(ListNode root){
        if (root == null) {
            return 0;
        }

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        return leftSum + rightSum + root.val;
    }



    // O(N^2) -- why ?? -> height is calculated for every Recursion call ;
    public static int getDiameter_V1(ListNode root){
        if (root == null) {
            return 0;
        }

        int leftDia = getDiameter_V1(root.left);
        int leftHeight = height(root.left);
        int rightDia = getDiameter_V1(root.right);
        int rightHeight = height(root.right);

        return Math.max(rightDia, Math.max(leftDia, leftHeight + rightHeight + 1));
    }



    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        // ListNode root = tree.buildTree(nodes);

        // System.out.println("preOrdeer");
        // tree.preOrder(root);
        // System.out.println();
        // System.out.println("Inorder ");
        // tree.inOrder(root);
        // System.out.println();
        // System.out.println("PostOrder");
        // tree.postOrder(root);

        // System.out.println();
        // System.out.println("level order Traversal");
        // tree.levelOrder(root);

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

        System.out.println(height(root));
        
        System.out.println(countNodes(root));

        System.out.println(sumOfNodes(root));
        
        System.out.println(getDiameter_V1(root));

        
    }
}
