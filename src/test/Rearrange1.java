package test;

import java.util.Arrays;

public class Rearrange1 {
    public static int[] arrange(int[]arr){
        int i=0;
        while(i< arr.length){
            if(i==arr[i] || arr[i] ==-1){
                i++;
            }else{
                int temp =arr[i];
                arr[i] = arr[arr[i]];
                arr[temp] = temp;
            }
        }
        return arr;
    }
    public static void main(String[]args){
        int[] arr ={ -1, -1, 6, 1, 9, 3, 2, -1, 4, -1 };
        System.out.println(Arrays.toString(arrange(arr)));
    }
}
