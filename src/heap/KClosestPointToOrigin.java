package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class KClosestPointToOrigin {
    public static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString(){
            return x + " " + y;
        }
    }
    public static class Node{
        int key;
        Pair pair;
        Node(int key, Pair pair){
            this.key = key;
            this.pair = pair;
        }
    }
    public static List<Pair> kClosestPoint(int[][] arr, int k){
        PriorityQueue<Node> maxHeap = new PriorityQueue<>((a,b) -> b.key - b.key );
        for(int i=0;i<arr.length;i++){
            maxHeap.offer(new Node(arr[i][0]*arr[i][0] + arr[i][1]*arr[i][1] , new Pair(arr[i][0],arr[i][1])));
            if(maxHeap.size() > k)
                maxHeap.poll();
        }
        List<Pair> result = new ArrayList<>();
        while (!maxHeap.isEmpty())
            result.add(0,maxHeap.poll().pair);
        return result;
    }
    public static void main(String [] args){
        int[][] arr = {{1,3},{-2,2},{5,8},{0,1}};
        List <Pair> pair = kClosestPoint(arr, 2);

        for(int i=0;i<pair.size();i++)
            System.out.println(pair.get(i));
    }
}
