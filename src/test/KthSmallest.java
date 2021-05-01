package test;

import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallest {
    public static int count(int[]arr, int k){
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);
        int i=0;
        while (i< arr.length){
            queue.offer(arr[i++]);
            if(!queue.isEmpty() && queue.size()>k){
                queue.remove();
            }
        }
        return queue.peek();
    }
    public static void main(String[]args){
        int arr[] = {7, 10, 4, 3, 20, 15};
        int k =3;
        System.out.println(count(arr,k));
    }
}
