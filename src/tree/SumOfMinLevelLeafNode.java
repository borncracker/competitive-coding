package tree;

public class SumOfMinLevelLeafNode {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    public static class MinSum{
        int level;
        int sum;
        MinSum(int level, int sum){
            this.level = level;
            this.sum =sum;
        }
    }
    public static void getMin(Node root, MinSum minSum, int index){
        if(root==null)
            return;
        if(root.left==null && root.right==null){
            if(minSum.level==-1){
                minSum.level =index;
                minSum.sum = root.data;
            }else if(minSum.level==index){
                minSum.sum += root.data;
            }else if(minSum.level > index){
                minSum.level = index;
                minSum.sum = root.data;
            }
        }
        getMin(root.left, minSum,index+1);
        getMin(root.right, minSum,index+1);
    }
    // Driver Code
    public static void main(String[] args)
    {

        // binary tree creation
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.right.left = new Node(8);
        root.right.left.right = new Node(9);
        MinSum minSum = new MinSum(-1,0);
        getMin(root, minSum, 0);
        System.out.println("Sum = " +
                minSum.sum);
    }
}
