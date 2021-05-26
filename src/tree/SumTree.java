package tree;

public class SumTree {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data =data;
        }
    }
    public static int convert(Node root){
        if(root==null ){
            return 0;
        }
        if(root.left ==null && root.right==null){
            int data = root.data;
            root.data =0;
            return data;
        }
        int left = convert(root.left);
        int right = convert(root.right);
        int data = root.data;
        root.data = left+right;
        return data + left + right;
    }
    // A utility function to print inorder traversal of a Binary Tree
    public static void printInorder(Node node)
    {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
    public static void main(String[]args){
        Node root = new Node(10);
        root.left = new Node(-2);
        root.right = new Node(6);
        root.left.left = new Node(8);
        root.left.right = new Node(-4);
        root.right.left = new Node(7);
        root.right.right = new Node(5);

        convert(root);

        // Print inorder traversal of the converted tree to test result
        // of toSumTree()
        System.out.println("Inorder Traversal of the resultant tree is:");
        printInorder(root);
    }
}
