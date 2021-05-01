package test;

import java.util.Arrays;

public class Candy {
    public static int candy(int[] ratings) {
        int length = ratings.length;
        int [] candy = new int[length];
        for(int i=0; i<length; i++)
            candy[i] = 1;
        for(int i=1; i< length; i++){
            if(ratings[i] > ratings[i-1])
                candy[i] =candy[i-1]+1;
        }
        for(int i=length-2;i>=0;i--){
            if(ratings[i] > ratings[i+1]){
                candy[i] = Math.max(candy[i], candy[i+1]+1);
            }
        }
        return Arrays.stream(candy).sum();
    }
    public static void main(String []args){
        int [] ratings ={1,3,4,5,2};
        System.out.println(candy(ratings));
    }
}
