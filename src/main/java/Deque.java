
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private class Node {
        Item it;
        Node front;
        Node next;
    }

    private Node first;
    private Node last;
    private int size;

    public Deque() {
    }

    // is the deque empty?
    public boolean isEmpty() {
        return first == last && first == null;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node node = new Node();
        node.it = item;
        node.next = first;
        if (first != null)
            first.front = node;
        if (last == first && last == null)
            last = node;
        first = node;
        size++;
    }

    // add the item to the end
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node node = new Node();
        node.it = item;
        node.front = last;
        if (last != null) last.next = node;
        if (last == first && first == null) first = node;
        last = node;
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        Item it = first.it;
        if (first == last) {
            last = null;
            first = null;
        } else {
            first = first.next;
            last.next = null;
        }
        size--;
        return it;
    }

    // remove and return the item from the end
    public Item removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        Item it = last.it;
        if (last == first) {
            last = null;
            first = null;
        } else {
            last = last.front;
            last.next = null;
        }
        size--;
        return it;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {

        Iterator<Item> iterator = new Iterator<Item>() {

            Node it = first;

            public boolean hasNext() {
                return it != null;
            }

            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                Node current = it;
                it = it.next;
                return current.it;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return iterator;
    }

    // unit testing (optional)
    public static void main(String[] args) {
        Deque<String> stringDeque = new Deque<String>();
        stringDeque.addFirst("test");
        stringDeque.addFirst("test2");
        stringDeque.addFirst("test3");
        stringDeque.removeFirst();
        stringDeque.removeFirst();
        stringDeque.removeFirst();

        for (String item : stringDeque) {
            StdOut.println(item);
        }
    }
}

