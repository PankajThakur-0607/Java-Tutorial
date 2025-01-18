import java.util.ArrayList;
import java.util.List;

public class NodeToPath {
    

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

    public static boolean getNodePath(TreeNode root, List<Integer> ans , int target){
        if (root == null) {
            return false;
        }

        ans.add(root.val);

        if (root .val == target ) {
            return true;
        }
        if(getNodePath(root.left, ans, target) || getNodePath(root.right, ans, target)){
            return true;
        }
        ans.remove(ans.size()-1);
        
        return false;
    }
    public static List<Integer> findNodePath(TreeNode root , int target){
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        getNodePath(root , ans , target);


        return ans;
    }

    public static void main(String[] args) {
        // Creating the tree nodes
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> ans = findNodePath(root, 7);
        System.out.println(ans);
    }
}
