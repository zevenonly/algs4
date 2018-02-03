package ch01;

import java.util.Iterator;

/**
 * Description:
 * User: dzczyw
 * Date: 2018-01-30
 * Time: 21:42
 */
public class Stack<Item> implements Iterable<Item> {
    public Iterator<Item> iterator() {

        return new Iterator<Item>() {
            private Node current;
            public boolean hasNext() {
                return current!=null;
            }

            public Item next() {
                Item it = current.it;
                current = current.next;
                return it;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    class Node {
        Item it;
        Node next;
    }

    private Node first;

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.it = item;
        first.next = oldFirst;
    }

    public Item pop() {
        Item it = first.it;
        first = first.next;
        return it;
    }

    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
        s.push("to");
        s.push("be");
        s.push("or");
        s.push("not");
        s.push("to");
        s.push("be");
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        s.push("sb");
        s.push("sb2");
        System.out.println(s.pop());

    }
}



