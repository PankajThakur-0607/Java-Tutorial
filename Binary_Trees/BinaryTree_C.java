package Binary_Trees;

import java.util.*;

import ARRAYS.reverseArray;
import Classes.encapsulation;

public class BinaryTree_C {
    
    static class Node {
      int data;
      Node left;
      Node right ;

       public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
       }
        
    }
    public static void kLevel(Node root , int level , int k){

        if (root == null) {
            return ;
        }

        if (level == k) {
            System.out.print(root.data + " ");
        }

        kLevel(root.left, level+1, k);
        kLevel(root.right, level+1, k);

       

    }

              
    public static void kLevel2 (Node root , int k){

        Queue <Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);
        int level = 1;

        while (!q.isEmpty()) {
             Node currNode = q.remove();
             if (currNode == null) {
                System.out.println();
                 level++;
                if (q.isEmpty()) {
                    break;
                } else{
                q.add(null);
             }

             } else if (level == k) {
                System.out.print(currNode.data + " ");
             }
             
             
             else{
                if (currNode.left != null) {
                     q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }


               
             }
        }
    }

    public static boolean getpath(Node root , int n , ArrayList<Node> path){
            if(root == null){
                return false;
            }
        path.add(root);

        if (root.data == n ) {
             return true;
        }

        boolean foundLeft = getpath(root.left, n, path);
        boolean foundRight = getpath(root.right, n, path);

         if (foundLeft || foundRight) {
            return true;
         }

         path.remove(path.size()-1);
         return false;
    }
    public static Node lca(Node root , int n1 , int n2 ){  // O(n)

        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        // traverse

        getpath(root , n1 , path1 );
        getpath(root , n2 , path2);


        // loop
        int i =0 ;
        for(; i < path1.size() && i < path2.size() ; i++){
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        Node lca = path1.get(i-1);

        return lca;
    }


    public static Node lca2 (Node root , int n1 , int n2){
        
        if (root == null || root.data == n1 || root.data == n2) {
             return root;
        }

        Node leftlca = lca2(root.left, n1, n2);   // koi value || null milega
        Node rightlca = lca2(root.right, n1, n2); // koi value || null milega

        // leftLCA = val   && rightLca = null
        if (leftlca == null) {
             return rightlca;
        }
        if (rightlca == null) {
            return leftlca;
        }

        return root;

    }


    public static int lcaDist(Node root, int n){
        
        if (root == null) {
            return -1 ;
        }
        if (root.data == n) {
            return 0 ;
        }

       int left = lcaDist(root.left, n);
       int right = lcaDist(root.right, n);

       if (left == -1 && right == -1) {
          return -1 ;
       } else if (left == -1) {
         return right +1;
       } else {
        return left +1 ;
       }

    }
    public static int minDist(Node root , int n1 , int n2){
        Node lca = lca2(root, n1, n2);

        int dist1 = lcaDist(root , n1);
        int dist2 = lcaDist(root , n2);

        return dist1 + dist2 ;



    }

    public static int kAncestor(Node root , int n , int k){

        if ( root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }

        int left = kAncestor(root.left, n, k);
        int right = kAncestor(root.right, n, k);

        if (left == -1 && right == -1) {
            return -1;
        }
       int max = Math.max(left , right);
        if (max +1 == k) {
            System.out.println(root.data );
        }

        return  max + 1 ;

    }


    public static int sumTree(Node root){

        if (root == null) {
            return 0;
        }

        int leftChild = sumTree(root.left);
        int rightChild = sumTree(root.right);
        int data = root.data;

        int newleft =root.left ==null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        root.data = newRight + rightChild + newleft + leftChild;
        
       

        return data;
    }

    public static void preorder(Node root){

        if (root == null) {
            return ;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    static HashMap<String , Integer> map = new HashMap<>();
   public static String duplicateSubtree(Node root){
        if (root == null) {
             return "#";
        }

        String str = "(";
        str+= duplicateSubtree(root.left);
        str +=Integer.toString((root.data)) ;
        str+= duplicateSubtree(root.right);
        str+= ")";

        if (map.get(str) != null && map.get(str) ==1 ) {
             System.out.print(root.data + " ");
        }
        if (map.containsKey(str)) {
            map.put(str, map.get(str) +1 );
        } else{
            map.put(str, 1);
        }

        return str;
   }

   public static int val;
   public static int maxSumHelper(Node root){
     
    if (root == null) {
         return 0 ;
    }

    int leftSum  = maxSumHelper(root.left) ;
    int rightSum = maxSumHelper(root.right);

    int maxSingle = Math.max(Math.max( leftSum, rightSum) + root.data , root.data);
    // System.out.println(maxSingle);-
    int maxTop = Math.max(leftSum + rightSum + root.data, maxSingle);

    // System.out.println(maxTop);

    val =  Math.max(val, maxTop);

   return maxSingle;
   }

   public static int maxPathSum(Node root){
    val = Integer.MIN_VALUE;
    maxSumHelper(root);
    return val; 
   }



    
    public static void main(String[] args) {
        

          /*
         *          1
         *         / \
         *       2     3
         *     / \   / \
         *    4     6   7
         * 
         * 
         *  expected value
         *           27
         *         /   \ 
         *       9       13
         *     /   \    /  \
         *    0    0   0   0
          */


        //  Node root = new Node(1);
        //  root.left = new Node(4);
        //  root.right = new Node(3);
        //  root.left.left = new Node(3);
        // //  root.left.right = new Node( );
        //  root.right.left = new Node(4);
        //  root.right.right = new Node(3);
        //  root.right.left.left = new Node(3);

        //  duplicateSubtree(root);

        //  int k = 3;
        //  kLevel(root, 1, k);
    //    kLevel2(root, k);

    // int n1 = 4 , n2 = 6;
    // // System.out.println(lca2(root, n1, n2).data);
    // System.out.println(minDist(root, n1, n2));


    // int n =  , k = 1; 
    // kAncestor(root, n, k);

    // sumTree(root);
    // preorder(root);

         Node root = new Node(10);
         root.left = new Node(8);
         root.right = new Node(20);
        //  root.left.left = new Node(3);
        //  root.left.right = new Node( );
         root.right.left = new Node(- );
         root.right.right = new Node(7);
        //  root.right.left.left = new Node(3);

      System.out.println( maxPathSum(root));

    



    }
}
