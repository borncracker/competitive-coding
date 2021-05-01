package test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MaxInKWindow {
    public static List<Integer> max(int[]arr, int k){
        Deque<Integer> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        int i=0;
        int j=0;
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;
        while(j< arr.length){
            while(!queue.isEmpty() && arr[queue.peekLast()] < arr[j])
                queue.removeLast();
            queue.addLast(j);
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                result.add(arr[queue.peekFirst()]);
                if(i == queue.peekFirst()){
                    queue.removeFirst();
                }
                i++;
                j++;
            }
        }
        return result;
    }

    public static void main(String[]args){
        int[] arr = {1, 3, -1, -3, -2, 5, 3, 6, 7 };
        System.out.println(max(arr,3));
    }
}
