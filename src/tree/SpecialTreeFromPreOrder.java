package tree;

public class SpecialTreeFromPreOrder {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data =data;
        }
    }
    public static class Index{
        int index;
        Index(int index){
            this.index=index;
        }
    }
    public static Node construct(int[]pre, char[]preNL, Index index){
        if(index.index >= pre.length){
            return null;
        }
        Node node = new Node(pre[index.index]);
        if(preNL[index.index]=='L') {
            index.index++;
            return node;
        }
        index.index++;
        node.left = construct(pre,preNL,index);
        node.right = construct(pre, preNL,index);
        return node;
    }
    /* This function is used only for testing */
    static void printInorder(Node node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.data + " ");

        /* now recur on right child */
        printInorder(node.right);
    }
    public static void main(String[]args){
        int pre[] = new int[]{10, 30, 20, 5, 15};
        char preLN[] = new char[]{'N', 'N', 'L', 'L', 'L'};
        Index index = new Index(0);
        // construct the above tree
        Node mynode = construct(pre, preLN, index);

        // Test the constructed tree
        System.out.println("Following is Inorder Traversal of the"
                + "Constructed Binary Tree: ");
        printInorder(mynode);
    }
}
