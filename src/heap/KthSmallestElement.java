package heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElement {
    public static void kthElement(int[]arr, int k){
        Queue minHeap = new PriorityQueue((a, b) -> (Integer)b - (Integer)a);
        for(int i=0;i<arr.length;i++){

            minHeap.offer(arr[i]);
            if(minHeap.size() > k)
                minHeap.poll();
        }
        System.out.println(minHeap.peek());
    }
    public static void main(String []args){
        int[] arr = {7, 10, 4, 3, 20, 15};
        kthElement(arr, 3);
    }
}
