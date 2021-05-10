package rangeQueries;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RangeFrequencySegmentTree {
    public static Map<Integer, Integer> construct(int[]arr, Map<Integer, Integer>[]st, int si, int sl, int sr){
        if(sl==sr){
            Map<Integer, Integer> map = new HashMap();
            st[si]= map;
            map.put(arr[sl],1);
            return map;
        }
        int mid = sl + (sr-sl)/2;
        Map<Integer, Integer> map1 = construct(arr, st, 2*si+1, sl, mid);
        Map<Integer, Integer> map2 = construct(arr, st, 2*si+2, mid+1, sr);
        Map<Integer, Integer> mergedMap = new HashMap();
        for(Map.Entry<Integer, Integer> entry : map1.entrySet()){
            if(mergedMap.containsKey(entry.getKey()))
                mergedMap.put(entry.getKey(),mergedMap.get(entry.getKey()) + entry.getValue());
            else
                mergedMap.put(entry.getKey(), entry.getValue());
        }
        for(Map.Entry<Integer, Integer> entry : map2.entrySet()){
            if(mergedMap.containsKey(entry.getKey()))
                mergedMap.put(entry.getKey(),mergedMap.get(entry.getKey()) + entry.getValue());
            else
                mergedMap.put(entry.getKey(), entry.getValue());
        }
        st[si] = mergedMap;
        return mergedMap;
    }
    public static int query(Map<Integer, Integer>[]st, int si, int sl, int sr, int l, int r, int k){
        if(l>sr || r <sl){
            return 0;
        }
        if(sl>=l && sr<=r){
            return Objects.nonNull(st[si].get(k))?st[si].get(k):0;
        }
        int mid = sl + (sr-sl)/2;
        return query(st, 2*si+1, sl, mid, l, r, k) + query(st, 2*si+2, mid+1, sr, l, r, k);
    }
    public static void main(String[]args){
        int arr[] = {2, 8, 6, 9, 8, 6, 8, 2, 11};
        int n = arr.length;
        Map<Integer, Integer> [] st = new Map[2*n+1];
        construct(arr,st, 0, 0, n-1);

        // Print frequency of 2 from position 1 to 6
        System.out.println("Frequency of 2 from 1 to 6 = "
                + query(st, 0, 0,n-1,1, 6, 2));

        // Print frequency of 8 from position 4 to 9
        System.out.println("Frequency of 8 from 4 to 9 = "
                + query(st, 0, 0,n-1,4, 9, 8));
    }
}
