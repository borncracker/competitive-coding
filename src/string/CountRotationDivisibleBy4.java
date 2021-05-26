package string;

public class CountRotationDivisibleBy4 {
    public static int countDivisibility(String str){
        int n = str.length();
        int count =0;
        if(n==1){
            if((str.charAt(0)-'0')%4==0)
                count++;
        }else{

            for(int i=0;i<n-1;i++){
                int pair = (str.charAt(i)-'0')*10 + (str.charAt(i+1)-'0');
                if(pair%4==0)
                    count++;
            }
            int pair = (str.charAt(n-1)-'0')*10 + (str.charAt(0)-'0');
            if(pair%4==0)
                count++;
        }
        return count;
    }
    //Driver program
    public static void main(String args[])
    {
        String n = "4834";
        System.out.println("Rotations: " +
                countDivisibility(n));
    }
}
