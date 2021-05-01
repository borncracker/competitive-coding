package test;

public class MaxSubArrK {
    public static int max(int[]arr,int k){
        int i=0;
        int j = k;
        int sum=0;
        for(int l=0;l<k;l++){
            sum+=arr[l];
        }
        int max = sum;
        for(;j<arr.length;j++,i++){
            sum-=arr[i];
            sum+= arr[j];
            if(sum > max)
                max = sum;
        }
        return max;
    }
    public static void main(String[] args){
        int [] arr = {2,3,1,6,2,3,2,3};
        int k=3;
        System.out.println(max(arr, k));
    }
}
