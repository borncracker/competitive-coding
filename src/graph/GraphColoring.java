package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphColoring {
    Map<Integer, Set<Integer>> adjList = new HashMap<>();
    void addEdge(int u, int v){
        if(adjList.containsKey(u)){
            Set<Integer> set = adjList.get(u);
            set.add(v);
        }else{
            Set<Integer> set = new HashSet<>();
            set.add(v);
            adjList.put(u,set);
        }
    }
    Map<Integer, String> getColoursMap(List<String> colors){
        Map<Integer, String> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for (String color: colors){
            map.put(1,color);
            if(fillColoursUtility(1, map, visited, colors,0))
                return map;
        }
        return null;
    }
    boolean fillColoursUtility(int cur, Map<Integer,String> result, Set<Integer>visited, List<String> colors, int index){
        if(index==adjList.size()-1)
            return true;
        visited.add(cur);
        for (int neighbour: adjList.get(cur)){
            if(!visited.contains(neighbour)){
                for(String color: colors){
                    if(isValid(neighbour, color, result)){
                        result.put(neighbour, color);
                        if(fillColoursUtility(neighbour,result, visited, colors, index+1)){
                            return true;
                        }
                        result.remove(neighbour);
                    }
                }
                return false;
            }
        }
        return false;
    }
    boolean isValid(int vertex, String color, Map<Integer, String> map){
        for (int adj: adjList.get(vertex)){
            if(map.get(adj)==color){
                return false;
            }
        }
        return true;
    }
    public static void main(String[]args){
        GraphColoring graph = new GraphColoring();
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(1,5);
        graph.addEdge(2,1);
        graph.addEdge(2,3);
        graph.addEdge(3,2);
        graph.addEdge(3,1);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        graph.addEdge(4,1);
        graph.addEdge(4,3);
        graph.addEdge(5,1);
        graph.addEdge(5,4);
        List<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        System.out.println(graph.getColoursMap(colors));
    }
}
