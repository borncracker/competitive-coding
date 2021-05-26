package tree;
// Java implementation to check if given Binary tree
// is a BST or not



public class IsBST
{
    /* Class containing left and right child of current
node and key value*/
    static class Node
    {
        int data;
        Node left, right;

        public Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    // Root of the Binary Tree
    static Node root;

    // To keep tract of previous node in Inorder Traversal
    static Node prev;

    static boolean isBST() {
        prev = null;
        return isBST(root);
    }

    /* Returns true if given search tree is binary
    search tree (efficient version) */
    static boolean isBST(Node node)
    {
        // traverse the tree in inorder fashion and
        // keep a track of previous node
        if (node != null)
        {
            if(node.left==null && node.right==null){
                return true;
            }
            boolean left = isBST(node.left);
            boolean right = isBST(node.right);
            if(left && right){
                if(node.data >node.left.data && node.data < node.right.data){
                    return true;
                }else
                    return false;
            }else return false;
        }
        return true;
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(1);

        if (isBST())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }
}
