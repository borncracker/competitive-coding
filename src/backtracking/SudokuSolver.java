package backtracking;

public class SudokuSolver {
    public static void print(
            int[][] board, int N)
    {

        // We got the answer, just print it
        for (int r = 0; r < N; r++)
        {
            for (int d = 0; d < N; d++)
            {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % (int)Math.sqrt(N) == 0)
            {
                System.out.print("");
            }
        }
    }

    // Driver Code
    public static void main(String args[])
    {

        int[][] board = new int[][] {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
        int[][] board1 = new int[][] {
                { 3, 0, 6},
                { 5, 2, 0},
                { 0, 8, 7}
        };
        int N = board.length;

        if (solveSudoku(board, N))
        {
            // print solution
            print(board, N);
        }
        else {
            System.out.println("No solution");
        }
    }

    public static boolean solveSudoku(int [][]board, int n){
        return solveUtil(board,0,0);
    }

    public static boolean solveUtil(int[][]board, int row, int col){
        if(row == board.length-1 && col == board[0].length)
            return true;
        if(col>= board[0].length) {
            col = 0;
            row += 1;
        }
        if(board[row][col]==0) {
            for (int i = 1; i <= 9; i++) {
                if(!isInvalid(board,row, col, i)) {
                    board[row][col] = i;
                    if (solveUtil(board, row, col+1)) {
                        return true;
                    }
                }
            }
            board[row][col] = 0;
        }else{
            return solveUtil(board, row, col+1);
        }
        return false;
    }

    public static boolean isInvalid(int[][]board, int row, int col, int num){
        if(row >= board.length || row < 0 || col >= board[0].length || col < 0 )
            return true;
        for(int i=0;i<board.length;i++){
            if(i!=row && board[i][col] == num)
                return true;
        }
        for(int i=0;i<board.length;i++){
            if(i!=col && board[row][i] == num)
                return true;
        }
        // Corresponding square has
        // unique number (box-clash)
        int sqrt = (int)Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart;
             r < boxRowStart + sqrt; r++)
        {
            for (int d = boxColStart;
                 d < boxColStart + sqrt; d++)
            {
                if (board[r][d] == num)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
