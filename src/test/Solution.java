package test;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<String> simplifiedFractions(int n) {
        List<String> list = new ArrayList<>();
        for(int i=1;i<n;i++){
            fraction(list, i, n);
        }
        return list;
    }
    public static void fraction(List<String> list, int nr, int num){
        for(int i=2;i<=num; i++){
            if(nr == 1 || i%nr != 0)
                list.add(""+nr+"/"+i);
        }

    }

    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }
    public static void main(String[]args){
        simplifiedFractions(4).forEach(x -> System.out.println(x));

    }
}
