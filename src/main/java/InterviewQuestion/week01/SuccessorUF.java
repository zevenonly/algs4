package InterviewQuestion.week01;

import edu.princeton.cs.algs4.StdOut;

/**
 * Description:
 * User: dzczyw
 * Date: 2018-01-27
 * Time: 14:45
 */
public class SuccessorUF {
    private int[] parent;
    private boolean[] flag;
    private int N;

    public SuccessorUF(int n) {
        this.N = n;
        parent = new int[N];
        flag = new boolean[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            flag[i] = false;
        }
    }

    private int root(int p) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    private void delete(int p) {
        flag[p] = true;
        if (p + 1 < N && flag[p + 1])
            union(p, p + 1);
        if (p - 1 >= 0 && flag[p - 1])
            union(p - 1, p);
    }


    private void union(int p, int q) {
        // 小的数作为子节点连大的树
        int rootP = root(p);
        int rootQ = root(q);
        // 比较根节点的大小
        // 把根节点小的树加到大的树上
        if (rootQ < rootP) {
            parent[rootQ] = rootP;
        } else {
            parent[rootP] = rootQ;
        }
    }

    public int getResult(int p) {
        delete(p);
//        if(alone(p)) return p+1;
//        union(p,p+1);
//        return root(p);
        // 1. delete


        // 2. find 根节点 + 1
        return root(p) + 1;
    }


    public static void main(String[] args) {
        SuccessorUF successor = new SuccessorUF(10);
        StdOut.println("The successor of  3 is " + successor.getResult(3));
        StdOut.println("The successor of  4 is " + successor.getResult(4));
        StdOut.println("The successor of  5 is " + successor.getResult(5));
        StdOut.println("The successor of  0 is " + successor.getResult(0));
        StdOut.println("The successor of  1 is " + successor.getResult(1));
        StdOut.println("The successor of  2 is " + successor.getResult(2));

    }

}
