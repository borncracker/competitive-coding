package test;

import java.util.HashSet;
import java.util.Set;

public class LongestNonRepeatingCharacterSubString {
    public static int calculate(String str){
        int i=0;
        int j=0;
        int longest=0;
        Set<Character> set = new HashSet<>();
        while(j<str.length()){
            char ch = str.charAt(j);
            if(set.contains(ch)){
                if(longest < set.size())
                    longest = set.size();
                while (set.contains(ch)){
                    set.remove(str.charAt(i));
                    i++;
                }
            }else{
                set.add(ch);
            }
            j++;
        }
        return longest;
    }
    public static void main(String[]args){
        String str = "abcdbefghbcd";
        System.out.println(calculate(str));
    }
}
