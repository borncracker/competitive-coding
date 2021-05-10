package string;

public class MultiplyLargeNumber {
    public static String multiply(String s1, String s2){
        String temp1 = s1, temp2 = s2;
        if(temp1.charAt(0)=='-'){
            temp1 = temp1.substring(1);
        }
        if(temp2.charAt(0)=='-'){
            temp2 = temp2.substring(1);
        }
        int m=temp1.length()-1;
        int n = temp2.length()-1;
        int[] resultArray = new int[m+n+1];
        for (int i=n;i>=0;i--){
            for (int j=m;j>=0;j--){
                resultArray[i+j] += (temp1.charAt(j)-'0')*(temp2.charAt(i)-'0');
            }
        }
        int carry=0;
        int i;
        for (i=resultArray.length-1;i >0 ;i--){
           int value = (carry+resultArray[i])%10;
           carry = (carry+resultArray[i])/10;
           resultArray[i]=value;
        }
        resultArray[i] = carry+resultArray[i];
        String resultString= "";
        for (i= resultArray.length-1;i>=0;i--){
            resultString = resultArray[i] + resultString;
        }

        if(s1.charAt(0)=='-'&& s2.charAt(0)=='-'){
            return resultString;
        }else if(s1.charAt(0)=='-'||s2.charAt(0)=='-'){
            return '-'+resultString;
        }
        return resultString;
    }
    public static void main(String[]args){
        String num1 = "654154154151454545415415454",
        num2 = "63516561563156316545145146514654";
        System.out.println(multiply(num1,num2));
    }
}
