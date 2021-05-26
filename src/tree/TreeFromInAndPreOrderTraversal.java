package tree;

public class TreeFromInAndPreOrderTraversal {
    public static class Node{
        char data;
        Node left;
        Node right;
        Node(char data){
            this.data = data;
        }
    }
    public static int getIndex(char[]arr, int i, int j, char k){
        for(;i<=j;i++){
            if(arr[i]==k){
                return i;
            }
        }
        return -1;
    }
    public static Node constructTree(char[]in, char[]pre, int inStart, int inEnd, int preStart){
        int index=-1;
        Node node =null;
        if(inStart<=inEnd && preStart< pre.length){
            index = getIndex(in, inStart,inEnd,pre[preStart]);
            node = new Node(pre[preStart]);
            System.out.println(" inStart: "+ inStart + " inEnd: "+inEnd + " preStart:" + preStart);
            node.left = constructTree(in, pre, inStart, index-1, preStart+1);
            node.right = constructTree(in, pre, index+1, inEnd, preStart +1 + index-1 - inStart+1);
        }
        return node;
    }
    /* This funtcion is here just to test buildTree() */
    public static void printInorder(Node node)
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
        char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
        char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
        Node root = constructTree(in, pre, 0, in.length-1, 0);

        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        printInorder(root);
    }
}
