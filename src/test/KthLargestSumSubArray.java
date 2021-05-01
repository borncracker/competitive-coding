package test;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class KthLargestSumSubArray {
    static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object obj){
            if(obj == null)
                return false;
            if(obj == this){
                return true;
            }
            if(obj.getClass() != getClass())
                return false;
            Pair pair = (Pair)obj;
            if(pair.x == x && pair.y == y)
                return true;
            return false;
        }
        @Override
        public int hashCode(){
            int result =1;
            result += result * 31 + x >>>1;
            result += result * 31 + y >>>1;
            return result;
        }
    }
    static Set<Pair> set = new HashSet<>();
    public static int getMaxSum(int[]arr, int k){
        int start=0, end=0, sum = 0, max_so_far = Integer.MIN_VALUE, final_start=0;
        Queue<Integer> queue = new PriorityQueue<>((a,b)-> a-b);
        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= arr[i]+sum){
                sum = arr[i];
                start = i;
            }else{
                sum += arr[i];
            }
            if( max_so_far < sum){
                max_so_far = sum;
                final_start = start;
                end = i;
                queue.offer(max_so_far);
                if(queue.size()>k){
                    queue.poll();
                }
            }
        }
        return queue.poll();
    }
//    public static int getKthLargest(int[]arr, int k){
//        for (int i=0; i<k-1;i++)
//            System.out.println(getMaxSum(arr));
//        return getMaxSum(arr);
//    }
    public static void main(String[]args){
        int[]arr = {10, -10, 20, -40};
        int k =6;
        System.out.println(getMaxSum(arr,k));
    }
}
