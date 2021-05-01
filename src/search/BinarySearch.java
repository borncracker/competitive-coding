package search;

public class BinarySearch {
    public static int binarySearch(int[]arr, int key, int low, int high){
        if(low >high)
            return -1;
        else if( low == high){
            if(key == arr[low])
                return low;
            else
                return -1;
        }else{
            int mid = low + (high-low)/2;
            if(key == arr[mid])
                return mid;
            else if(key < arr[mid]){
                return binarySearch(arr, key, low, mid-1);
            }else{
                return binarySearch(arr, key, mid+1, high);
            }
        }
    }
    public static void main(String [] args){
        int[] arr = {1,4,7,9,12};
        int key = 4;
        assert binarySearch(arr, key, 0, arr.length-1) == 1;
        int[] arr1 = {1,4,7,9,12};
        int key1 = 3;
        System.out.println(binarySearch(arr1, key1, 0, arr.length-1));
    }
}
