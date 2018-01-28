import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Description:
 * User: dzczyw
 * Date: 2018-01-27
 * Time: 15:58
 */
public class Percolation {
    private final WeightedQuickUnionUF modelTopSide;
    private final WeightedQuickUnionUF modelBottomSide;
    private boolean[] isOpened;
    private boolean isPercolated;
    private int openCount;
    private final int num;


    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        this.num = n;
        modelTopSide = new WeightedQuickUnionUF(n * n + 1);
        modelBottomSide = new WeightedQuickUnionUF(n * n + 1);
        isOpened = new boolean[n * n];

        // 连接虚拟topSide和首层
        for (int i = 0; i < n; i++) {
            modelTopSide.union(n * n, i);
        }
        // 连接虚拟bottomSide和底层
        for (int i = n * n - 1; i > n * n - 1 - n; i--) {
            modelBottomSide.union(n * n, i);
        }
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        validate(row, col);
        if (isOpen(row, col)) return;
        // 1. 找到点在数组的位置
        int index = getIndex(row, col);
        // 2. 把他open 用标志位变白
        isOpened[index] = true;
        // 3. 与它上下左右的白块连起来
        int up = index - num;
        int down = index + num;
        int left = index - 1;
        int right = index + 1;
        // upSide
        if (row > 1 && isOpen(row - 1, col)) {
            modelTopSide.union(index, up);
            modelBottomSide.union(index, up);
        }
        // downSide
        if (row < num && isOpen(row + 1, col)) {
            modelTopSide.union(index, down);
            modelBottomSide.union(index, down);
        }
        // leftSide
        if (col > 1 && isOpen(row, col - 1)) {
            modelTopSide.union(index, left);
            modelBottomSide.union(index, left);
        }
        // rightSide
        if (col < num && isOpen(row, col + 1)) {
            modelTopSide.union(index, right);
            modelBottomSide.union(index, right);
        }
        // 4.是否渗透
        if (modelTopSide.connected(index, num * num) && modelBottomSide.connected(index, num * num)) {
            isPercolated = true;
        }
        // 5.open数量标识+1
        openCount++;
    }

    private int getIndex(int row, int col) {
        return (row - 1) * num + col - 1;
    }

    private void validate(int row, int col) {
        if (row > num || row < 1 || col > num || col < 1) {
            throw new IllegalArgumentException();
        }
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        validate(row, col);
        int index = getIndex(row, col);
        return isOpened[index];
    }


    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        validate(row, col);
        int index = getIndex(row, col);
        return isOpen(row, col) && modelTopSide.connected(index, num * num);
    }


    // number of open sites
    public int numberOfOpenSites() {
        return openCount;
    }


    // does the system percolate?
    public boolean percolates() {
        return isPercolated;
    }

    // test client (optional)
    public static void main(String[] args) {
        In in = new In(args[0]);
        Percolation percolation = new Percolation(5);
        while (!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            percolation.open(p, q);
        }
    }
}
