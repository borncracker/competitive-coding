package test;

public class FirstAndLastOccInSortedArrary {
    public static int firstOccurance(int[]arr, int k){
        int firstOccurance = -1;
        int low = 0, high = arr.length-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(k == arr[mid]){
                firstOccurance = mid;
                high = mid-1;
            }else if(k< arr[mid]){
                high = mid -1;
            }else{
                low = mid +1;
            }
        }
        return firstOccurance;
    }
    public static int lastOccurance(int[]arr, int k){
        int lastOccurance = -1;
        int low =0; int high = arr.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(k == arr[mid]){
                lastOccurance = mid;
                low = mid +1;
            }else if( k < arr[mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return lastOccurance;
    }
    public static void main(String[]args){
        int []arr = {4, 5, 10, 10, 10};
        int k = 10;
        System.out.println(firstOccurance(arr, k));
        System.out.println(lastOccurance(arr, k));
    }
}
