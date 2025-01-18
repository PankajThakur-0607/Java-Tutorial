package BinarySearch_Trees;

import java.util.*;

public class Root_To_LeafPath {
    

    static class TreeNode{
        int val ;
        TreeNode left ;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static TreeNode buildTree(TreeNode root , int values[]){
        for(int value : values){
            root = buildTreeNode(root , value);
        }

        return root;
    }
    public static TreeNode buildTreeNode(TreeNode root , int val){
        
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = buildTreeNode(root.left, val);
        }else{
            root.right = buildTreeNode(root.right , val);
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

    // O(H) && O(N) + O(H)
    public static void findPath(TreeNode root , List<List<Integer>> ans , List<Integer> currPath){
        if (root == null) {
            return;
        }

        currPath.add(root.val);
        if (root.left == null && root.right == null) {
            ans.add(new ArrayList<>(currPath));
        }

        findPath(root.left, ans, currPath);
        findPath(root.right, ans, currPath);

        currPath.remove(currPath.size()-1);
    }


    public static List<List<Integer>> rootToLeafPath(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();

       findPath(root , ans , new ArrayList<>());
       return ans;
    }
    
    public static void main(String[] args) {
    
        int values[] = {8,5,3,1,4,6,10,11,14};
        TreeNode root = buildTree(null, values);
        System.out.print("Inorder Traversal : ");
        inOrder(root);

        System.out.println();

        List<List<Integer>> ans = rootToLeafPath(root);

        for(List<Integer> li : ans){
            System.out.println(li);
        }

    }

}
