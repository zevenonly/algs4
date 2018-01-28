import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Description:
 * User: dzczyw
 * Date: 2018-01-27
 * Time: 11:24
 */


public class SocialConnectUF {
    private int N;
    private String filename;
    private WeightedQuickUnionUF uf;

    public SocialConnectUF(String filename,int n){
        this.N = n;
        this.filename = filename;
        uf = new WeightedQuickUnionUF(N);

    }

    public String getTimeStamp(){
        String timestamp = "";
        In in = new In(filename);
        while (!in.isEmpty()) {
            String line = in.readLine();
            String entry[] = line.split(" ");
            if(entry.length != 3) return "file syntax error";
            timestamp = entry[0];
            if (!uf.connected(Integer.parseInt(entry[1]),Integer.parseInt(entry[2]))){
                uf.union(Integer.parseInt(entry[1]),Integer.parseInt(entry[2]));
            }
            if(uf.count() == 1){
                return timestamp;
            }

        }
        return timestamp;
    }

    public static void main(String[] args) {
        SocialConnectUF sc = new SocialConnectUF("test",4);
        StdOut.println("result="+sc.getTimeStamp());
    }

}
