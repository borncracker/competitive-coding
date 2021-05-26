package string;

public class LeftAndRightRotation {
    public static void swap(char[] chars, int i, int j){
        char ch = chars[i];
        chars[i]= chars[j];
        chars[j]=ch;
    }
    public static int gcd(int a, int b){
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
    public static String leftRotate(String str, int d){
        int n = str.length();
        char []chars = str.toCharArray();
        d = d%n;
        for (int i=0;i<gcd(n,d);i++){
            int j=i;
            char temp = chars[i];
            while (true){
                int k = j+d;
                if(k>=n){
                    k=k-n;
                }
                if(k==i){
                    break;
                }
                swap(chars,j,k);
                j=k;
            }
            chars[j]=temp;
        }
        return String.valueOf(chars);
    }
    public static String rightRotate(String str, int d){
        return leftRotate(str,str.length()-d);
    }
    public static void main(String[]args){
        String str1 = "GeeksforGeeks";
        System.out.println(leftRotate(str1, 2));

        String str2 = "GeeksforGeeks";
        System.out.println(rightRotate(str2, 2));
    }
}
