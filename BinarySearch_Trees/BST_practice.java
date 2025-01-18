import java.util.*;

public class BST_practice {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static int rangeSumBST(Node root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        int left = 0;
        int right = 0;
        if (low <= root.data && root.data <= high) {
            sum += root.data;
            // System.out.println(sum);

        }
        if (root.data > low) {
            left = rangeSumBST(root.left, low, high);
            System.out.println("left" + left);
        }
        if (root.data < high) {
            right = rangeSumBST(root.right, low, high);
            System.out.println("right " + right);

        }
        sum += left + right;

        return sum;

    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data);
        inOrder(root.right);
    }

    static int min;
    static int minData;

    public static void closestElementHelp(Node root, int k) {

        if (root == null) {
            return;
        }
        if (root.data == k) {
            minData = k;
            return;
        }

        if (min > Math.abs(root.data - k)) {
            min = Math.abs(root.data - k);
            minData = root.data;
        }

        if (k < root.data) {
            closestElementHelp(root.left, k);
        } else {
            closestElementHelp(root.right, k);
        }

    }

    public static int closestElement(Node root, int k) {
        min = Integer.MAX_VALUE;
        minData = -1;

        closestElementHelp(root, k);

        return minData;
    }
        static int count = 0;
        static int result = Integer.MAX_VALUE;
    
    public static void kthHelperfunc(Node root, int k) {
        
        if (root == null) {
            return ;
        }
         kthHelperfunc(root.left, k);

        count++;
        if (count == k) {
             result = root.data;
             return;
        }

         kthHelperfunc(root.right, k);

    }

    public static int kthSmallest(Node root , int k){
        kthHelperfunc(root, k);
        return result;
    }


    public static void getInorder(Node root , ArrayList <Integer> arr){
         if (root == null) {
             return ;
         }
        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }

    public static int twoSum(Node root1 , Node root2 , int target){


        // BSt to AL Transfer
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1 , arr1);

        // Bst to Al tranfer
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        // Merge
        ArrayList<Integer> finalarr = new ArrayList<>();
        int i =0 , j=0;
        while (i < arr1.size() && j < arr2.size()) {

            if (arr1.get(i) <= arr2.get(j)) {
                finalarr.add(arr1.get(i));
                i++;
             }
             else{

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


       


        int lp = 0 , rp = finalarr.size()-1;
        int count = 0;
        while (lp!=rp) {

             if (finalarr.get(lp) + finalarr.get(rp) == target) {
                count ++;
             } else if (finalarr.get(lp) + finalarr.get(rp) > target) {
                rp--;
             } else{
                lp++;
             }
        }
       
        return count;

    }

    public static int countPairs(Node root1 , Node root2 , int k){
        if (root1 == null || root2 == null) {
             return 0;
        }

      

        Stack <Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
          int count = 0;
        Node top1 , top2;

        while (true) {
             
            while (root1!= null) {
                s1.push(root1);
                root1 = root1.left;
            }

            while (root2 != null) {
                 s2.push(root2);
                 root2 = root2.right;
            }

            if (s1.isEmpty() || s2.isEmpty()) {
                  break;
            }

            top1 = s1.peek();
            top2 = s2.peek();
            if ((top1.data + top2.data) == k) {
                
                count++ ;

                s1.pop();
                s2.pop();

                root1 = top1.right;
                root2 = top2.left;
            }

           else if ((top1.data + top2.data) > k) {
                 s2.pop();
                 root2 = top2.left;
            } else{
                 s1.pop();
                 root1 = top1.right;
            }


        }
        return count;
    }


    static class Info {
      boolean isBSt;
      int min;
      int max;
      int sum;


                Info(boolean isBST , int min , int max, int sum ){
                     this.isBSt = isBST;
                     this.min = min;
                     this.max = max;
                     this.sum = sum;

                }
        
    }
   public  static int maxSum = 0;

      public static Info maxSumBst(Node root){
        if (root == null) {
             return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Info leftInfo = maxSumBst(root.left);
        Info rightInfo = maxSumBst(root.right);

        int min = Math.min(root.data, Math.min(leftInfo.min,rightInfo.min));
        int max = Math.max(root.data, Math.min(leftInfo.max,rightInfo.max));
        int sum = root.data + leftInfo.sum + rightInfo.sum;
        
        

        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
             return new Info(false, min, max, sum);
        }

        
        if (leftInfo.isBSt && rightInfo.isBSt) {
            maxSum = Math.max(maxSum ,  sum );
            
            return new Info(true, min, max, sum);
        }

        return new Info(false, min, max, sum);


      }



    public static void main(String[] args) {

        // Node root = new Node(8);
        // root.left = new Node(5);
        // root.left.left = new Node(3);
        // root.left.right = new Node(6);

        // root.right = new Node(11);
        // root.right.right = new Node(20);

        // System.out.println(rangeSumBST(root, 6, 20));

        // System.out.println(closestElement(root, 5 ));

    //    System.out.println(kthSmallest(root, 2));


    // Node root1 = new Node(5);
    // root1.left = new Node(3);
    // root1.left.left = new Node(2);
    // root1.left.right = new Node(4);

    // root1.right = new Node(7);
    // root1.right.left = new Node(6);
    // root1.right.right = new Node(8);



    // Node root2 = new Node(10);
    // root2.left = new Node(6);
    // root2.left.left = new Node(3);
    // root2.left.right = new Node(7);

    // root2.right = new Node(15);
    //  root2.right.left = new Node(12);
    // root2.right.right = new Node(16);
   
    

    // System.out.println(countPairs(root1, root2, 18 ));


        Node root = new Node(1);
        root.left = new Node(4);
        root.left.left = new Node(2);
        root.left.right = new Node(3);

        root.right = new Node(3);
        root.right.right = new Node(5);
        root.right.left = new Node(2);
        root.right.right.left = new Node(4);
        root.right.right.right = new Node(6);

        Info res = maxSumBst(root);
        System.out.println(maxSum);





    


    }
}
