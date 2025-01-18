package Binary_Trees;


import java.util.*;

public class BinaryTreeB {
   
   
    static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }





    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) { // O(n)
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        
    public static void preorder(Node root){  //O(n)

        if (root == null) {
             System.out.print("-1" + " ");
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inOrder(Node root){
        if (root == null) {
            System.out.print("-1" + " ");
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }


    public static void postOrder(Node root){
        if (root == null) {
            // System.out.print("-1" + " ");
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }


    public static void levelOrder(Node root){

        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else{
                    q.add(null);
                }
            } else{
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }

                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }

        }
    }

    }


    public static int height(Node root){
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) +1 ;
    }

    public static int count(Node root){   //O(n)
        if (root == null) {
            return 0; 
        }

        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return leftCount + rightCount + 1;
    }


    public static int sum(Node root){
        if (root == null) {
            return 0;
        }

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        return leftSum + rightSum + root.data;
    }

    public static int diameter2(Node root){
        if (root == null) {
             return 0;
        }

        int leftDia = diameter2(root.left);
        int leftHeight = height(root.left);
        int rightDia = diameter2(root.right);
        int rightHeight = height(root.right);

        int selfDiam = leftHeight + rightHeight + 1 ;

        return Math.max(selfDiam,Math.max(rightDia, leftDia));

    }

    static class Info{
        int ht;
        int diam;

        public Info(int ht, int diam){
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static Info diameter(Node root){  //O(n)

        if (root == null ) {
            return new Info(0, 0);
        }
        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam) , leftInfo.ht + rightInfo.ht + 1);

        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1 ;

        return new Info(ht, diam);
    }

    public static boolean isIdentical(Node node , Node subRoot){
        if (node == null && subRoot == null) {
            return  true;
        }
        else if (node == null || subRoot == null || node.data!= subRoot.data) {
            return false ;
        }

        if (!isIdentical(node.left, subRoot.left)) {
            return false;
        }
        if (!isIdentical(node.right, subRoot.right)) {
            return false ;
        }

        return true;
    }

    public static boolean isSubtree(Node root , Node subRoot){
        if (root == null) {
            return false;
        }

        if (root.data == subRoot.data) {
            if (isIdentical(root , subRoot)) {
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }



    static class Info2 {
        int hd;
        Node node;
   
           public Info2(int hd , Node node){
               this.hd = hd;
               this.node = node;
           }
           
       }
   
       public static void topView(Node  root){
           // level Order Traversal
           Queue<Info2> q = new LinkedList<>();
           HashMap <Integer , Node > map = new HashMap<>();
   
           int min = 0 , max = 0;
           q.add(new Info2(0, root));
           q.add(null);
   
           
           while (!q.isEmpty()) {
               Info2 curr = q.remove();
               if (curr == null){
                   if (q.isEmpty()) {
                       break;
                   } else{
                       q.add(null);
                   }
               } else{
                if (!map.containsKey(curr.hd)) {  // first time my hd is occuring
                   map.put(curr.hd , curr.node);
               }

               if (curr.node.left != null) {
                    q.add(new Info2(curr.hd-1, curr.node.left));
                    min = Math.min(min, curr.hd-1);
               }

               if (curr.node.right != null) {
                  q.add(new Info2(curr.hd+1, curr.node.right));
                  max = Math.max(max, curr.hd+1);
               }
           } 
                
               }
               
               

           for(int i = min ; i <= max ; i++){
            System.out.print(map.get(i).data + " ");
           }
       }


    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();

        Node root = tree.buildTree(nodes);
       
        // tree.preorder(root);
        // System.out.println();
        // tree.inOrder(root);

        // tree.postOrder(root);

        // tree.levelOrder(root);

        /*
         *          1
         *         / \
         *       2     3
         *     / \   / \
         *    4  5  6   7
         */


        //  Node root = new Node(1);
        //  root.left = new Node(2);
        //  root.right = new Node(3);
        //  root.left.left = new Node(4);
        //  root.left.right = new Node(5);
        //  root.right.left = new Node(6);
        //  root.right.right = new Node(7);
        

        //  topView(root);


            /*        2     
         *           / \   
         *          4  5 
 
          */

        //   Node subRoot = new Node(2);
        //   subRoot.left = new Node(4);
        //   subRoot.right = new Node(5);

        //   // Subree of Another subtree
        //   System.out.println(isSubtree(root, subRoot));


        //  System.out.println("height is " + height(root));

        // System.out.println("No of Nodes are " + count(root));

        // System.out.println("Sum of Nodes are " + sum(root));

        // System.out.println(diameter(root));
        // System.out.println(diameter(root).diam);
        // System.out.println(diameter(root).ht);





    }
}
