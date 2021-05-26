package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Edge{
    int weight;
    int u,v;
    Edge(int u, int v, int weight){
        this.u=u;
        this.v=v;
        this.weight=weight;
    }
}
public class KruskalAlgorithm {

    List<Edge> edges = new ArrayList<>();
    public void addEdge(Edge edge){
        edges.add(edge);
    }
    List<Edge> getMST(){
        List<Edge> result = new ArrayList<>();
        Collections.sort(edges, (a,b)->a.weight-b.weight);
        DisjointSet set = new DisjointSet();
        for (Edge edge: edges){
            if (!set.containsKey(edge.u))
                set.makeSet(edge.u);
            if(!set.containsKey(edge.v))
                set.makeSet(edge.v);
            if(set.union(edge.u, edge.v)){
                result.add(edge);
            }
        }
        return result;
    }
    public static void main(String[]args){
        KruskalAlgorithm graph = new KruskalAlgorithm();
        graph.addEdge(new Edge(1,2 ,2));
        graph.addEdge(new Edge(1,3 ,1));
        graph.addEdge(new Edge(2,4 ,5));
        graph.addEdge(new Edge(3,4 ,7));
        graph.addEdge(new Edge(3,5 ,1));
        graph.addEdge(new Edge(5,6 ,2));
        graph.addEdge(new Edge(4,6 ,3));

        for (Edge edge: graph.getMST()){
            System.out.println(edge.u +" "+ edge.v);
        }
    }
}
