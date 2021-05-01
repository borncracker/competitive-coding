package test;

import java.util.HashMap;
import java.util.Map;

public class MinWindowWithGivenCharacters {
    public static int calculate(String str, String pattern){
        int i=0;
        int j=0;
        int min = Integer.MAX_VALUE;
        int count =0;
        Map<Character,Integer> map = new HashMap<>();
        for(int k=0;k<pattern.length();k++){
            char key = pattern.charAt(k);
            if(map.containsKey(key)){
                int value = map.get(key)+1;
                map.put(key,value);
            }else {
                map.put(key,1);
            }
        }
        count =map.size();
        while(j<str.length()){
            char key = str.charAt(j);
            if(map.containsKey(key)){
                int value = map.get(key)-1;
                map.put(key,value);
                if(value == 0)
                    count--;
            }
            if(count ==0){
                if(min > j-i+1){
                    min = j-i+1;
                }
                while (count==0){
                    char ch = str.charAt(i);
                    if(map.containsKey(ch)){
                        int value = map.get(ch)+1;
                        map.put(ch,value);
                        if(value > 0){
                            count++;
                        }
                    }
                    if(min > j-i+1){
                        min = j-i+1;
                    }
                    i++;
                }
            }
            j++;
        }
        return min;
    }
    public static void main(String[]args){
        String str = "taboatcccbcabtbco";
        String ptr = "toc";
        System.out.println(calculate(str,ptr));
    }
}
