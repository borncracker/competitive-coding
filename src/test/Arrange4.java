package test;

import java.util.Arrays;

public class Arrange4 {
    public static int[] arrange(int[]arr){
        int i=0;
        int j=0;
        while(i< arr.length && j< arr.length){
            while (i< arr.length && arr[i]!=0){
                i++;
            }
            j=i+1;
            while (j< arr.length && arr[j]==0){
                j++;
            }
            if(i< arr.length && j< arr.length){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return arr;
    }
    public static void main(String[] args){
        int[]arr = {1, 2, 0, 4, 3, 0, 5, 0};
        System.out.println(Arrays.toString(arrange(arr)));
    }
}
