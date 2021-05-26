package slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SmallestWinWithAllCharacterAndDistinct {
    public static String getSmallestWin(String str){
        int i=0,j=0,count=0,start=-1,end=-1, min=Integer.MAX_VALUE;
        Map<Character,Integer> map = new HashMap<>();
        for (int k =0;k<str.length();k++){
            if(!map.containsKey(str.charAt(k))){
                map.put(str.charAt(k),1);
                count++;
            }
        }
        while (j < str.length()){
            //System.out.println("i: "+i+" j: "+j+" pre: "+str.charAt(i)+" ch: "+str.charAt(j)+" Map: "+map+" count: "+count+" start: "+start+" end: "+end+" min: "+min);
            char ch = str.charAt(j);
            if(map.containsKey(ch)){
                int val =map.get(ch);
                if(val==1){
                    count--;
                }
                map.put(ch,val-1);
            }
            while(count==0){
                char prev = str.charAt(i);
                if(min >j-i+1){
                    min = j-i+1;
                    start =i;
                    end =j;
                }
                if(map.containsKey(prev)){
                    int val = map.get(prev);
                    if(val==0){
                        count++;
                    }
                    map.put(prev,val+1);
                }
                i++;
            }
            j++;
        }
        return str.substring(start,end+1);
    }
    public static void main(String[]args){
        String str = "aabcbcdbca";
        System.out.println("Smallest window containing all distinct"+
                " characters is: "+ getSmallestWin(str)) ;
    }
}
