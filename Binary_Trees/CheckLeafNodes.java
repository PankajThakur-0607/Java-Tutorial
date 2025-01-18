import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CheckLeafNodes {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    public static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    public static void checkLeaf(TreeNode root, ArrayList<TreeNode> ans) {
        if (root == null) {
            return;
        }

        if (isLeaf(root)) {
            ans.add(root);
        }
        checkLeaf(root.left, ans);
        checkLeaf(root.right, ans);
    }


    public static void addLeft(TreeNode root, ArrayList<TreeNode> ans) {

        TreeNode curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) {
                ans.add(curr);
            }

            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

    }

    public static void addLeaves(TreeNode root, ArrayList<TreeNode> ans) {
        if (isLeaf(root)) {
            ans.add(root);
            return;
        }

        if (root.left != null) {
            addLeaves(root.left, ans);
        }
        if (root.right != null) {
            addLeaves(root.right, ans);
        }
    }

    public static void addRight(TreeNode root, ArrayList<TreeNode> ans) {
        TreeNode currNode = root.right;
        Stack<TreeNode> st = new Stack<>();
        while (currNode != null) {
            if (!isLeaf(currNode)) {
                st.push(currNode);
            }

            if (currNode.right != null) {
                currNode = currNode.right;
            } else {
                currNode = currNode.left;
            }
        }

        while (!st.isEmpty()) {
            ans.add(st.pop());
        }
    }

    public static List<TreeNode> printBoundary(TreeNode root) {
        ArrayList<TreeNode> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // If the root is not a leaf,
        // add its value to the result
        if (!isLeaf(root)) {
            res.add(root);
        }

        // Add the left boundary, leaves,
        // and right boundary in order
        addLeft(root, res);
        addLeaves(root, res);
        addRight(root, res);

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<TreeNode> ans = printBoundary(root);
        for (TreeNode node : ans) {
            System.out.println(node.val);
        }
    }

}
