package string;

public class CountSubStringWithKDistinctChar {
    public static int mostK(String s, int k){
        //Map<Character,Integer> map = new HashMap<>();
        int map[] =  new int[256];
        int right = 0, unique = 0, res = 0;

        for(int left = 0; left < s.length()-k+1; left++){
            if(left > 0){
                char ch = s.charAt(left-1);
                map[s.charAt(left-1)]--;
                if(map[s.charAt(left-1)] == 0) unique--;
            }

            while(unique <= k && right < s.length()){
                if(map[s.charAt(right)] == 0) unique++;
                if (unique > k){
                    unique--;
                    right--;
                    break;
                }
                map[s.charAt(right)]++;
                right++;
            }

            if(right < s.length()) {
                res += right - left;
            } else {
                if(unique >= k){
                    right--;
                    res += right - left;
                }
            }
        }
        return res;
    }
    public static void main(String[]args){
        String ch = "abcbaa";
        int k = 3;
        System.out.println("Total substrings with exactly " +
                k +    " distinct characters : "
                + mostK(ch, k));
    }
}
