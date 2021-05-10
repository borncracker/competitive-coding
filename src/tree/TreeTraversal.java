package tree;

public class TreeTraversal {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data =data;
        }
    }
    public static void preOrderTraversal(Node root) {
        if (root != null){
            System.out.print(root.data+"  ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }
    public static void inOrderTraversal(Node root){
        if(root!= null){
            inOrderTraversal(root.left);
            System.out.print(root.data+"  ");
            inOrderTraversal(root.right);
        }
    }
    public static void postOrderTraversal(Node root){
        if(root!=null){
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data+"  ");
        }
    }
    public static void main(String[]args){
        Node root = null;
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(
                "Preorder traversal of binary tree is ");
        preOrderTraversal(root);

        System.out.println(
                "\nInorder traversal of binary tree is ");
        inOrderTraversal(root);

        System.out.println(
                "\nPostorder traversal of binary tree is ");
        postOrderTraversal(root);
    }
}
