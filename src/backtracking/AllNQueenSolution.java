package backtracking;

import java.util.ArrayList;
import java.util.List;

public class AllNQueenSolution {
    static List<List<Integer>> result = new ArrayList<>();
    public static void printAll(int n){
        int[][]mat = new int[n][n];
        List<Integer> list = new ArrayList<>();
        printUtil(mat, 0, list);
    }
    public static void printUtil(int[][]mat, int row, List<Integer> list){
        if(row == mat.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i< mat.length;i++){
            if(isValid(mat, row, i)){
                list.add(i);
                mat[row][i] = 1;
                printUtil(mat, row+1, list);
                mat[row][i] = 0;
                list.remove((Integer)i);
            }
        }
    }
    public static boolean isValid(int[][]mat, int row, int col){
        if(row>= mat.length || row <0 || col < 0 || col >= mat[0].length)
            return false;
        for(int i=0;i< mat.length;i++){
            if(mat[i][col]==1)
                return false;
        }
        for(int i=0;i< mat[0].length;i++){
            if(mat[row][i]==1)
                return false;
        }
        int i=row, j=col;
        while(i>=0 && j>=0){
            if(mat[i--][j--]==1)
                return false;
        }
        i=row;
        j=col;
        while(i>=0 && j< mat[0].length){
            if(mat[i--][j++]==1)
                return false;
        }
        return true;
    }

    public static void main(String[]args){
        int n=4;
        printAll(n);
        result.forEach(list -> {
            list.forEach(x-> System.out.print(x + " -> "));
            System.out.println();
        });
    }
}
