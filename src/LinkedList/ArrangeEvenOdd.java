package LinkedList;

public class ArrangeEvenOdd {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data =data;
            this.next = null;
        }
    }
    public static Node insertAtEnd(Node head, int data){
        Node newNode = new Node(data);
        if(head == null){
            return newNode;
        }
        Node cur = head;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = newNode;
        return head;
    }
    public static void swap(Node pos1, Node pos2){
        if(pos1!=null && pos2 != null) {
            int temp = pos1.data;
            pos1.data = pos2.data;
            pos2.data = temp;
        }
    }
    public static Node arrange(Node head){
        Node odd = head;
        Node even = head;
        while (odd !=null && even != null) {
            while (odd !=null && odd.data%2 ==0)
                odd = odd.next;

            even = odd.next;

            while (even != null && even.data%2 !=0)
                even = even.next;
            swap(even,odd);
        }
        return head;
    }
    public static void print(Node root){
        while (root!= null && root.next!=null){
            System.out.print(root.data + " -> ");
            root = root.next;
        }
        if(root!=null){
            System.out.println(root.data);
        }
    }
    public static void main(String[]args){
        Node root = null;
        root = insertAtEnd(root,4);
        root = insertAtEnd(root,7);
        root = insertAtEnd(root,1);
        root = insertAtEnd(root,10);
        root = insertAtEnd(root,8);
        print(root);
        arrange(root);
        print(root);
    }
}
