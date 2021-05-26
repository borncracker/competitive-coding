package string;

public class RemoveConsecutiveVowels {
    public static boolean isVowel(char ch){
        switch (ch){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
        }
        return false;
    }
    public static String getString(String input){
        String result = "";
        for (int i=0;i<input.length();i++){
            char ch = input.charAt(i);
            result += ch;
            if(isVowel(ch)){
                while (i<input.length() && isVowel(input.charAt(i+1)))
                    i++;
            }
        }
        return result;
    }
    // Driver Code
    public static void main(String[] args)
    {
        String str = "geeks for geeks";
        System.out.println(getString(str));
    }
}
