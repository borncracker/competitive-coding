package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class DiagonalTraversal {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data =data;
        }
    }
    public static class Pair{
        Node node;
        int level;
        Pair(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }
    public static void diagonalPrint(Node root){
        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(root);
        Node cur = root;
        while (!queue.isEmpty()){
            int size = queue.size();
            if(cur==null){
                cur = queue.removeFirst();
                cur = cur.left;
            }else{
                queue.removeFirst();
            }
            while (size>0){
                size--;
                while (cur != null){
                    System.out.print(cur.data+" ");
                    queue.addLast(cur);
                    cur=cur.right;
                }
                if(!queue.isEmpty() && size>0){
                    cur = queue.removeFirst();
                    cur = cur.left;
                }
            }
            System.out.println();
        }
    }
    public static void main(String[]args){
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);

        diagonalPrint(root);
    }
}
