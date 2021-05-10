package queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumSumSquareCount {
    public static class Pair{
        char ch;
        int count;
        Pair(char ch, int count){
            this.ch =ch;
            this.count = count;
        }
    }
    public static int minSum(String input, int k){
        Queue<Pair> maxHeap = new PriorityQueue<>((a,b)->b.count-a.count);
        Map<Character,Integer> freq = new HashMap<>();
        for(char ch:input.toCharArray()){
            if(freq.containsKey(ch)){
                freq.put(ch,freq.get(ch)+1);
            }else{
                freq.put(ch,1);
            }
        }
        for (Map.Entry<Character,Integer> entry: freq.entrySet()){
            maxHeap.add(new Pair(entry.getKey(),entry.getValue()));
        }
        for (int i=0;i<k;i++){
            Pair cur = maxHeap.remove();
            cur.count = cur.count-1;
            maxHeap.add(cur);
        }
        int sum =0;
        while (!maxHeap.isEmpty()){
            Pair cur = maxHeap.remove();
            sum+= (cur.count* cur.count);
        }
        return sum;
    }
    public static void main(String[]args){
        String str = "aaab"; int K = 2;
        System.out.println(minSum(str,K));
    }
}
