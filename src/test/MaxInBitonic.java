package test;

public class MaxInBitonic {
    public static int findMax(int[]arr){
        int low=0, high = arr.length -1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if(mid > 0 && mid < arr.length -1){
                if(arr[mid]> arr[mid -1] && arr[mid] > arr[mid +1]){
                    return arr[mid];
                }else if(arr[mid] > arr[mid-1]){
                    low = mid +1;
                }else{
                    high = mid -1;
                }
            }else if(mid ==0){
                if(arr.length ==1)
                    return arr[mid];
                else
                    return arr[mid]> arr[mid+1]? arr[mid]: arr[mid+1];
            }else if(mid == arr.length-1){
                if(arr[mid] > arr[mid-1])
                    return arr[mid];
                else return arr[mid-1];
            }
        }
        return -1;
    }
    public static void main(String[]args){
        int[] arr = {2};
        System.out.println(findMax(arr));
        int[] arr1 = {1,2};
        System.out.println(findMax(arr1));
    }
}
