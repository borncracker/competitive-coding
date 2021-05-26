package graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimsMST {
    public class Edge{
        int start;
        int dest;
        int weight;
        Edge(int start,int dest, int weight){
            this.start =start;
            this.dest = dest;
            this.weight = weight;
        }
    }
    Map<Integer, List<Edge>> edges;
    int V;
    int E;
    PrimsMST(int v, int e){
        edges = new HashMap<>();
        V=v;
        E=e;
    }
    public void addEdges(int u, int v, int weight){
        if(edges.containsKey(u)){
            List<Edge> list = edges.get(u);
            list.add(new Edge(u, v, weight));
            edges.put(u, list);
        }else {
            List<Edge> list = new ArrayList<>();
            list.add(new Edge(u, v, weight));
            edges.put(u, list);
        }
    }
    public void printEdges(){
        for (List<Edge> edgeList: edges.values()){
            for (Edge edge: edgeList)
                System.out.print(edge.start + " " +edge.dest + " ");
            System.out.println();
        }
    }
    Map<Integer, Edge> findMST(){
        Map<Integer,Edge> result = new HashMap<>();
        Map<Integer,Edge> vertesToEdge = new HashMap<>();
        MinHeap<Integer> minHeap = new MinHeap<>();
        for (int i=1;i<=V;i++){
            minHeap.add(i,Integer.MAX_VALUE);
        }
        minHeap.decrease(1,0);
        while (!minHeap.isEmpty()){
            MinHeap.Node node = minHeap.extractMin();
            Edge edge1 = vertesToEdge.get(node.key);
            if(edge1!=null)
                result.put((Integer) node.key, edge1);
            for (Edge edge: edges.get(node.key)){
                if(minHeap.containsKey(edge.dest) && edge.weight < minHeap.getWeight(edge.dest)){
                    minHeap.decrease(edge.dest,edge.weight);
                    vertesToEdge.put(edge.dest,edge);
                }
            }
        }
        return result;
    }
    public void printMST(Collection<Edge> list){
        System.out.println("MST: ");
            for (Edge edge: list)
                System.out.print(edge.start + " " +edge.dest + " ");
            System.out.println();
    }
    public static void main(String[]args){
        PrimsMST graph = new PrimsMST(6, 7);
        graph.addEdges(1,2,5);
        graph.addEdges(1,3,2);
        graph.addEdges(2,1,5);
        graph.addEdges(2,4,1);
        graph.addEdges(3,1,2);
        graph.addEdges(3,4,7);
        graph.addEdges(3,5,1);
        graph.addEdges(4,2,1);
        graph.addEdges(4,3,7);
        graph.addEdges(4,6,3);
        graph.addEdges(5,3,1);
        graph.addEdges(5,6,2);
        graph.addEdges(6,4,3);
        graph.addEdges(6,5,2);
        graph.printEdges();
        graph.printMST(graph.findMST().values());
    }
}
