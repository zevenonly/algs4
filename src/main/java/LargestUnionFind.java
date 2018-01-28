import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Description:
 * User: dzczyw
 * Date: 2018-01-27
 * Time: 12:34
 */
public class LargestUnionFind {
    private int N;
    private int parent[];
    //    private int size[];
    private int count;

    public LargestUnionFind(int n) {
        this.N = n;
        this.count = n;
        parent = new int[n];
//        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
//            size[i] = 1;
        }
    }

    public int count() {

        return count;
    }

    public int find(int p) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        // 找打根节点
        int rootP = find(p);
        int rootQ = find(q);
        // 比较根节点的大小
        // 把根节点小的树加到大的树上
        if (rootQ < rootP) {
            parent[rootQ] = rootP;
        } else {
            parent[rootP] = rootQ;
        }
        count--;
    }

    public static void main(String[] args) {
        In in = new In();
        LargestUnionFind find = new LargestUnionFind(10);
        while (!in.isEmpty()){
            int p = in.readInt();
            int q = in.readInt();
            find.union(p,q);
        }

        StdOut.println("result = " + find.find(1));
    }

}