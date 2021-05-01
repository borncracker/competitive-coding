package test;

import java.util.HashMap;
import java.util.Map;

public class CountAnagram {
    public static int count(String str, String pattern){
        int k =pattern.length();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<k;i++ ){
            if(map.containsKey(pattern.charAt(i))){
                map.put(pattern.charAt(i),map.get(pattern.charAt(i))+1);
            }
            else{
                map.put(pattern.charAt(i),1);
            }
        }
        int count = map.size();
        int i =0;
        int j =0;
        int result =0;
        while (j < str.length()){
            if(map.containsKey(str.charAt(j))){
                char key = str.charAt(j);
                int value = map.get(key)-1;
                map.put(key,value);
                if(value == 0)
                    count--;
            }
            if(j-i+1 < k)
                j++;
            else if(j-i+1 == k){
                if(count==0){
                    result++;
                }
                if(map.containsKey(str.charAt(i))){
                    char key = str.charAt(i);
                    int value = map.get(key)+1;
                    map.put(key,value);
                    if(count == 0)
                        count++;
                }
                i++;
                j++;
            }
        }
        return result;
    }
    public static void main(String[] args){
        String str = "aabaabaab";
        String pattern = "aaba";
        System.out.println(count(str,pattern));
    }
}
