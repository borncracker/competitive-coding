package LinkedList;

public class SegregateEvenOddLinkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static Node insertAtEnd(Node head, int data){
        Node newNode = new Node(data);
        if(head==null)
            return newNode;
        Node cur = head;
        while (cur.next!=null){
            cur=cur.next;
        }
        cur.next = newNode;
        return head;
    }
    public static void print(Node head){
        Node cur = head;
        while (cur != null && cur.next!= null){
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.print(cur.data);
        System.out.println();
    }
    public static Node segeregate(Node head){
        Node cur = head;
        Node prev = null;
        while (cur!= null && cur.next!= null){
            while (cur!= null && cur.data%2==0){
                prev = cur;
                cur = cur.next;
            }
            Node even = cur.next;
            Node prevEven = cur;
            while (even!= null && even.data%2!=0){
                prevEven = even;
                even = even.next;
            }
            if(even==null)
                return head;
            prevEven.next = even.next;
            even.next = cur;
            if(prev == null){
                head = even;
                prev = head;
            }else{
                prev.next = even;
                prev = even;
            }
        }
        return head;
    }
    public static void main(String[]args){
        Node head = null;
        head =  insertAtEnd(head, 17);
        head =  insertAtEnd(head, 15);
        head =  insertAtEnd(head, 8);
        head =  insertAtEnd(head, 12);
        head =  insertAtEnd(head, 10);
        head =  insertAtEnd(head, 5);
        head =  insertAtEnd(head, 4);
        head =  insertAtEnd(head, 1);
        head =  insertAtEnd(head, 7);
        head =  insertAtEnd(head, 6);
        print(head);
        head = segeregate(head);
        print(head);
    }
}
