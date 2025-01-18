package Binary_Trees;

import java.util.*;

public class ZigZagTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = true;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer>  currLevel = new ArrayList<>(); 
            for (int i = 0; i < size; i++) {

                TreeNode currNode = q.poll();
                    if (flag) {
                        currLevel.add(i , currNode.val);
                    }else{
                        currLevel.add(0 , currNode.val);
                    }

                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }

            }
            
            ans.add(currLevel);

            flag = !flag;
            
        }

        return ans;
    }


    public static void main(String[] args) {


        // Creating the tree nodes
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(5);

        // You can add a method to perform zigzag traversal and call it here
        // For example: tree.zigzagTraversal(root);
        List<List<Integer>> ans = zigzagLevelOrder(root);
        for(List<Integer> num : ans){
            System.out.println(num);
        }



    }
}
