package ch01;

import java.util.Iterator;

/**
 * Description:
 * User: dzczyw
 * Date: 2018-01-30
 * Time: 21:42
 */
public class Stack2<Item> implements Iterable<Item> {
    public Iterator<Item> iterator() {

        return new Iterator<Item>() {
            private int i = N;
            public boolean hasNext() {
                return i!=0;
            }

            public Item next() {
                return array[--i];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    private Item[] array = (Item[]) new Object[1];
    private int N = 0;

    public void push(Item item) {
        if(N == array.length) {
            array = resize(array.length*2);
        }
        array[N++] = item;
    }

    public Item pop() {
        Item it = array[--N];
        array[N] = null;
        if (N == array.length/4){
            array = resize(array.length/2);
        }

        return it;
    }

    private Item[] resize(int n){
        Item[] it = (Item[]) new Object[n];
        for (int i = 0; i < N; i++) {
            it[i] = array[i];
        }
        return it;
    }

    public static void main(String[] args) {
        Stack2<String> s = new Stack2<String>();
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

        for (String s1 : s) {
            System.out.println(s1);
        }

    }
}



