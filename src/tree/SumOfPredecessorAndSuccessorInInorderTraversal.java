package tree;

import java.util.ArrayList;
import java.util.List;

public class SumOfPredecessorAndSuccessorInInorderTraversal {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data =data;
        }
    }
    public static void inOrderTraversal(Node root){
        if(root!=null){
            inOrderTraversal(root.left);
            System.out.print(root.data + "  ");
            inOrderTraversal(root.right);
        }
    }
    public static void getInOrderList(Node root, List<Integer> list){
        if(root!=null){
            getInOrderList(root.left, list);
            list.add(root.data);
            getInOrderList(root.right, list);
        }
    }
    public static void getSumList(List<Integer> list){
        int constant = 10000;
        for(int i=0;i<list.size();i++){
            int sum=0;
            if(i-1>=0){
                sum+=list.get(i-1)%constant;
            }
            if(i+1<list.size()) {
                sum += list.get(i + 1)%constant;
            }
            list.set(i, sum*constant+list.get(i)%constant);
        }
        for(int i=0;i<list.size();i++){
            list.set(i,list.get(i)/constant);
        }
    }
    public static void replaceNodeWithSum(Node root){
        List<Integer> list = new ArrayList<>();
        getInOrderList(root,list);
        getSumList(list);
        replaceNodeWithSumUtil(root, list, -1);
    }
    public static int replaceNodeWithSumUtil(Node root, List<Integer> list, int index){
        if(root!=null) {
                int left = replaceNodeWithSumUtil(root.left, list, index);
                root.data = list.get(left+1);
                int right = replaceNodeWithSumUtil(root.right, list, left+1);
                return right;
        }
        return index;
    }
    public static void main(String[]args){
        // binary tree formation
        Node root = new Node(1);       //         1        
        root.left = new Node(2);        //       /   \      
        root.right = new Node(3);       //     2      3     
        root.left.left = new Node(4);  //    /  \  /   \   
        root.left.right = new Node(5); //   4   5  6   7   
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println( "InOrder Traversal before tree modification:");
        inOrderTraversal(root);

        replaceNodeWithSum(root);

        System.out.println("\nInOrder Traversal after tree modification:");
        inOrderTraversal(root);
    }
}
