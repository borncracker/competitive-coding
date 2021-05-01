package test;

import java.util.HashMap;
import java.util.Map;

public class PickToysSlidingWindow {
    public static int calculate(String str){
        int i=0,j=0;
        int longest = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(j<str.length()){
            char key = str.charAt(j);
            if(map.containsKey(key)){
                int value = map.get(key)+1;
                map.put(key, value);
            }else{
                map.put(key,1);
            }
            if(map.size()==2){
                if(longest<j-i+1){
                    longest = j-i+1;
                }
            }else if(map.size()>2){
                while (map.size() > 2){
                    char ch = str.charAt(i);
                    int value = map.get(ch)-1;
                    if(value==0){
                        map.remove(ch);
                    }else{
                        map.put(ch,value);
                    }
                    i++;
                }
            }
            j++;
        }
        return longest;
    }
    public static void main(String[] args){
        String str = "abdacfdcab";
        System.out.println(calculate(str));
    }
}
