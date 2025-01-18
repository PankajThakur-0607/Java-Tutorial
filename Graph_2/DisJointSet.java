package Graph_2;

public class DisJointSet {

    static int n = 7;
    static int parent[] = new int[7];
    static int rank[] = new int[7];

    // O(n)
    public static void init() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    //O(4K)
    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        // path compression
        return parent[x] = find(parent[x]);
    }

    // O(4K) 
    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            parent[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            parent[parA] = parB;
        } else {
            parent[parB] = parA;
        }

    }

    public static void main(String[] args) {
        init();
        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        System.out.println(find(4));
        union(3, 6);
        union(4, 6);
        System.out.println(find(6));
        System.out.println(find(1));
        System.out.println("parent of 3 : " + find(3));

        for (int i = 0; i < parent.length; i++) {
            System.out.println("parent of " + i + ":" + parent[i]);
        }
    }
}
