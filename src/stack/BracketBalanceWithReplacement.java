package stack;

import java.util.ArrayDeque;
import java.util.Deque;

//Balanced expression with replacement https://www.geeksforgeeks.org/balanced-expression-replacement/
public class BracketBalanceWithReplacement {
    public static boolean isMatching(char ch1, char ch2){
        if((ch1=='(' && ch2==')')||(ch1 == '{' && ch2 == '}') || (ch1 == '[' && ch2 == ']') || ch1 == 'X'){
            return true;
        }
        return false;
    }
    public static boolean isBalanced(String str, Deque<Character> stack){
        int i=0;
        while (i< str.length()){
            char ch = str.charAt(i);
            if(ch =='(' || ch == '{' || ch == '[' ){
                stack.push(ch);
            }else if(ch == ')' || ch == '}' || ch == ']'){
                if(stack.isEmpty())
                    return false;
                char top = stack.pop();
                if(!isMatching(top,ch))
                    return false;
            }else if(ch == 'X'){
                Deque<Character> temp = new ArrayDeque<>(stack);
                temp.push('X');
                boolean x1 = isBalanced(str.substring(i+1),temp);
                boolean x2 = false;
                if(!stack.isEmpty()) {
                    stack.pop();
                    temp = new ArrayDeque<>(stack);
                    x2 = isBalanced(str.substring(i + 1), temp);
                }
                return x1 || x2;
            }
            i++;
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }
    public static void main(String[]args){
        String S = "{(X[X])}";
        Deque<Character> stack = new ArrayDeque<>();
        if(isBalanced(S, stack)){
            System.out.println("Balanced");
        }else{
            System.out.println("Not Balanced");
        }
    }
}
