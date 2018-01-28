import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Description:
 * User: dzczyw
 * Date: 2018-01-27
 * Time: 16:03
 */
public class PercolationStats {
    private static final double CONST_NUM = 1.96;
    private final double mean;
    private final double stddev;
    private final double confidenceLo;
    private final double confidenceHi;


    public PercolationStats(int n, int trials) {
        if (n < 1 || trials < 1) throw new IllegalArgumentException();
        double[] threshold = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            int[] params = StdRandom.permutation(n * n);
            for (int pos : params) {
                int row = pos / n + 1;
                int col = pos % n + 1;
                percolation.open(row, col);
                if (percolation.percolates())
                    break;
            }
            threshold[i] = (double) percolation.numberOfOpenSites() / (n * n);
        }
        // mean
        mean = StdStats.mean(threshold);
        // stddev
        stddev = StdStats.stddev(threshold);
        // confidenceLo
        confidenceLo = mean - (CONST_NUM * Math.sqrt(stddev) / Math.sqrt(trials));
        // confidenceHi
        confidenceHi = mean + (CONST_NUM * Math.sqrt(stddev) / Math.sqrt(trials));
    }

    public double mean() {
        return mean;
    }

    public double stddev() {
        return stddev;
    }

    public double confidenceLo() {
        return confidenceLo;
    }

    public double confidenceHi() {
        return confidenceHi;
    }

    public static void main(String[] args) {
        PercolationStats percolationStats = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        StdOut.printf("%-30s", "mean");
        StdOut.println("= " + percolationStats.mean());

        StdOut.printf("%-30s", "stddev");
        StdOut.println("= " + percolationStats.stddev());

        StdOut.printf("%-30s", "95% confidence interval");
        StdOut.printf("= [%f, %f]", percolationStats.confidenceLo(), percolationStats.confidenceHi());
    }
}
