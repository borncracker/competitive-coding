package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveBraces {
    public static String remove(String input){
        Deque<Boolean> sign = new ArrayDeque<>();
        sign.push(true);
        String output="";
        int i=0;
        while (i<input.length()){
            if(input.charAt(i)=='('){
                if(i-1>=0){
                    if(input.charAt(i-1)=='-')
                        sign.push(!sign.peek());
                    else
                        sign.push(sign.peek());
                }
            }else if(input.charAt(i)==')'){
                sign.pop();
                if(sign.isEmpty())
                    sign.push(true);
            }else{
                if(Character.isAlphabetic(input.charAt(i))){
                    output += input.charAt(i);
                }else{
                    if(sign.peek())
                        output += input.charAt(i);
                    else if(input.charAt(i)=='+'){
                        output += '-';
                    }else{
                        output += '+';
                    }
                }
            }
            i++;
        }
        return output;
    }
    public static void main(String[]args){
        System.out.println(remove("a-(b+c))"));
        System.out.println(remove("a-(b-c-(d+e))-f"));
    }
}
