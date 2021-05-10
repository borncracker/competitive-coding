package LinkedList;

public class ReverseKNodesInGroupDoublyLL {
    static class Node{
        Node prev;
        int data;
        Node next;
        Node(int data){
            prev = null;
            this.data = data;
            next = null;
        }
    }
    public static Node add(Node head, int data){
        Node node = new Node(data);
        if(head==null)
            return node;
        Node cur = head;
        while (cur.next!=null){
            cur = cur.next;
        }
        cur.next = node;
        node.prev = cur;
        return head;
    }
    public static void print(Node head){
        Node cur = head;
        while (cur.next!=null){
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.println(cur.data);
    }
    public static Node reverse(Node head, int k){
        Node prevEnd = null;
        Node cur = head;
        Node start = head;
        Node end = null;
        while (cur != null){
            int count =k;
            while (cur!= null && count>0){
                Node temp = cur.next;
                cur.next = cur.prev;
                cur.prev = temp;
                end = cur;
                cur = cur.prev;
                count--;
            }
            if(prevEnd == null){
                prevEnd = head;
                head = end;
                head.prev = null;
                start = cur;
            }else{
                prevEnd.next = end;
                end.prev = prevEnd;
                prevEnd = start;
                start.next = null;
                start = cur;
            }
        }
        return head;
    }
    public static void main(String[]args){
        Node head =null;
        for(int i=1; i<= 1;i++)
            head = add(head, i);
        print(head);
        head = reverse(head, 3);
        print(head);
    }
}
