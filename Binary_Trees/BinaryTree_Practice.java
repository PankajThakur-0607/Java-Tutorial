package Binary_Trees;

public class BinaryTree_Practice {
    static class Node {
      int data;
      Node left;
      Node right;

       public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
       }
    }

    public static boolean isUnivalued(Node root){
        if (root == null) {
            return true;
        }
       
        if (root.left != null && root.left.data != root.data) {
             return false;
        }

        if (root.right != null && root.right.data != root.data) {
            return false;
        }

        return isUnivalued(root.left) && isUnivalued(root.right) ;
    }


    public static Node invertBinaryTree(Node root){

        if (root == null ) {
            return root;
        }

        Node left = invertBinaryTree(root.left);
        Node right = invertBinaryTree(root.right);

        // swap 
        root.right = left;
        root.left = right;
             
        return root;
    }

    public static void preorder(Node root){

        if (root == null) {
            return ;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static Node deleteLeafNodes(Node root, int x){
        if (root == null) {
            return null ;
        }

      root.left =  deleteLeafNodes(root.left, x);
       root.right =  deleteLeafNodes(root.right, x);

        if (root.left == null && root.right == null && root.data == x) {
               return null;
        }
        return root;
}


        public static Node mirror(Node root){
            if (root == null) {
                return null;
            }

            Node leftSub = mirror(root.left);
            Node rightSub = mirror(root.right);

            root.left = rightSub;
            root.right = leftSub;

            return root;
        }

        public static void inOrder(Node root) {
            if (root == null) {
                return;
            }
    
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }



    public static void main(String[] args) {
        

        /*
         *           2
         *         /   \
         *       2      2
         *     /   \    
         *    5     2
         */

        //  Node root = new Node(2);
        //  root.left = new Node(2);
        //  root.right = new Node(2);
        //  root.left.left = new Node(2);
        //  root.left.right = new Node(2);

        //  System.out.println(isUnivalued(root));


           /*   root
         *          1
         *         / \
         *       2     3
         *     / \   / \
         *    4  5  6   7
         * 
         *  root1 
         *          1
         *         / \
         *       3     2
         *     / \   / \
         *    7  6  5   4
         */



         Node root = new Node(8);
         root.left = new Node(5);
         root.right = new Node(10);
         root.left.left = new Node(3);
         root.left.right = new Node(6);
        //  root.right.left = new Node();
         root.right.right = new Node(11);

        preorder(root);
        System.out.println();
        mirror(root);
        preorder(root);
         






        


        // Question No 2
        //  preorder(root);
        //  invertBinaryTree(root);
        //  System.out.println();
        //  preorder(root);


        //  Node root2 = new Node(1);
        //  root2.left = new Node(3);
        //  root2.right = new Node(3);
        //  root2.left.left = new Node(3);
        //  root2.left.right = new Node(2);
        // //  root2.right.left = new Node(5);
        // //  root2.right.right = new Node(4);

        // preorder(root2);
        // deleteLeafNodes(root2, 3);
        // System.out.println();
        // preorder(root2);



         
    }
}
