package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringDecode {
    public static String decode(String input){
        Deque<String> stack = new ArrayDeque<>();
        for (int i=0;i< input.length();i++){
            String str = Character.toString(input.charAt(i));
            if("]".equals(str)){
                String temp = "";
                while (!stack.isEmpty() && !stack.peek().equals("[")){
                    temp = stack.pop() + temp;
                }
                stack.pop();
                int times = Integer.valueOf(stack.pop());
                String temp1="";
                while (times>0){
                    times--;
                    temp1 +=temp;
                }
                stack.push(temp1);
            }else{
                stack.push(str);
            }
        }
        return stack.pop();
    }
    public static void main(String[]args){
        String str = "2[a2[b]]";
        System.out.println(decode(str));
    }
}
