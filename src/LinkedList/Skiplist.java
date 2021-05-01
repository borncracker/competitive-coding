package LinkedList;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

class Skiplist {
    class Node {
        int val;
        Node next, down;
        public Node(int val, Node next, Node down) {
            this.val = val;
            this.next = next;
            this.down = down;
        }
    }
    Node head;
    Random rand;
    public Skiplist() {
        head = new Node(-1, null, null);
        rand = new Random();
    }

    public boolean search(int target) {
        Node cur = head;
        while (cur != null) {
            while (cur.next != null && cur.next.val < target) {
                cur = cur.next;
            }
            if (cur.next != null && cur.next.val == target) return true;
            cur = cur.down;
        }
        return false;
    }

    public void add(int num) {
        Deque<Node> stack = new ArrayDeque<>();
        Node cur = head;
        while (cur != null) {
            while (cur.next != null && cur.next.val < num) {
                cur = cur.next;
            }
            stack.push(cur);
            cur = cur.down;
        }
        boolean insert = true;
        Node down = null;
        while (insert && !stack.isEmpty()) {
            cur = stack.pop();
            cur.next = new Node(num, cur.next, down);
            down = cur.next;
            insert = rand.nextDouble() < 0.5;
        }
        if (insert)
            head = new Node(-1, null, head);
    }

    public boolean erase(int num) {
        Node cur = head;
        boolean found = false;
        while (cur != null) {
            while (cur.next != null && cur.next.val < num) {
                cur = cur.next;
            }
            if (cur.next != null && cur.next.val == num) {
                found = true;
                cur.next = cur.next.next;
            }
            cur = cur.down;
        }
        return found;
    }
    public static void main(String[]args){
        Skiplist obj = new Skiplist();
        obj.add(1);
        obj.add(2);
        obj.add(3);
        boolean param_1 = obj.search(0);
        obj.add(5);
        obj.add(4);
        param_1 = obj.search(1);
        boolean param_3 = obj.erase(0);
        param_3 = obj.erase(1);
        param_1 = obj.search(1);

    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */
