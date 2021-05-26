package graph;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {
    class Node{
        int data;
        Node parent;
        int rank;
        Node(int data){
            this.data =data;
            parent = this;
            rank=0;
        }
    }

    Map<Integer, Node> map = new HashMap<>();
    public void makeSet(int id){
        Node node = new Node(id);
        map.put(id,node);
    }
    public boolean containsKey(int key){
        return map.containsKey(key);
    }
    public Node findSet(Node node){
        if(node.parent==node)
            return node.parent;
        node.parent = findSet(node.parent);
        return node.parent;
    }

    public boolean union(int id1, int id2){
        Node node1= map.get(id1);
        Node node2 = map.get(id2);
        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);
        if(parent1.data==parent2.data)
            return false;
        if(parent1.rank== parent2.rank){
            parent1.rank++;
            parent2.parent = parent1;
        }else if(parent1.rank > parent2.rank){
            parent2.parent = parent1;
        }else{
            parent1.parent= parent2;
        }
        return true;
    }

    public static void main(String args[]) {
        DisjointSet ds = new DisjointSet();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);
        for (Map.Entry<Integer, Node> entry: ds.map.entrySet()) {
            System.out.println(entry.getKey() + "  " + entry.getValue().parent.data);
        }
    }
}
