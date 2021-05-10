package queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FirstNegativeInEachWindow {
    public static List<Integer> calc(int[]arr, int k){
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        int i=0,j=0;
        while (j< arr.length){
            if(j-i+1<k){
                System.out.println("i: "+i+" j: "+ j + " Condition: " + (!deque.isEmpty() && deque.peekLast()>=0));
                System.out.println("Queue: "+deque);
                while (!deque.isEmpty() && deque.peekLast()>=0){
                    deque.removeLast();
                }
                deque.addLast(arr[j]);
                System.out.println("Queue: "+deque);
                j++;
            }
            if(j-i+1==k){
                while (!deque.isEmpty() && deque.peekLast()>=0){
                    deque.removeLast();
                }
                deque.addLast(arr[j]);
                if(deque.peekFirst()<0) {
                    result.add(deque.peekFirst());
                }else{
                    result.add(0);
                }
                if(arr[i]==deque.peekFirst()){
                    deque.removeFirst();
                }
                i++;
                j++;
            }
        }
        return result;
    }
    public static void main(String[]args){
        int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
        int n = arr.length;
        int k = 3;
        System.out.println(calc(arr, k));
    }
}
