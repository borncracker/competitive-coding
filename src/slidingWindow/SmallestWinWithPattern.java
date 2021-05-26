package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SmallestWinWithPattern {
    public static String findSubString(String text, String pat){
        int i=0,j=0;
        int count =0;
        int min =Integer.MAX_VALUE;
        int start =-1,end=-1;
        Map<Character, Integer> map = new HashMap<>();
        for (int k=0;k<pat.length();k++){
            char key = pat.charAt(k);
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else {
                map.put(key, 1);
                count++;
            }
        }
        while (j<text.length()){
            char ch = text.charAt(j);
            if(map.containsKey(ch)){
                int val = map.get(ch);
                if(val==1)
                    count--;
                map.put(ch,val-1);
            }
           // System.out.println("count: "+ count+ " i: "+ i+ " j: "+ j +" prev: "+prev+ " ch: "+ch + " Map:" + map+ " Start: "+ start + " End: "+end+ " Min: "+ min);

            while (count==0){
                char prev = text.charAt(i);
                if(min > (j-i+1)){
                    min = (j-i+1);
                    start = i;
                    end = j;
                }
                if(map.containsKey(prev)){
                    int val = map.get(prev);
                    if(val==0)
                        count++;
                    map.put(prev,val+1);
                }
                i++;
            }
            j++;
        }
        return text.substring(start,end+1);
    }
    public static void main(String[]args){
        String str = "this is a test string";
        String pat = "tist";

        System.out.print("Smallest window is :\n "
                + findSubString(str, pat));
    }
}
