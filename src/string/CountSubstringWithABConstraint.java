package string;

public class CountSubstringWithABConstraint {
    public static int count(int n, int b, int c){
        int sum=0;
        int[]fact = new int[n+1];
        fact[0] = 1;
        for (int i=1;i<=n;i++){
            fact[i] = fact[i-1]*i;
        }
        for (int i=0;i<=b;i++){
            for(int j=0;j<=c && (j+i)<=n;j++){
                int k = n - (i+j);
                sum += fact[n]/(fact[i]*fact[j]*fact[k]);
            }
        }
        return sum;
    }
    public static void main (String[] args)
    {
        int n = 3; // Total number of characters
        System.out.println(count(n, 1, 2));
    }
}
