package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackPermutation {
    public static boolean isStackPermutation(int[]input, int[]output){
        Deque<Integer> stack = new ArrayDeque<>();
        int i=0, j=0;
        while (i<input.length){
            if(output[j]==input[i]){
                j++;
                i++;
            }else{
                if(!stack.isEmpty() && stack.peek()==output[j]) {
                    stack.pop();
                    j++;
                }else{
                    stack.push(input[i]);
                    i++;
                }
            }
        }
        if(j== output.length){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[]args){
// Input Queue
        int input[] = { 1, 2, 3 };

        // Output Queue
        int output[] = { 3, 1, 2 };
        int n = 3;
        if (isStackPermutation(input, output))
            System.out.println("Yes");
        else
            System.out.println("Not Possible");
    }
}
