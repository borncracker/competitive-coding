package greedy;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {
    static Map<Integer, Node> map = new HashMap<>();
    static class Node{
        int data;
        Node parent;
        int rank;
        Node(int data){
            this.data = data;
            this.rank = 0;
        }
    }

    public static Node makeSet(int data){
        Node node = new Node(data);
        node.parent = node;
        map.put(data, node);
        return  node;
    }

    public static Node find(int data){
        Node node = map.get(data);
        if(node.parent.data == data){
            return node.parent;
        }
        node.parent = find(node.parent.data);
        return node.parent;
    }

    public static Node union(int data1, int data2){
        Node parent1 = find(data1);
        Node parent2 = find(data2);
        if(parent1 ==  parent2){
            System.out.println(parent1.data + " and " + parent2.data + " belongs to same set");
            return parent1;
        }
        if(parent1.rank <= parent2.rank) {
            parent2.rank = parent1.rank == parent2.rank ? parent2.rank+1 : parent2.rank;
            parent1.parent = parent2;
            return parent2;
        }
        else {
            parent2.parent = parent1;
            return  parent1;
        }
    }


}
