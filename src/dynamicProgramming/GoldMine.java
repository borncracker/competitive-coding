package dynamicProgramming;

public class GoldMine {
    public static int [][]dp;
    static int m;
    static int n;
    public static int getMaxGold(int[][]gold, int i, int j){
        if(dp[i][j] != -1)
            return dp[i][j];
        if(j==m-1){
            return gold[i][j];
        }
        int up = i-1 >=0? dp[i-1][j+1] !=-1? dp[i-1][j+1] : getMaxGold(gold,i-1,j+1):0;
        int down = i+1 <m? dp[i+1][j+1] != -1 ? dp[i+1][j+1]:getMaxGold(gold,i+1, j+1):0;
        int left = dp[i][j+1] != -1 ? dp[i][j+1]:getMaxGold(gold, i,j+1);
        return gold[i][j] + Math.max(up,Math.max(down, left));

    }
    //driver code
    public static void main(String arg[])
    {
        int gold[][]= {
                {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}
        };

        m = 4;
        n = 4;
        dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0; j <n; j++){
                dp[i][j] = -1;
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<m;i++){
            int sum = getMaxGold(gold, i, 0);
            if(ans < sum)
                ans = sum;
        }
        System.out.print(ans);
    }
}
