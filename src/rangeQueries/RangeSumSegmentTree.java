package rangeQueries;

public class RangeSumSegmentTree {
    public static int construct(int[]arr, int[]st, int si, int sl, int sr){
        if(sl==sr){
            st[si]=arr[sl];
            return arr[sl];
        }
        int mid = sl +(sr-sl)/2;
        st[si]= construct(arr, st, 2*si+1, sl, mid)+construct(arr, st, 2*si+2, mid+1, sr);
        return st[si];
    }
    public static void update(int[]st, int si, int sl, int sr, int pos, int diff){
        if(pos<sl ||pos>sr){
            return;
        }
        if(pos>=sl && pos<=sr){
            st[si] +=diff;
        }
        int mid = sl + (sr-sl)/2;
        update(st, 2*si+1, sl, mid, pos, diff);
        update(st, 2*si+2, mid+1, sr, pos, diff);
    }
    public static int query(int[]st, int si, int sl, int sr, int l, int r){
        if(l >sr || r < sl){
            return 0;
        }
        if(sl>=l && sr<=r){
            return st[si];
        }
        int mid = sl+(sr-sl)/2;
        return query(st, 2*si+1, sl, mid, l, r) + query(st, 2*si+2, mid+1, sr, l, r);
    }
    public static void main(String[]args){
        int arr[] = { 3, 7, 2, 5, 8, 9 };
        int n = arr.length;
        int st[] =  new int[2*n+1];
        construct(arr, st, 0, 0, n-1);

        System.out.println(query(st, 0, 0, n-1, 0, 5));
        System.out.println(query(st, 0, 0, n-1,3, 5));
        System.out.println(query(st, 0, 0, n-1,2, 4));
    }
}
