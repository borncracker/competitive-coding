package dynamicProgramming;

public class SubsetSum {
    public static boolean hasSubSet(int[] set, int sum, int n){
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(j==0){
                    dp[i][j]=true;
                }else if(i==0) {
                    dp[i][j] = false;
                }else {
                    if (j >= set[i - 1]) {
                        dp[i][j] = dp[i - 1][j - set[i - 1]] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[n][sum];
    }
    public static void main(String [] args){
        int []set = {2,6,9,7};
        int w = 8;
        int n = 4;
        System.out.println(hasSubSet(set, w, n));
    }
}
