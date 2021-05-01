package test;

public class ReverseStringUsingRecursion {
    public static String reverse(String str){
        if(str.length()==1){
            return str;
        }else{
            return reverse(str.substring(str.length()-1)) + reverse(str.substring(0,str.length()-1));
        }
    }
    public static void main(String[] args){
        System.out.println(reverse("abcdef"));
    }
}
