package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringPatternOccurrences {
    public static int occurrences(String text, String pattern){
        int result =0;
        Deque<Character> stack = new ArrayDeque<>();
        int i=0;
        while (i<text.length()){
            int j=0;
            boolean isMatchFound = true;
            while (i<text.length() && j<pattern.length()){
                if(text.charAt(i)!=pattern.charAt(j)){
                    isMatchFound = false;
                    break;
                }
                stack.push(text.charAt(i));
                i++;
                j++;
            }
            if(isMatchFound){
                result++;
                int k=pattern.length();
                while (!stack.isEmpty() && k > 0){
                    stack.pop();
                    k--;
                }
            }else{
                if(pattern.charAt(0)!=text.charAt(i)){
                    stack.push(text.charAt(i));
                    i++;
                }
            }
        }
        int i1 = pattern.length()-1;
        System.out.println("Stack: "+ stack);
        while (!stack.isEmpty()){
            if(i1<0){
                result ++;
            }
            i1 = (i1+pattern.length())%pattern.length();
            if(stack.pop()!=pattern.charAt(i1)){
                i1 = pattern.length()-1;
            }
            i1--;
        }
        result++;
        return result;
    }
    public static void main(String[]args){
        String text = "ABABCABCCABCABABCCABCBC";
        String pattern = "ABC";
        System.out.println(occurrences(text,pattern));
    }
}
