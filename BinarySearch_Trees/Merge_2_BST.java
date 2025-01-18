package BinarySearch_Trees;

import java.util.ArrayList;

public class Merge_2_BST {
    // TreeNode class definition
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int item) {
            val = item;
            left = right = null;
        }
    }

    // Method to create a sample BST
    static TreeNode createBST1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        return root;
    }

    // Method to create another sample BST
    static TreeNode createBST2() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        return root;
    }

    public static void inOrder(TreeNode root, ArrayList<Integer> nodes) {
        if (root == null) {
            return;
        }

        inOrder(root.left, nodes);
        nodes.add(root.val);
        inOrder(root.right, nodes);
    }

    public static ArrayList<Integer> mergeBST(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> nodes1 = new ArrayList<>();
        ArrayList<Integer> nodes2 = new ArrayList<>();
        inOrder(root1, nodes1);
        inOrder(root2, nodes2);

        int i = 0, j = 0;
        ArrayList<Integer> allNodes = new ArrayList<>();
        while (i < nodes1.size() && j < nodes2.size()) {
            if (nodes1.get(i) <= nodes2.get(j)) {
                allNodes.add(nodes1.get(i));
                i++;
            } else {
                allNodes.add(nodes2.get(j));
                j++;
            }
        }

        while (i < nodes1.size()) {
            allNodes.add(nodes1.get(i));
            i++;
        }

        while (j < nodes2.size()) {
            allNodes.add(nodes2.get(j));
            j++;
        }

        return allNodes;
    }

    public static TreeNode createBST(ArrayList<Integer> nodes , int start , int end){
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2 ;
        TreeNode root = new TreeNode(nodes.get(mid));
        root.left = createBST(nodes, start, mid-1);
        root.right = createBST(nodes, mid + 1, end);

        return root;
    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        // Create two BSTs
        TreeNode bst1 = createBST1();
        TreeNode bst2 = createBST2();

        ArrayList<Integer> allNodes = mergeBST(bst1, bst2);
        System.out.println(allNodes);
        TreeNode root = createBST(allNodes, 0, allNodes.size()-1);

        preOrder(root);
        

    }
}
