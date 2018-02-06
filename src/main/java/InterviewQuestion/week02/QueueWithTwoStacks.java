package InterviewQuestion.week02;

import ch01.Stack;
import edu.princeton.cs.algs4.StdOut;

public class QueueWithTwoStacks<Item> {
    private Stack<Item> stack1;
    private Stack<Item> stack2;

    public QueueWithTwoStacks(){
        stack1 = new Stack<Item>();
        stack2 = new Stack<Item>();
    }

    public void enquene(Item it){
        stack1.push(it);
    }

    public Item dequene(){
        Item it = null;
        if (isEmpty()) return it;
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        it = stack2.pop();
        return it;
    }

    public int getSize(){
        return stack1.size()+stack2.size();
    }

    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<Integer>();
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
