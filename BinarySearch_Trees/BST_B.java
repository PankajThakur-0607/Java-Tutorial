package BinarySearch_Trees;

import java.util.ArrayList;

import java.util.*;

public class BST_B {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = this.right =null;
        }
    }


    public static void preOrder(Node root){
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node createBST(int arr[], int si, int ei){
        if (si > ei) {
            return null;
        }
        int mid = (si + ei)/2;
       Node root = new Node(arr[mid]);

        root.left = createBST( arr, si, mid-1);
        root.right = createBST(arr, mid +1,  ei);

        return root;
    }

    public static void getInorder(Node root , ArrayList<Integer> inorder){
        if (root == null) {
             return;
        }

        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node createBST(ArrayList<Integer> inorder , int st , int end){
        if (st > end) {
            return null;
        }

      int mid = (st + end)/2 ;
       Node root = new Node(inorder.get(mid));
       root.left = createBST(inorder, st, mid-1);
       root.right = createBST(inorder, mid+1, end);

       return root;
    }

    public static Node balanceBST(Node root){

        // inorder seq 
        ArrayList<Integer> inorder = new ArrayList<>();
            getInorder(root, inorder);
        // sorted inorder -> balanced BST
         root = createBST(inorder, 0, inorder.size()-1);
         return root ;
    }
        static int maxBST = 0;
        static Node maxNode = new Node(0);
        static class Info{
            boolean isBST;
            int min;
            int max;
            int size;

            Info(boolean isBST , int size , int min , int max ){
                this.isBST = isBST;
                this.size = size;
                this.min = min;
                this.max = max;
            }
        }

        public static Info largestBST(Node root , ArrayList <Node> largest){

            if (root == null) {
                return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
            }
            Info leftBST = largestBST(root.left , largest);
            Info rightBST = largestBST(root.right, largest);

            int size = leftBST.size + rightBST.size + 1;
            int min = Math.min(root.data, Math.min(leftBST.min, rightBST.min));
            int max = Math.max(root.data, Math.max(leftBST.max, rightBST.max));

            if (root.data <= leftBST.max || root.data >= rightBST.min) {

                   return new Info(false, size, min, max);
            }

            if (leftBST.isBST && rightBST.isBST) {
                maxBST = Math.max(maxBST, size);
                // maxNode = new Node(root.data);
                //  largest.add(root);
                 return new Info(true, size, min, max);
            }

            return new Info(false, size, min, max);
        }


        public static void getInorder2(Node root ,  ArrayList<Integer> arr){
            if (root == null) {
                return ;
            }
            getInorder2(root.left, arr);
            arr.add(root.data);
            getInorder2(root.right, arr);
        }

        public static Node createBSt2(ArrayList <Integer> arr , int st , int end){
            if (st > end) {
                 return null;
            }

            int mid = (st + end)/2;
            Node root = new Node(arr.get(mid));
            root.left = createBSt2(arr, st, mid-1);
            root.right = createBSt2(arr,mid+1, end);

            return root;
        }

        public static Node merge2BST(Node root1 , Node root2){  //O(n + m)

            // BST1 Inorder sequence krna
            ArrayList<Integer> arr1 = new ArrayList<>();
            getInorder2(root1, arr1);

            // BST2 Inorder sequence krna h
            ArrayList<Integer> arr2 = new ArrayList<>();
            getInorder2(root2, arr2);

            // merge
            ArrayList<Integer> finalarr = new ArrayList<>();
            int i = 0 ,j =0;
            
            while (i < arr1.size() && j < arr2.size()) {
                 if (arr1.get(i) <= arr2.get(j)) {
                    finalarr.add(arr1.get(i));
                    i++;
                 } else{
                    finalarr.add(arr2.get(j));
                    j++;
                 }
            }

            while (i < arr1.size()) {
                 finalarr.add(arr1.get(i));
                    i++;
            }

            while (j < arr2.size()) {
                finalarr.add(arr2.get(j));
                j++;
            }

            // Balanced BST
            return createBSt2(finalarr, 0, finalarr.size()-1);
           
        }


     





    public static void main(String[] args) {
        // int arr[] = {3,5,6,8,10,11,12};
        // Node root =  createBST(arr, 0, arr.length-1);
        
        // preOrder(root);


        /*
         *             8
         *           /   \
         *         6      10
         *        /        \ 
         *       5          11 
         *      /            \
         *     3              12
         * 
         */

        //  Node root = new Node(8);
        //  root.left = new Node(6);
        //  root.left.left = new Node(5);
        //  root.left.left.left = new Node(3);

        //  root.right = new Node(10);
        //  root.right.right = new Node(11);
        //  root.right.right.right = new Node(12);

        // /*
        //  *          8
        //  *         / \
        //  *       5    11
        //  *     / \   / \
        //  *    3  6  10  12
        //  */

        //  root = balanceBST(root);
        //  preOrder(root);




         /*
         *           50
         *         /   \
         *       30      60
         *     / \      / \
         *    5   20   45  70
         *                /   \
         *              65     80
         */



          /*
         *          
         *                60
         *               / \
         *             45   70
         *                /    \
         *              65     80
         * expected OUTPUT ans SIZE = 5;
         */



        Node root = new Node(50);
         root.left = new Node(30);
         root.left.left = new Node(5);
         root.left.right = new Node(20);

         root.right = new Node(60);
         root.right.left = new Node(45);
         root.right.right = new Node(70);
         root.right.right.left = new Node(65);
         root.right.right.right = new Node(80);

         ArrayList <Node> largest = new ArrayList<>(); 

         Info info = largestBST(root, largest);
         System.out.println("Largest maxBSt: " + maxBST);
        //  System.out.println();
        //  System.out.println("MAximum Node is: " + maxNode.data);
         
        //  for(int i =0 ; i< largest.size(); i++){
        //     System.out.print(largest.get(i).data + " ");
        //  }


        // /*
        //  *        2
        //  *      /   \ 
        //  *    1      4
        //  */
        // Node root1 = new Node(2);
        // root1.left = new Node(1);
        // root1.right = new Node(4);


        //  /*
        //  *        9
        //  *      /   \ 
        //  *    3      12
        //  */

        //  Node root2 = new Node(9);
        //   root2.left = new Node(3);
        //   root2.right = new Node(12);


        //   /*
        //    *         3
        //    *      /     \  
        //    *     1         9
        //    *      \      /   \
        //    *      2    4     12
        //    *   final ans: BST 
        //    */

        //     Node root = merge2BST(root1, root2);
        //     preOrder(root);

         

    }
}
