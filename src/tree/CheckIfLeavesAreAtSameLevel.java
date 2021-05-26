package tree;

public class CheckIfLeavesAreAtSameLevel {
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
            this.index = index;
        }
    }
    public static boolean isSameLevel(Node root, Index index, int level){
        if(root==null){
            return true;
        }
        if(root.left==null && root.right==null){
            if(index.index==-1){
                index.index = level;
                return true;
            }else{
                if(index.index==level){
                    return true;
                }else return false;
            }
        }
        return isSameLevel(root.left,index,level+1) && isSameLevel(root.right,index,level+1);
    }
    public static void main(String args[])
    {
        // Let us create the tree as shown in the example
        Node root = new Node(12);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(9);
        root.left.left.left = new Node(1);
        root.left.right.left = new Node(2);
        root.left.right.left.left = new Node(3);
        Index index =  new Index(-1);
        if (isSameLevel(root, index, 0))
            System.out.println("Leaves are at same level");
        else
            System.out.println("Leaves are not at same level");
    }
}
