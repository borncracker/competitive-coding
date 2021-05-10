package tree;

public class NthNodeInPostOrderTraversal {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data =data;
        }
    }
    public static int nthNode(Node root, int k){
        Node nth= new Node(-1);
        findUtil(root,0,k,nth);
        if(nth.data!=-1)
            return nth.data;
        else
            return -1;
    }
    public static int findUtil(Node root, int index, int k, Node result){
        if(root!=null){
            if(root.left==null && root.right==null){
                if(index+1==k){
                    result.data=root.data;
                    return index+1;
                }
                return index+1;
            }else {
                int left = findUtil(root.left, index, k, result);
                int right = findUtil(root.right, left, k, result);
                if (right+1==k){
                    result.data=root.data;
                }
                return right + 1;
            }
        }
        return index;
    }
    public static void main(String[]args){
        Node root = new Node(25);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(18);
        root.left.right = new Node(22);
        root.right.left = new Node(24);
        root.right.right = new Node(32);

        int N = 6;

        // prints n-th node found
        System.out.print(nthNode(root, N));
    }

}
