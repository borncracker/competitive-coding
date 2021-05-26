package string;

public class PermuationOfString {
    public static String swap(String str, int i, int j){
        char[]chars = str.toCharArray();
        char temp = chars[i];
        chars[i]= chars[j];
        chars[j] = temp;
        return String.valueOf(chars);
    }
    public static void permute(String str, int ind){
        if (ind == str.length()-1){
            System.out.println(str);
            return;
        }
        for (int i=ind;i<str.length();i++){
            String str1 = swap(str,ind,i);
            permute(str1,ind+1);
        }
    }
    public static void main(String[] args)
    {
        String str = "ABC";
        int n = str.length();
        permute(str, 0);
    }
}
