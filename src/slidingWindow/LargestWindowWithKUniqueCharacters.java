package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LargestWindowWithKUniqueCharacters {
    public static String getLargestWindow(String str, int k){
        int i=0,j=0,count=0,start=-1,end=-1, max=Integer.MIN_VALUE;
        Map<Character,Integer> map = new HashMap<>();
        while (j<str.length()){
            char ch = str.charAt(j);
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            }else{
                map.put(ch,1);
            }
            if(map.size()==k){
                if(max < j-i+1){
                    max = j-i+1;
                    start = i;
                    end=j+1;
                }
            }
            while (map.size()>k){
                char prev = str.charAt(i);
                int val = map.get(prev);
                if(val ==1){
                    map.remove(ch);
                }else{
                    map.put(ch,val-1);
                }
                i++;
            }
            j++;
        }
        return str.substring(start,end);
    }
    public static void main(String[]args){
        String str = "abcbaad";
        int k=3;
        System.out.println(getLargestWindow(str,k));
    }
}
