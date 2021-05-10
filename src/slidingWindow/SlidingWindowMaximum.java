package slidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMaximum {
    public static List<Integer> getMaxList(int[]arr, int k){
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        int i=0,j=0;
        while (j< arr.length){
            if(j-i+1 <k){
                while (!deque.isEmpty() && deque.peekLast() < arr[j]){
                    deque.removeLast();
                }
                deque.addLast(arr[j]);
                j++;
            }
            if(j-i+1==k){
                while (!deque.isEmpty() && deque.peekLast() < arr[j]){
                    deque.removeLast();
                }
                deque.addLast(arr[j]);
                result.add(deque.peekFirst());
                if(deque.peekFirst()==arr[i]){
                    deque.removeFirst();
                }
                i++;
                j++;
            }
        }
        return result;
    }
    public static void main(String[]args){
        int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
        int k = 3;
        System.out.println(getMaxList(arr, k));
    }
}
