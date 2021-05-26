package tree;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromInAndPostTraversal {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data =data;
        }
    }
    public static Map<Integer,Integer> map = new HashMap<>();
    public static int getIndex(int[]arr, int i, int j, int k){
        if(map.containsKey(k)){
            int index = map.get(k);
            if(index >=i && index <=j)
                return index;
        }
        return -1;
    }
    public static Node getTree(int[] in,int[] post, int inStart, int inEnd, int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd){
            return null;
        }
        int index = getIndex(in, inStart,inEnd,post[postEnd]);
        if(index==-1)
            return null;
        Node root = new Node(post[postEnd]);
        root.left = getTree(in, post, inStart, index-1, postStart, postStart+index-1-inStart);
        root.right = getTree(in, post, index + 1, inEnd, index - inStart + postStart, postEnd-1);
        return root;
    }
    /* This funtcion is here just to test  */
    public static void preOrder(Node node)
    {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void populateMap(int[]arr){
        for (int i=0;i< arr.length;i++){
            map.put(arr[i],i);
        }
    }
    public static void main(String[]args){
        int in[] = new int[] { 4, 8, 2, 5, 1, 6, 3, 7 };
        int post[] = new int[] { 8, 4, 5, 2, 6, 7, 3, 1 };
        int n = in.length;
        populateMap(in);
        Node root
                = getTree(in, post, 0, n - 1, 0, n - 1);
        System.out.println(
                "Preorder of the constructed tree : ");
        preOrder(root);
    }
}
