package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class CurrentMaxInStack {
    static Deque<Integer> stack = new ArrayDeque<>();
    static int max = Integer.MIN_VALUE;
    static final int constant = 10000;
    public static int getMax(Deque<Integer> stack){
        return max;
    }
    public static void push(int elem){
        stack.push(elem*constant+max);
        if(max<elem){
            max = elem;
        }
    }
    public static int pop(){
        int temp = stack.pop();
        max = temp%constant;
        return temp/constant;
    }
    public static void main(String[]args){
        push(4);
        push(19);
        push(7);
        push(14);
        push(20);
        System.out.println(getMax(stack));
        pop();
        System.out.println(getMax(stack));
        pop();
        System.out.println(getMax(stack));
        pop();
        System.out.println(getMax(stack));
        pop();
        System.out.println(getMax(stack));
    }
}
