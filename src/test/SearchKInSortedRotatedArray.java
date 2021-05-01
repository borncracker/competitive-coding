package test;

public class SearchKInSortedRotatedArray {
    public static int search(int[]arr, int k){
        int low =0, high = arr.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == k){
                return mid;
            }else if(arr[mid] > arr[high]){
                if(k < arr[mid] && k >= arr[low])
                    high = mid-1;
                else
                    low = mid+1;
            }else{
                if(k > arr[mid] && k <= arr[high])
                    low = mid +1;
                else
                    high = mid -1;
            }
        }
        return -1;
    }
    public static void main(String[]args){
        int[]arr = {9,10, 4, 5, 7 ,8};
        System.out.println(search(arr,9));
        System.out.println(search(arr,8));
        System.out.println(search(arr,4));
        System.out.println(search(arr,10));
        System.out.println(search(arr,5));
    }
}
