package slidingWindow;
import java.util.*;

// Java implementation to find the length
// of longest subarray having sum k
class LargestWindowWithSumK {
    // function to find the length of longest
    // subarray having sum k
    static int lenOfLongSubarr(int[] arr, int k)
    {
        int i=0,j=0,sum=0,maxLen=Integer.MIN_VALUE;
        while (j<arr.length){
            sum+=arr[j];
            if(sum==k){
                if(maxLen < j-i+1){
                    maxLen = j-i+1;
                }
            }
            while (sum>k){
                sum -= arr[i];
                i++;
            }
            j++;
        }
        return maxLen;
    }

    // Driver code
    public static void main(String args[])
    {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int n = arr.length;
        int k = 15;
        System.out.println("Length = " +
                lenOfLongSubarr(arr, k));
    }
}