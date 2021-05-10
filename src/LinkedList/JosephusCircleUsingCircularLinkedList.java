package LinkedList;

public class JosephusCircleUsingCircularLinkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    public static Node insertAtLast(Node head, int data){
        Node newNode = new Node(data);
        if(head==null){
            newNode.next = newNode;
            return newNode;
        }
        Node cur = head;
        while (cur.next!= head){
            cur=cur.next;
        }
        cur.next = newNode;
        newNode.next = head;
        return head;
    }
    public static int remaining(Node head){
        Node cur = head;
        while (cur.next!= cur){
            cur.next = cur.next.next;
            cur = cur.next;
        }
        return cur.data;
    }
    public static void main(String[]args){
        Node head = null;
        for(int i=1;i<=9;i++){
            head = insertAtLast(head, i);
        }
        System.out.println(remaining(head));
    }
}
