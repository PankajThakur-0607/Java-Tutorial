package Binary_Trees;

import java.util.ArrayList;
import java.util.Stack;

public class OneTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }

    }

    static class Pair {
        TreeNode node;
        int freq;

        public Pair(TreeNode node, int freq) {
            this.node = node;
            this.freq = freq;
        }

    }

    public static void oneTravel(TreeNode root) {
        ArrayList<Integer> preOrder = new ArrayList<>();
        ArrayList<Integer> inOrder = new ArrayList<>();
        ArrayList<Integer> postOrder = new ArrayList<>();

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));
        while (!st.isEmpty()) {
            Pair curr = st.pop();
            if (curr.freq == 1) {
                preOrder.add(curr.node.val);
                curr.freq++;
                st.push(curr);
                if (curr.node.left != null) {
                    st.push(new Pair(curr.node.left, 1));
                }
            } else if (curr.freq == 2) {

                inOrder.add(curr.node.val);
                curr.freq++;
                st.push(curr);
                if (curr.node.right != null) {
                    st.push(new Pair(curr.node.right, 1));
                }
            } else {
                postOrder.add(curr.node.val);
            }
        }

        System.out.println("PreOrder");
        for (int i = 0; i < preOrder.size(); i++) {
            System.out.print(preOrder.get(i) + " ");
        }

        System.out.println();
        System.out.println("Inorder");

        for (int i = 0; i < inOrder.size(); i++) {
            System.out.print(inOrder.get(i) + " ");
        }
        System.out.println();
        System.out.println("PostOrder");
        for (int i = 0; i < postOrder.size(); i++) {
            System.out.print(postOrder.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        oneTravel(root);
    }
}
