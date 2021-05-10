package stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CurrentMaximum {
    public static List<Integer> getMaximum(int[]arr){
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        for(int i=0;i< arr.length;i++){
            if(stack.isEmpty()){
                result.add(arr[i]);
            }else if(!stack.isEmpty() && stack.peek()>arr[i]){
                result.add(stack.peek());
            }else{
                while (!stack.isEmpty() && stack.peek()<arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    result.add(arr[i]);
                }else{
                    result.add(stack.peek());
                }
            }
            stack.push(arr[i]);
        }
        return result;
    }
    public static void main(String[]args){
        int[]arr ={4, 19, 7, 14, 20};
        System.out.println(getMaximum(arr));
    }
}
