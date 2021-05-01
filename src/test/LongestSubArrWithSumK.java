package test;

public class LongestSubArrWithSumK {
    public static int max(int[]arr, int k){
        int i=0,j=0,sum=0;
        int maxLength=Integer.MIN_VALUE;
        while(j<arr.length){
            sum +=arr[j];
            if(sum == k){
                if(maxLength < j-i+1){
                    maxLength = j-i+1;
                }
            }else {
                while (sum > k){
                    sum -=arr[i];
                    i++;
                }
            }
            j++;
        }
        return maxLength;
    }
    public static void main(String[]args){
        int[]arr = {10, 5, 2, 7, 1, 9};
        System.out.println(max(arr, 15));
    }
}
