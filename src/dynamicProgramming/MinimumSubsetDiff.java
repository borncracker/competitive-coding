package dynamicProgramming;

import java.util.Arrays;

public class MinimumSubsetDiff {
    public static int minDiff(int[]set, int n){
        int sum = Arrays.stream(set).sum();
        boolean dp[][] = new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(j==0){
                    dp[i][j]= true;
                }else if(i==0){
                    dp[i][j] = false;
                }else if(set[i-1] <= j){
                    dp[i][j] = dp[i-1][j - set[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<=sum/2;i++){
            if(dp[n][i]){
                int temp = sum - 2* i;
                if(min > temp){
                    min =  temp;
                }
            }
        }
        return min;
    }

    public static void main(String []args){
        int []set = {2,3,5,7};
        System.out.println(minDiff(set,4));
    }
}
