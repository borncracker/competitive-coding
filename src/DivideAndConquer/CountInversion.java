package DivideAndConquer;

import java.util.Arrays;

public class CountInversion {
    public static int merge(int[]arr, int low, int mid, int high){
        int[]left = Arrays.copyOfRange(arr, low,mid+1);
        int[]right = Arrays.copyOfRange(arr, mid+1, high+1);
        int i = 0;
        int j = 0;
        int k = low;
        int swap = 0;
        while(i< left.length && j< right.length){
            if(left[i]>right[j]){
                arr[k++]=right[j++];
                swap += ((mid+1) - (low+i));
            }else{
                arr[k++] = left[i++];
            }
        }
        while (i<left.length)
            arr[k++]=left[i++];
        while (j<right.length)
            arr[k++]=right[j++];
        return swap;
    }
    public static int mergeAndCount(int[]arr, int low, int high){
        int count=0;
        if(low<high){
            int mid = low + (high-low)/2;
            count+=mergeAndCount(arr, low, mid);
            count+=mergeAndCount(arr, mid+1, high);
            count+=merge(arr, low, mid, high);
        }
        return count;
    }
    public static void main(String[]args){
        int[] arr = { 1, 20, 6, 4, 5 };

        System.out.println(
                mergeAndCount(arr, 0, arr.length - 1));
    }
}
