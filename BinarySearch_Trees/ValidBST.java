package BinarySearch_Trees;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class ValidBST {

    // Function to insert a new node in the BST
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    // Function to build a binary search tree from an array
    public static TreeNode buildTree(int[] values) {
        TreeNode root = null;
        for (int value : values) {
            root = insert(root, value);
        }
        return root;
    }


    // O(N)
    public static void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }
    
    // O(H) && O(H)
    public static boolean isValidBST_V1(TreeNode root, TreeNode min, TreeNode max) {

        if (root == null) {
            return true;
        }

        if (min != null && root.val < min.val) {
            return false;
        }
        if (max != null && root.val > max.val) {
            return false;
        }

        return isValidBST_V1(root.left, min, root) && isValidBST_V1(root.right, root, max);
    }

    // O(H) && O(H)
    public static boolean isValidBST_V2(TreeNode root, long min, long max) {

        if (root == null) {
            return true;
        }

        if (root.val < min) {
            return false;
        }
        if (root.val > max) {
            return false;
        }

        return isValidBST_V2(root.left, min, root.val) && isValidBST_V2(root.right, root.val, max);
    }

    public static void main(String[] args) {
        int[] values = { 2,1,3};
        TreeNode root = buildTree(values);

        // Test the inorderTraversal method
        System.out.print("Inorder Traversal: ");
        inorderTraversal(root);
        System.out.println();

        // TreeNode root = new TreeNode(3);
        // root.left = new TreeNode(2);
        // root.right = new TreeNode(5);
        // root.left.left = new TreeNode(1);
        // root.left.right = new TreeNode(4);
// 
        System.out.println(isValidBST_V1(root, null, null));

        System.out.println(isValidBST_V2(root, Long.MIN_VALUE, Long.MAX_VALUE));

    }
}
