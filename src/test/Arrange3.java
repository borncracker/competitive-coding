package test;

import java.util.Arrays;

public class Arrange3 {
    public static int[] arrange(int[]arr){
        int i=0;
        int j=1;
        while(i< arr.length && j< arr.length) {
            while (i< arr.length && arr[i] < 0)
                i=i+2;
            while (j< arr.length && arr[j] > 0)
                j=j+2;
            if(i< arr.length && j< arr.length) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return arr;
    }
    public static void main(String[]args){
        int[]arr= {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };
        System.out.println(Arrays.toString(arrange(arr)));
    }
}
