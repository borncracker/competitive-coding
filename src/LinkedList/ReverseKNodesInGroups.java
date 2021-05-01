package LinkedList;

public class ReverseKNodesInGroups {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static Node reverse(Node head, int k){
        Node end = null;
        Node cur = head;
        Node start = head;
        while (cur!= null){
            int count = k;
            Node prev =null;
            Node next;
            while (cur != null && count > 0){
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                count--;
            }
            if(end ==  null){
                end = head;
                head = prev;
                start = cur;
            }else{
                end.next = prev;
                end = start;
                start = cur;
            }
        }
        return head;
    }
    public static Node add(Node head, int data){
        Node node = new Node(data);
        if(head ==null){
            return node;
        }
        Node cur = head;
        while (cur!= null && cur.next!=null){
            cur = cur.next;
        }
        cur.next = node;
        return head;
    }
    public static void print(Node node){
        while (node.next!=null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println(node.data);
    }
    public static void main(String[]args){
        Node head = null;
        for(int i = 1;i <= 7; i++)
            head = add(head,i);
        print(head);
        head = reverse(head, 3);
        print(head);
    }
}
