package tree;

// Java program to find if there is a duplicate
// sub-tree of size 2 or more.
import java.util.HashSet;
public class IsDuplicateSubTree {

    // This function returns empty string if tree
    // contains a duplicate subtree of size 2 or more.
    public static String dupSubUtil(Node root, HashSet<String> subtrees)
    {
        String s = "#";

        // If current node is NULL, return marker
        if (root == null)
            return "";

        // If left subtree has a duplicate subtree.
        String lStr = dupSubUtil(root.left,subtrees);
        if (lStr.equals(s))
            return s;

        // Do same for right subtree
        String rStr = dupSubUtil(root.right,subtrees);
        if (rStr.equals(s))
            return s;

        // Serialize current subtree
        s = root.data + lStr + rStr;

        // If current subtree already exists in hash
        // table. [Note that size of a serialized tree
        // with single node is 3 as it has two marker
        // nodes.
        if (s.length()>1 && subtrees.contains(s))
            return "#";

        subtrees.add(s);
        return s;
    }

    //Function to find if the Binary Tree contains duplicate
    //subtrees of size 2 or more
    public static String dupSub(Node root)
    {
        HashSet<String> subtrees=new HashSet<>();
        return dupSubUtil(root,subtrees);
    }

    public static void main(String args[])
    {
        Node root = new Node('A');
        root.left = new Node('B');
        root.right = new Node('C');
        root.left.left = new Node('D');
        root.left.right = new Node('E');
        root.right.right = new Node('B');
        root.right.right.right = new Node('E');
        root.right.right.left= new Node('D');
        //  root.right.right.left.right= new Node('F');
        String str = dupSub(root);
        if(str.equals("#"))
            System.out.print(" Yes ");
        else
            System.out.print(" No ");
    }
}

// A binary tree Node has data,
// pointer to left child
// and a pointer to right child
class Node {
    char data;
    Node left,right;
    Node(char data)
    {
        this.data=data;
    }
};
//This code is contributed by Gaurav Tiwari
