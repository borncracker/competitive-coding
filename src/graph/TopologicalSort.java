package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopologicalSort {
    public static class Graph{
        int V;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Graph(int v){
            v = V;
        }
        public void addEdge(int u, int v){
            if(adj.containsKey(u)){
                adj.get(u).add(v);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(v);
                adj.put(u,list);
            }
        }
    }

    public static void main(String[]args){
        int size = 5;
        Graph graph =  new Graph(size);
        graph.addEdge(1,4);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(2,5);
        graph.addEdge(3,6);
        graph.addEdge(4,7);
        graph.addEdge(4,8);
        graph.addEdge(5,9);
    }
}
