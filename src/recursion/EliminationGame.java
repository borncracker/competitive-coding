package recursion;

import java.util.ArrayList;
import java.util.List;

class EliminationGame {
    public static int solve(List<Integer> list, int k, int index, boolean reverse){
        if(list.size()==1){
            return list.get(0);
        }
        list.remove(index);
        int n = list.size();
        if(!reverse){
            index = (index+k);
            if(index >= list.size()){
                index = n-1;
                reverse = true;
            }
        }else{
            index = index-k-1;
            if(index <0){
                index =0;
                reverse=false;
            }
        }
        return solve(list, k, index, reverse);
    }
    public static void main(String[]args) {
        int n = 9;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(i+1);
        }
        int k=1;
        boolean reverse =false;
        int index =0;
        System.out.println( solve(list, k, index,reverse ));
    }
}