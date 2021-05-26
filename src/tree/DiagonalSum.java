package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class DiagonalSum {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data =data;
        }
    }
    public static void printDiagonalSum(Node root){
        Deque<Node> deque = new ArrayDeque<>();
        deque.addLast(root);
        Node cur = root;
        while (!deque.isEmpty()){
            int size = deque.size()-1;
            if(cur==null){
                cur=deque.removeFirst();
                cur=cur.left;
            }else{
                deque.removeFirst();
            }
            int sum=0;
            while (size>=0){
                size--;
                while (cur!=null){
                    sum += cur.data;
                    deque.addLast(cur);
                    cur = cur.right;
                }
                if(!deque.isEmpty() && size>=0) {
                    cur = deque.removeFirst();
                    cur = cur.left;
                }
            }
            System.out.println(sum);
        }
    }
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(9);
        root.left.right = new Node(6);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(7);
        root.left.right.left = new Node(11);
        root.left.left.right = new Node(10);
        printDiagonalSum(root);
    }
}
