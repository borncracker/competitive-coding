package test;

public class HeightOfTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }
    public static int height(Node root){
        if (root!=null){
            if(root.left==null && root.right==null){
                return 0;
            }else{
                return Math.max(height(root.left),height(root.right)) + 1;
            }
        }
        return 0;
    }

    public static void main(String[]args){
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Height of tree is : " +
                height(root));
    }
}
