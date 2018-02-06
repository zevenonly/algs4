import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int size;
    private Object[] array = new Object[1];

    private void resize(int n) {
        Object[] copy = new Object[n];
        System.arraycopy(array, 0, copy, 0, size);
        array = copy;
    }

    // construct an empty randomized queue
    public RandomizedQueue() {
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (size == array.length) {
            resize(array.length * 2);
        }
        array[size] = item;
        size++;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int index = StdRandom.uniform(size);
        Item it = (Item) array[index];
        array[index] = array[size - 1];
        array[size - 1] = null;
        size--;
        if (size != 0 && size == array.length / 4) {
            resize(array.length / 2);
        }
        return it;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int index = StdRandom.uniform(size);
        return (Item) array[index];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private int index = size;
            private Object[] arrayCopy;

            {
                arrayCopy = new Object[size];
                System.arraycopy(array, 0, arrayCopy, 0, arrayCopy.length);
                StdRandom.shuffle(arrayCopy);
            }

            public boolean hasNext() {
                return index > 0;
            }

            public Item next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                Item it = (Item) arrayCopy[index - 1];
                index--;
                return it;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    // unit testing (optional)
    public static void main(String[] args) {
//        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<Integer>();
//        randomizedQueue.enqueue(1);
//        randomizedQueue.enqueue(2);
//        randomizedQueue.enqueue(3);
//        randomizedQueue.enqueue(4);
//        randomizedQueue.enqueue(5);
//        StdOut.println("out:" + randomizedQueue.dequeue());
//        StdOut.println("out:" + randomizedQueue.dequeue());
////        Iterator<Integer> it1 = randomizedQueue.iterator();
//        StdOut.println("one time");
//        for (Integer integer : randomizedQueue) {
//            StdOut.println(integer);
//        }
//        StdOut.println("second time");
//        for (Integer integer : randomizedQueue) {
//            StdOut.println(integer);
//        }
//        Iterator<Integer> it2 = randomizedQueue.iterator();


        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        rq.isEmpty();
        rq.enqueue(31);
        rq.dequeue();
        rq.isEmpty();
        rq.enqueue(20);

    }
}
