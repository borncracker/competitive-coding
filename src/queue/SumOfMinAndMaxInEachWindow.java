package queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SumOfMinAndMaxInEachWindow {
    public static int calculate(int[]arr, int k){
        List<Integer> min = new ArrayList<>();
        List<Integer> max = new ArrayList<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();
        int i=0,j=0;
        while(i<arr.length && j<arr.length){
            if(j-i+1 < k){
                while (!minDeque.isEmpty() && minDeque.peekLast()>arr[j]){
                    minDeque.removeLast();
                }
                minDeque.addLast(arr[j]);
                while (!maxDeque.isEmpty() && maxDeque.peekLast() < arr[j]){
                    maxDeque.removeLast();
                }
                maxDeque.addLast(arr[j]);
                j++;
            }
            if(j-i+1 ==k){
                while (!minDeque.isEmpty() && minDeque.peekLast()>arr[j]){
                    minDeque.removeLast();
                }
                minDeque.addLast(arr[j]);
                while (!maxDeque.isEmpty() && maxDeque.peekLast() < arr[j]){
                    maxDeque.removeLast();
                }
                maxDeque.addLast(arr[j]);
                min.add(minDeque.peekFirst());
                max.add(maxDeque.peekFirst());
                i++;
                j++;
            }
        }
        int result =0;
        for (int l=0;l<min.size();l++){
            result +=(max.get(l) + min.get(l));
        }
        return result;
    }
    public static void main(String[]args){
        int arr[] = {2, 5, -1, 7, -3, -1, -2};
        int K = 4;
        System.out.println(calculate(arr,K));
    }
}
