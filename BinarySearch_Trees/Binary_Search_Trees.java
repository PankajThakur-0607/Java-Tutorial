package BinarySearch_Trees;

public class Binary_Search_Trees {
    
    public static class TreeNode {
    
        int val;
        TreeNode left ;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }


    public static TreeNode buildTree(int values[] , TreeNode root){
        for (int value : values) {
            root = insertIntoBST(root , value);
        }
        return root;
    }

    public static TreeNode insertIntoBST(TreeNode root , int value){
        if (root == null) {
            return new TreeNode(value);
        }

        if (value > root.val) {
            root.right = insertIntoBST(root.right, value);
        }else{
            root.left = insertIntoBST(root.left, value);
        }

        return root;
    }


    public static void inOrder(TreeNode root){
        if (root == null) {
            return;
        }
        
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    public static void main(String[] args) {
        
        int values[] = {5,1,3,4,2,7};
        TreeNode root = buildTree(values, null);
        inOrder(root);
        
    }
}
