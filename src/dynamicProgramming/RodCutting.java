package dynamicProgramming;

public class RodCutting {
    public static int maxProfit(int n, int w, int []length, int[]profit){
        int[][]dp = new int[n+1][w+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=w; j++){
                if(i==0||j==0){
                    dp[i][j] = 0;
                }else if(length[i-1] <= j){
                    dp[i][j] =  Math.max(profit[i-1] + dp[i][j-length[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }
    public static void main(String[]args){
        int[]price = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int[]length = {1,2,3,4,5,6, 7, 8};
        int w =8;
        System.out.println(maxProfit(length.length, w, length, price));
    }
}
