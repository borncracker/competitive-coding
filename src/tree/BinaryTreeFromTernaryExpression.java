package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinaryTreeFromTernaryExpression {
    public static class Node{
        char data;
        Node left;
        Node right;
        Node(char data){
            this.data =data;
        }
    }
    public static int getIndex(String str, int i, int j){
        Deque<Character> stack = new ArrayDeque<>();
        for (;i<=j;i++){
            char ch = str.charAt(i);
            if(ch==':'){
                while (!stack.isEmpty() && !(stack.pop()=='?'));
            }else{
                stack.push(ch);
            }
            if(stack.isEmpty())
                return i;
        }
        return -1;
    }
    public static Node constructTree(String input, int start, int end){
        if(start>end)
            return null;
        Node root = new Node(input.charAt(start));
        int index = getIndex(input, start+2,end);
        if(index==-1){
            return root;
        }
        root.left = constructTree(input, start+2, index-1);
        root.right = constructTree(input, index+1, end);
        return root;
    }
    // function print tree
    static public void printTree( Node root)
    {
        if (root == null)
            return;

        System.out.print(root.data +" ");
        printTree(root.left);
        printTree(root.right);
    }

    // Driver program to test above function
    public static void main(String args[])
    {
        String exp = "a?b?c:d:e";
        Node root = constructTree(exp, 0, exp.length()-1);
        printTree(root) ;
    }
}
