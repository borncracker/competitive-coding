package tree;

public class BinaryTreeFromParentArray {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static Node getTree(int[]parent){
        Node []nodes = new Node[parent.length];
        for(int i=0;i< parent.length;i++){
            nodes[i]= new Node(i);
        }
        Node root = null;
        for (int i=0;i< parent.length;i++){
            if(parent[i]==-1){
                root = nodes[i];
            }else{
                if(nodes[parent[i]].left==null){
                    nodes[parent[i]].left = nodes[i];
                }else {
                    nodes[parent[i]].right = nodes[i];
                }
            }
        }
        return root;
    }
    // Utility function to do inorder traversal
    static void inorder(Node node)
    {
        if (node != null)
        {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }
    public static void main(String[]args){
        int parent[] = new int[]{-1, 0, 0, 1, 1, 3, 5};
        Node node = getTree(parent);
        System.out.println("Inorder traversal of constructed tree ");
        inorder(node);
    }
}
