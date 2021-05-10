package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPathInMatrix {
    static List<Integer> list = new ArrayList<>();
    public static void fun(int[][]mat, int row, int col){
        if(row== mat.length-1 && col == mat[0].length-1){
            list.forEach((x) -> System.out.print(x + " -> "));
            System.out.println(mat[row][col]);
            return;
        }
        list.add(mat[row][col]);
        if(col+1 < mat[0].length)
            fun(mat, row, col +1);
        if(row+1 < mat.length){
            fun(mat, row+1, col);
        }
        list.remove((Integer)mat[row][col]);
    }
    public static void main(String []args){
        int m = 2;
        int n = 3;
        int mat[][] = {
                { 1, 2, 3 },
                { 4, 5, 6 } };
        int maxLengthOfPath = m + n - 1;
        fun(mat, 0, 0);
    }
}
