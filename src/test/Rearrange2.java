package test;

import java.util.Arrays;

public class Rearrange2 {
    public static int[] arrange(int[]arr){
        int[]result = new int[arr.length];
        for(int i=0;i< arr.length;i++){
            result[i] = arr[i];
        }
        Arrays.sort(arr);
        int i=0,j;
        if(arr.length%2!=0) {
            j= arr.length -1;
        }else {
            j=arr.length -2;
        }
        for(;j>=0;j=j-2,i++){
            result[j]=arr[i];
        }
        for(j=1;j< arr.length;j=j+2,i++){
            result[j] = arr[i];
        }
        return result;
    }
    public static void main(String[]args){
        int[]arr ={1, 2, 1, 4, 5, 6, 8, 8};
        System.out.println(Arrays.toString(arrange(arr)));
    }
}
