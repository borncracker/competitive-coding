package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationalSum {
    static List<List<Integer>> result = new ArrayList<>();
    public static void printCombination(int[]arr, int sum, List<Integer> list, int curSum, int index){
        if(sum == curSum){
            result.add(new ArrayList<>(list));
            return;
        }
        if(curSum > sum){
            return;
        }
        for(int i=index;i< arr.length;i++) {
            if(list.isEmpty() || arr[i]>= list.get(list.size()-1)) {
                list.add(arr[i]);
                printCombination(arr, sum, list, curSum + arr[i], index);
                list.remove((Integer) arr[i]);
            }
        }
    }
    public static void main(String[]args){
        int[]arr = {2,4,6,8};
        int sum = 8;
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        printCombination(arr, sum, list, 0, 0);
        if(result.isEmpty()){
            System.out.println("Empty");
        }else{
            result.forEach(list1 -> {
                list1.forEach(x -> System.out.print(x + " -> "));
                System.out.println();
            });
        }
    }
}
