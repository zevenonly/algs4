package ch01;

import edu.princeton.cs.algs4.StdOut;

public class Queue<Item> {
    private int size;
    private Node first;
    private Node last;

    class Node{
        Item it;
        Node next;
    }

    public void enquene(Item it){
        Node newNode = new Node();
        newNode.it = it;
        if(first == last && first == null){
            first = newNode;
            last = newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }
        size++;

    }

    public Item dequene(){
        if (first == null)  return null;
        Item it;
        if (first == last){
            it = first.it;
            first = first.next;
            last = null;
        }else{
            it = first.it;
            first = first.next;
        }
        size--;
        return it;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return first == last && first == null;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();
        StdOut.println("空队列出队列"+queue.dequene());
        StdOut.println("空吗"+queue.isEmpty());
        queue.enquene(1);
        StdOut.println("空吗"+queue.isEmpty());
        StdOut.println("大小"+queue.getSize());
        queue.enquene(2);
        StdOut.println("大小"+queue.getSize());
        queue.enquene(3);
        StdOut.println("大小"+queue.getSize());
        StdOut.println("队列出队列"+queue.dequene());
        StdOut.println("队列出队列"+queue.dequene());
        StdOut.println("空吗"+queue.isEmpty());
        StdOut.println("队列出队列"+queue.dequene());
        StdOut.println("空吗"+queue.isEmpty());
        StdOut.println("队列出队列"+queue.dequene());
        StdOut.println("大小"+queue.getSize());
    }
}
