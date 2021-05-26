package tree;

public class DepthFromPreOrder {
    public static int height(String str){
        int p=-1;
        int count =0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='n'){
                if(i-p <= 2){
                    count++;
                    p=i;
                }else{
                    p=i;
                }
            }
        }
        return count;
    }
    public static void main(String[]args){
        String tree = "nlnnlll";
        System.out.println(height(tree));
    }
}
