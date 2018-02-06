import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        In in = new In();
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<String>();
        while (!in.isEmpty()) {
            randomizedQueue.enqueue(in.readString());
        }

        Iterator<String> iterator = randomizedQueue.iterator();
        for (int i = 0; i < k; i++) {
            if (iterator.hasNext())
                StdOut.println(iterator.next());
        }
    }
}
