package InterviewQuestion.week02;

import ch01.Stack;
import edu.princeton.cs.algs4.StdOut;

public class StackWithMax {
    private int max;
    private Stack stack;
    private Stack stackMax;

    public StackWithMax(){
        stack = new Stack();
        stackMax = new Stack();
    }

    public void push(int i){
        stack.push(i);
        if (i>max){
            max = i;
            stackMax.push(max);
        }
    }

    public int pop(){
        Object out = stack.pop();
        if((Integer)out==max){
            stackMax.pop();
            if (!stackMax.isEmpty()){
                Object maxOut = stackMax.pop();
                max = (Integer)maxOut;
                stackMax.push(max);
            }
        }
        return (Integer) out;
    }

    public int getMax(){
        return max;
    }

    public static void main(String[] args) {
        StackWithMax stackWithMax = new StackWithMax();
        stackWithMax.push(1);
        stackWithMax.push(0);
        stackWithMax.push(1);
        stackWithMax.push(2);
        stackWithMax.push(4);
        stackWithMax.push(3);
        stackWithMax.push(7);
        stackWithMax.push(5);
        StdOut.println("max:"+stackWithMax.getMax());
        stackWithMax.pop();
        StdOut.println("max:"+stackWithMax.getMax());
        stackWithMax.pop();
        StdOut.println("max:"+stackWithMax.getMax());
        stackWithMax.pop();
        StdOut.println("max:"+stackWithMax.getMax());
        stackWithMax.pop();
        StdOut.println("max:"+stackWithMax.getMax());
        stackWithMax.pop();
        StdOut.println("max:"+stackWithMax.getMax());
        stackWithMax.pop();
        StdOut.println("max:"+stackWithMax.getMax());
        stackWithMax.pop();
        StdOut.println("max:"+stackWithMax.getMax());
    }
}
