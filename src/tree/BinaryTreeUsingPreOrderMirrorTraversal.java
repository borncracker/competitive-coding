package tree;

public class BinaryTreeUsingPreOrderMirrorTraversal {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static int getIndex(int[]arr, int start, int end, int k){
        for(;start<=end;start++){
            if(arr[start]==k)
                return start;
        }
        return -1;
    }
    public static Node construct(int[]pre, int[]mirror, int preStart, int preEnd, int mirrorStart, int mirrorEnd){
        if(preStart>= pre.length || mirrorStart>= mirror.length || preStart>preEnd ||  mirrorStart > mirrorEnd){
            return null;
        }
        Node root = new Node(pre[preStart]);
        if(preStart==pre.length-1){
            return root;
        }
        int index = getIndex(mirror, mirrorStart,mirrorEnd,pre[preStart+1]);
        if(index==-1)
            return root;
        root.left = construct(pre,mirror, preStart+1, preStart + mirrorEnd-index+1, index,mirrorEnd);
        root.right = construct(pre,mirror, preStart + mirrorEnd-index+2, preEnd, mirrorStart+1, index-1);
        return root;
    }
    // A utility function to print inorder traversal
// of a Binary Tree
    static void printInorder(Node node)
    {
        if (node == null)
            return;

        printInorder(node.left);
        System.out.printf("%d ", node.data);
        printInorder(node.right);
    }
    public static void main(String[]args){
        int preOrder[] = {1,2,4,7,6,5,3};
        int preOrderMirror[] = {1,3,2,5,4,6,7};

        int size = preOrder.length;

        Node tree = construct(preOrder,preOrderMirror,0,size-1, 0, preOrderMirror.length-1);
        printInorder(tree);
    }
}
