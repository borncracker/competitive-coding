package dynamicProgramming;

public class Knapsack01 {
    public static int maxProfit(int[]wt, int[]profit, int n, int w){
        int[][]dp = new int[n+1][w+1];
        for(int i=0;i<=n;i++){
            for(int j=0; j<=w;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }else if(wt[i-1]<=j){
                    dp[i][j] = Math.max(profit[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }
    public static void main(String []args){
        int n =3;
        int w = 50;
        int [] wt = {10, 20, 30};
        int [] profit = {60, 100, 120};
        System.out.println(maxProfit(wt, profit, n, w));
    }
}
