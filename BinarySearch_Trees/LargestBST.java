package BinarySearch_Trees;

public class LargestBST {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    static class Info {
        
        int size;
        int min;
        int max;
        boolean isBST;

        Info(int size , int min , int max , boolean isBST){
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

    static int maxBST = 0;
    public static Info largestBST_V1(TreeNode root){
        if (root == null) {
            return new Info(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        Info left = largestBST_V1(root.left);
        Info right = largestBST_V1(root.right);
        int size = left.size + right.size + 1;
        int min = Math.min(root.val, Math.min(left.min, right.min));
        int max = Math.max(root.val, Math.max(left.max, right.max));
        if (left.isBST && right.isBST && root.val > left.max &&  root.val <  right.min ) {
            maxBST = Math.max(maxBST, size);
            return new Info(size, min, max, true);
        }
        
        // if (left.isBST && right.isBST) {
        //     return new Info(size, min, max, false);
        // }

        return new Info(size, min, max, false);

    }

    public static Info findLargestBST(TreeNode root){
        if (root == null) {
            return new Info(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        Info left = findLargestBST(root.left);
        Info right = findLargestBST(root.right);
        int size = left.size + right.size + 1;
        int min = Math.min(root.val, Math.min(left.min, right.min));
        int max = Math.max(root.val, Math.max(left.max, right.max));

        if (left.isBST && right.isBST && root.val > left.max && root.val < right.min) {
            return new Info(size, min, max, true);
        }

        return new Info(Math.max(left.size, right.size), 0, 0, false);
    }

    public static int largestBST_V2(TreeNode root){
        return findLargestBST(root).size;
    }

    public static void main(String[] args) {
        // Create root node
        TreeNode root = new TreeNode(10);
        
        // Create left subtree
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        
        // Create right subtree
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(17); 
        // This makes the right subtree invalid BST
        

        // The tree now looks like this:
        //       10
        //      /  \
        //     5    15
        //    / \     \
        //   1   8     7
        
        


        // TreeNode root = new TreeNode(50);
        // root.left = new TreeNode(30);
        // root.left.left = new TreeNode(5);
        // root.left.right = new TreeNode(20);

        // root.right = new TreeNode(60);
        // root.right.left = new TreeNode(45);
        // root.right.right = new TreeNode(70);
        // root.right.right.left = new TreeNode(65);
        // root.right.right.right = new TreeNode(80);

        Info ans = largestBST_V1(root);
        System.out.println(maxBST);

        System.out.println(largestBST_V2(root));
    }

}
