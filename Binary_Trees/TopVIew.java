package Binary_Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopVIew {

    static class ListNode {
        int val;
        ListNode left, right;

        ListNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    static class Info {

        int horiDist;
        ListNode node;

        Info(int horiDist, ListNode node) {
            this.node = node;
            this.horiDist = horiDist;
        }

    }

    public static void topView(ListNode root) {
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, ListNode> map = new HashMap<>();
        int min = 0, max = 0;
        q.offer(new Info(0, root));
        q.offer(null);

        while (!q.isEmpty()) {

            Info currInfo = q.poll();
            if (currInfo == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {

                if (!map.containsKey(currInfo.horiDist)) {
                    map.put(currInfo.horiDist, currInfo.node);
                }

                if (currInfo.node.left != null) {
                    q.add(new Info(currInfo.horiDist - 1, currInfo.node.left));
                    min = Math.min(min, currInfo.horiDist - 1);
                }

                if (currInfo.node.right != null) {
                    q.add(new Info(currInfo.horiDist + 1, currInfo.node.right));
                    max = Math.max(max, currInfo.horiDist + 1);
                }
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).val + " ");
        }

    }

    public static void main(String[] args) {

        ListNode root = new ListNode(1);
        root.left = new ListNode(2);
        root.right = new ListNode(3);
        root.left.left = new ListNode(4);
        root.left.right = new ListNode(5);
        root.right.left = new ListNode(6);
        root.right.right = new ListNode(7);

        topView(root);
    }
}
