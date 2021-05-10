package LinkedList;

public class LinkedListQuickSort {
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
    public static Node partition(Node low, Node high){
        Node i= null;
        int pivot = high.data;
        Node cur = low;
        while (cur!= null && cur != high){
            if(cur.data<pivot){
                if(i==null){
                    i = low;
                }else{
                    i = i.next;
                }
                int temp = cur.data;
                cur.data = i.data;
                i.data = temp;
            }
            cur = cur.next;
        }
        int temp = i.next.data;
        i.next.data = high.data;
        high.data = temp;
        return i;
    }
    public static void sort(Node low, Node high){
        if (low!=high && high.next!=low){
            Node partition = partition(low,high);
            sort(low, partition);
            sort(partition.next.next,high);
        }
    }
    public static void main(String[]args){
        Node head = null;
        head =  insertAtEnd(head, 30);
        head =  insertAtEnd(head, 3);
        head =  insertAtEnd(head, 4);
        head =  insertAtEnd(head, 20);
        head =  insertAtEnd(head, 5);
        Node cur = head;
        while (cur.next!= null){
            cur = cur.next;
        }
        print(head);
        sort(head,cur);
        print(head);
    }
}
