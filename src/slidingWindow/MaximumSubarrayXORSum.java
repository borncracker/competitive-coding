package slidingWindow;

public class MaximumSubarrayXORSum {
    public static int getMax(int[]arr){
        int sum=0, maxSum=0;
        for(int i=0;i<arr.length;i++){
            if(sum<0){
                sum=0;
            }
            sum ^=arr[i];
            if(maxSum < sum){
                maxSum = sum;
            }
        }
        return maxSum;
    }
    public static void main(String[]args){
        int arr[] = {8, 1, 2, 12};
        System.out.println("Max subarray XOR is " +
                getMax(arr));
    }
}
