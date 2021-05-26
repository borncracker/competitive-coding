package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinaryTreeFromBracketRepresentation {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data =data;
        }
    }
    public static int getClosingIndex(String str, int start){
        Deque<Character> stack = new ArrayDeque<>();
        for (int i=start;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch==')'){
                while (!stack.isEmpty() && !(stack.pop()=='('));
            }else{
                stack.push(ch);
            }
            if(stack.isEmpty()) return i;
        }
        return -1;
    }
    public static Node getTree(String str, int start, int end){
        if(start>end || end >str.length())
            return null;
        Node root = new Node(str.charAt(start)-'0');
        if(start==end){
            return root;
        }
        int index = getClosingIndex(str, start+1);
        root.left = getTree(str, start+2, index-1);
        root.right = getTree(str, index+2, end-1);
        return root;
    }
    /* This funtcion is here just to test  */
    static void preOrder(Node node)
    {
        if (node == null)
            return;
        System.out.printf("%d ", node.data);
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void main(String[]args){
        String str = "4(2(3)(1))(6(5))";
        Node root = getTree(str, 0, str.length() - 1);
        preOrder(root);
    }
}
