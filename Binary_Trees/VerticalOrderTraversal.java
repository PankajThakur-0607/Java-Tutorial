import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.LinkedList;

public class VerticalOrderTraversal {

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

    static class Tuple {
        TreeNode node;
        int row;
        int col;

        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }

    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            Tuple curr = q.poll();
            TreeNode currNode = curr.node;
            int x = curr.row;
            int y = curr.col;

            if (!map.containsKey(y)) {
                map.put(y, new TreeMap<>());
            }

            if (!map.get(y).containsKey(x)) {
                map.get(y).put(x, new PriorityQueue<>());
            }

            map.get(y).get(x).offer(currNode.val);

            if (currNode.left != null) {
                q.add(new Tuple(currNode.left, x + 1, y - 1));
            }
            if (currNode.right != null) {
                q.add(new Tuple(currNode.right, x + 1, y + 1));
            }
        }

        List<List<Integer>> ans =  new ArrayList<>();
        for(TreeMap<Integer , PriorityQueue<Integer>> value : map.values()){

            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq : value.values()){
                while (!pq.isEmpty()) {
                    System.out.println(pq.peek());
                    ans.get(ans.size()-1).add(pq.poll());
                }
            }
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

        // You can add a method to perform vertical order traversal and call it here
        // For example: verticalOrderTraversal(root);
        List<List<Integer>> ans = verticalTraversal(root);

        for(List<Integer> num : ans){
            System.out.println(num);
        }
    }
    
}
