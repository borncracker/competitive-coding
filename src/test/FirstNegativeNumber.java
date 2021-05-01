package test;

import java.util.ArrayList;
import java.util.List;

public class FirstNegativeNumber {
    public static List<Integer> getFirst(int[] arr, int k){
        int i=0;
        int j=0;
        List<Integer> negativeList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        while(j< arr.length){
            if(arr[j] < 0){
                negativeList.add(arr[j]);
            }
            if(j-i+1 < k)
                j++;
            else if(j-i+1 == k){
                if(negativeList.isEmpty()){
                    result.add(0);
                }else if(arr[i] == negativeList.get(0)){
                    result.add(negativeList.remove(0));
                }else{
                    result.add(negativeList.get(0));
                }
                i++;
                j++;
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[]arr = {12, -1, -7, 8, -18, 30, 16, 28};
        System.out.println(getFirst(arr, 3));
    }
}
