package string;

public class DifferenceOfTwoLargeNumber {
    public static String diff(String s1, String s2){
        if(s1.length()<s2.length()){
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }
        int carry =0;
        int m = s1.length();
        int n = s2.length();
        String result="";
        for (int i=m-1,j=n-1; i>=0 && j>=0; i--,j--){
            if((s1.charAt(i)-'0' + carry)< s2.charAt(j)-'0'){
                result = (carry + ((10+s1.charAt(i))-'0')-(s2.charAt(j)-'0'))+result;
                carry = -1;
            }else{
                result = (carry + (s1.charAt(i)-'0') - (s2.charAt(j)-'0'))+result;
                carry =0;
            }
        }
        for (int i=m-n-1;i>=0;i--){
            if(carry + (s1.charAt(i)-'0') < 0){
                result = '9'+result;
                carry = -1;
            }else{
                result = carry + (s1.charAt(i)-'0')+result;
                carry = 0;
            }
        }
        return result;
    }
    public static void main(String[]args){
        String str1 = "11443333311111111100",
                str2 =     "1144422222221111";
        System.out.println(diff(str1,str2));
    }
}
