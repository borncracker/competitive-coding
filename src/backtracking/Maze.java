package backtracking;

import java.util.Scanner;

public class Maze {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        System.out.println("Row: " + row + " Col: " + col);
        char[][] board = new char[row][col];
        for (int i = 0; i < row && scanner.hasNextLine(); i++) {
            String str = scanner.nextLine();
            for(int j = 0;j<str.length();j++)
            {
                board[i][j] = str.charAt(j);
            }
        }
        System.out.println(board.length);
        System.out.println(board[0].length);
        for(int i=0; i < row;i++){
            for(int j=0;j<col;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        int steps = calculate(board);
        System.out.println(steps ==-1?"DOOMED":steps);
    }
    public static int calculate(char[][]board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 'S'){
                    return solve(board, i, j, 0);
                }
            }
        }
        return -1;
    }
    static int[]rowMove ={-1,0, 1, 0};
    static int[]colMove ={0,-1, 0, 1};
    public static int solve(char[][]board, int row, int col, int step){
        if(isInvalid(board,row,col))
            return -1;
        if(board[row][col] == 'T')
            return step;
        for(int i=0;i<rowMove.length;i++){
            int newRow = row + rowMove[i];
            int newCol = col + colMove[i];
            char temp = board[row][col];
            board[row][col] = '#';
            int step1 = solve(board, newRow, newCol, step+1);
            if(step1!= -1){
                board[row][col] = temp;
                return step1;
            }
            board[row][col] = temp;
        }
        return -1;
    }
    public static boolean isInvalid(char[][]board, int row, int col){
        if(row>=board.length || row<0 || col >= board[0].length || col < 0 || board[row][col]=='#'){
            return true;
        }
        return false;
    }
}