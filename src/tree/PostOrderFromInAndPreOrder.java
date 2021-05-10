package tree;

import java.util.Arrays;

public class PostOrderFromInAndPreOrder {
    public static int search(int[]arr, int start, int end, int k){
       for(int i=start;i<=end;i++){
           if(arr[i]==k){
               return i;
           }
       }
       return -1;
    }
    public static void printPostOrder(int[]in, int[]pre, int inStart, int inEnd, int preStart, int preEnd){
        if(inStart<=inEnd) {
            int root = search(in, inStart, inEnd, pre[preStart]);
            printPostOrder(in, pre, inStart, root - 1, preStart + 1, preStart + root - inStart);
            printPostOrder(in, pre, root + 1, inEnd, preStart + root - inStart + 1, preEnd);
            System.out.print(pre[preStart]);
        }
    }
    public static void main(String args[])
    {
        int in[] = { 4, 2, 5, 1, 3, 6 };
        int pre[] = { 1, 2, 4, 5, 3, 6 };
        int n = in.length;
        System.out.println("Postorder traversal " );
        printPostOrder(in, pre, 0, n-1, 0, n-1);
    }
}
