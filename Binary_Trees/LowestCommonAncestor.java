package Binary_Trees;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {

    static class ListNode {

        int val;
        ListNode left;
        ListNode right;

        public ListNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }

    }

    public static boolean getNode(ListNode root , int n , ArrayList<ListNode> path){

        if (root == null) {
            return false;
        }

        path.add(root);
        
        if (root.val == n) {
            return true;
        }
        


        boolean foundLeft = getNode(root.left, n, path);
        boolean foundright = getNode(root.right, n, path);

        if (foundright || foundLeft) {
            return true;
        }

        path.remove(path.size()-1);
        return false;

    }


    // O(4N) && O(2N) + O(H)
    public static ListNode lca_V1(ListNode root, int n1, int n2) {

        ArrayList<ListNode> path1 = new ArrayList<>();
        ArrayList<ListNode> path2 = new ArrayList<>();

        getNode(root, n1, path1);
        getNode(root, n2, path2);

        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        // ListNode node = path1.get(i - 1);
        return new ListNode(path1.get(i-1).val);
    }


    public static ListNode lca_V2(ListNode root , int n1 , int n2){

        if (root == null || root.val == n1 || root.val == n2) {
            return root;
        }
        ListNode left =   lca_V2(root.left, n1, n2);
        ListNode right  = lca_V2(root.right, n1, n2); 

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return root; 
    }

    public static void main(String[] args) {
        /*
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         */

        ListNode root = new ListNode(1);
        root.left = new ListNode(2);
        root.right = new ListNode(3);
        root.left.left = new ListNode(4);
        root.left.right = new ListNode(5);
        root.right.left = new ListNode(6);
        root.right.right = new ListNode(7);

        System.out.println(lca_V1(root, 4, 5).val);
        System.out.println(lca_V2(root, 4, 5).val);
    }
}
