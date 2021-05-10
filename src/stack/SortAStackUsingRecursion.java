package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class SortAStackUsingRecursion {
    public static void insertMin(Deque<Integer> stack, int k){
        if(stack.isEmpty() || stack.peek()<k){
            stack.push(k);
        }else if(stack.peek()>k){
            int elem = stack.pop();
            insertMin(stack,k);
            stack.push(elem);
        }
    }
    public static void sort(Deque<Integer> stack){
        if(!stack.isEmpty()){
            int elem = stack.pop();
            sort(stack);
            insertMin(stack, elem);
        }
    }
    public static void main(String[]args){
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-3);
        stack.push(14);
        stack.push(18);
        stack.push(-5);
        stack.push(30);
        sort(stack);
        System.out.println(stack);
    }
}
