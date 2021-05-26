package LinkedList;

public class MergeTwoSortedDoublyLinkedList {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data =data;
        }
    }
    public static Node insert(Node head, int data){
        Node newNode = new Node(data);
        if(head==null){
            return newNode;
        }
        newNode.right=head;
        head.left=newNode;
        head = newNode;
        return head;
    }
    public static void printList(Node head){
        while (head.right!=null){
            System.out.print(head.data+" -> ");
            head=head.right;
        }
        System.out.println(head.data);
    }
    public static Node merge(Node head1, Node head2){
        if(head1==null){
            return head2;
        }
        if(head2==null){
            return head1;
        }
        Node head = null;
        Node cur=null;
        Node next=null;
        Node cur2=null;
        if(head1.data < head2.data){
            head = head1;
            cur = head1;
            next = cur.right;
            cur2= head2;
        }else{
            head = head2;
            cur= head2;
            next=cur.right;
            cur2= head1;
        }
        while (next!= null && cur!=null && cur2!=null){
            while(next!=null && next.data < cur2.data){
                cur=next;
                next= next.right;
            }
            if(next==null){
                break;
            }
            Node next2 = cur2.right;
            cur.right = cur2;
            cur2.left = cur;
            cur2.right = next;
            next.left = cur2;
            cur = cur2;
            cur2= next2;
        }
        if (cur2!=null){
            cur.right = cur2;
            cur2.left = cur;
        }
        return head;
    }
    public static void main(String[]args){
        Node head1 = null;
        head1 = insert(head1,6);
        head1 = insert(head1,4);
        head1 = insert(head1,3);
        head1 = insert(head1,1);
        printList(head1);
        Node head2 = null;
        head2 = insert(head2, 8);
        head2 = insert(head2, 7);
        head2 = insert(head2, 5);
        head2 = insert(head2, 2);
        printList(head2);
        Node merged = merge(head1,head2);
        printList(merged);
    }
}
