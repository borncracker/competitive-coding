package tree;

public class SpecialTreeFromInOrder {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data =data;
        }
    }
    public static int getIndex(int[]arr, int i, int j){
        int max=Integer.MIN_VALUE;
        int index =-1;
        for(;i<=j;i++){
            if(arr[i]>max){
                max = arr[i];
                index =i;
            }
        }
        return index;
    }
    public static Node construct(int[]in, int start, int end){
        if(start>end){
            return null;
        }
        int index = getIndex(in, start,end);
        if(index==-1){
            return null;
        }
        Node root = new Node(in[index]);
        root.left = construct(in, start,index-1);
        root.right = construct(in, index+1, end);
        return root;
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
        /* Assume that inorder traversal of following tree is given
             40
            /   \
          10     30
         /         \
        5          28 */
        int inorder[] = new int[]{5, 10, 40, 30, 28};
        int len = inorder.length;
        Node mynode = construct(inorder, 0, len - 1);

        /* Let us test the built tree by printing Inorder traversal */
        System.out.println("Inorder traversal of the constructed tree is ");
        printInorder(mynode);
    }
}
