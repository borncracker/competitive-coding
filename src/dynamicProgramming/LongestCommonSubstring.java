package dynamicProgramming;

public class LongestCommonSubstring {
    public static int maxLength(String a, String b){
        int m = a.length(), n = b.length();
        int max = Integer.MIN_VALUE;
        int [][]dp = new int[m+1][n+1];
        for(int i=0;i<=m; i++){
            for(int j=0; j<= n; j++){
                if(i==0|| j==0){
                    dp[i][j] = 0;
                }else if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    if(max < dp[i][j])
                        max = dp[i][j];
                }else{
                    dp[i][j]=0;
                }
            }
        }
        return max;
    }
    public static void main(String []args){
        String a ="abcdef";
        String b = "abdef";
        System.out.println(maxLength(a,b));
    }
}
