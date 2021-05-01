package dynamicProgramming;

public class PrintLCS {
    public static String print(String a, String b){
        int m = a.length(), n = b.length();
        int dp[][] = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i == 0|| j==0){
                    dp[i][j]= 0;
                }else if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        String str ="";
        int i=m,j=n;
        while(i>0 &&j>0){
            if(a.charAt(i-1) == b.charAt(j-1)){
                str = a.charAt(i-1) + str;
                i--;
                j--;
            }else if(dp[i-1][j] > dp[i][j-1]) {
                i--;
            }
            else {
                j--;
            }
        }
        return str;
    }
    public static void main(String []args){
        String a = "geek";
        String b = "eks";
        System.out.println(print(a,b));
    }
}
