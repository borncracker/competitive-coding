package test;

public class StockSaleWithTwoTransactions {
    public static int getMaxProfit(int[]arr){
        int n = arr.length;
        int profit[] =new int[n];
        int max = arr[n-1];
        int startIdx1 = n-1;
        int endIdx1 = n-1;
        int temp_end = n-1;
        int min = arr[0];
        int startIdx2 =0;
        int endIdx2=0;
        int temp_start = 0;
        for(int i=n-2; i>=0;i--){
            if(max < arr[i]){
                max = arr[i];
                temp_end=i;
            }
            if(profit[i+1]>= max -arr[i]){
                profit[i] = profit[i+1];
            }else{
                profit[i] = max - arr[i];
                startIdx1 = i;
                endIdx1 = temp_end;
            }
        }
        for(int i=1; i<n;i++){
            if(arr[i] < min){
                min = arr[i];
                temp_start=i;
            }
            if(profit[i-1] >= profit[i]+arr[i]-min){
                profit[i] = profit[i-1];
            }else{
                profit[i] += arr[i]-min;
                endIdx2 =i;
                startIdx2 = temp_start;
            }
        }
        System.out.println("Txn1: " + startIdx2 + " - " + endIdx2);
        System.out.println("Txn2: " + startIdx1 + " - " + endIdx1);
        return profit[n-1];
    }
    public static void main(String[]args){
        int []arr = {10, 22, 5, 75, 65, 80};
        System.out.println(getMaxProfit(arr));
    }
}
