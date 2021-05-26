package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinHeap<T> {
    class Node{
        T key;
        int weight;
        Node(T key, int weight){
            this.key=key;
            this.weight=weight;
        }
    }
    List<Node> allNodes;
    Map<T,Integer> pos;
    MinHeap(){
        allNodes = new ArrayList<>();
        pos = new HashMap<>();
    }
    boolean isEmpty(){
        return allNodes.isEmpty();
    }
    boolean containsKey(T key){
        return pos.containsKey(key);
    }
    int getWeight(T key){
        return allNodes.get(pos.get(key)).weight;
    }
    void swap(Node node1, Node node2){
        T key = node1.key;
        int weight = node1.weight;;
        node1.key = node2.key;
        node1.weight = node2.weight;
        node2.key = key;
        node2.weight = weight;
    }
    void updatePos(T key1, T key2, int pos1, int pos2){
        pos.remove(key1);
        pos.remove(key2);
        pos.put(key1, pos1);
        pos.put(key2, pos2);
    }
    void rearrange(int index){
        int parent = (index-1)/2;
        while (allNodes.get(index).weight < allNodes.get(parent).weight){
            swap(allNodes.get(index),allNodes.get(parent));
            updatePos(allNodes.get(index).key,allNodes.get(parent).key, index, parent);
            index = parent;
            parent = (index -1)/2;
        }
    }
    void add(T key, int weight){
        Node node = new Node(key, weight);
        allNodes.add(node);
        int size = allNodes.size()-1;
        pos.put(key,size);
        rearrange(size);
    }
    void decrease(T key, int weight){
        int index = pos.get(key);
        Node node = allNodes.get(index);
        node.weight = weight;
        rearrange(index);
    }
    Node extractMin(){
        Node min = allNodes.get(0);
        Node result = new Node(min.key, min.weight);
        int size = allNodes.size()-1;
        swap(allNodes.get(0),allNodes.get(size));
        updatePos(allNodes.get(0).key,allNodes.get(size).key,0,size);
        allNodes.remove(size);
        pos.remove(result.key);
        size--;
        int index =0;
        while (true){
            int left = index*2+1;
            int right = index*2+2;
            if(left>size){
                break;
            }
            if(right>size){
                right=left;
            }
            int minIndex = allNodes.get(left).weight <= allNodes.get(right).weight? left:right;
            if(allNodes.get(minIndex).weight < allNodes.get(index).weight){
                swap(allNodes.get(minIndex),allNodes.get(index));
                updatePos(allNodes.get(minIndex).key, allNodes.get(index).key, minIndex,index);
                index = minIndex;
            }else break;
        }
        return result;
    }
    public void printHeap(){
        for(Node n : allNodes){
            System.out.println(n.weight + " " + n.key);
        }
    }
    private void printPositionMap(){
        System.out.println(pos);
    }
    public static void main(String []args){
        MinHeap<String> heap = new MinHeap<>();
        heap.add("Tushar", 3);
        heap.add("Ani", 4);
        heap.add("Vijay", 8);
        heap.add("Pramila", 10);
        heap.add("Roy", 5);
        heap.add("NTF", 6);
        heap.add("AFR", 2);
        heap.decrease("Pramila", 1);
        heap.decrease("Vijay", 9);
        System.out.println("*********** Before Extract Min: ");
        heap.printHeap();
        System.out.println("Min: " + heap.extractMin());
        System.out.println("*********** After Extract Min: ");
        heap.printHeap();
        heap.printPositionMap();
    }
}
