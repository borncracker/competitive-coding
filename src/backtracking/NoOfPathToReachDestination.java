package backtracking;

public class NoOfPathToReachDestination {
    public int uniquePaths(int m, int n) {
        char mat[][] = new char[m][n];
        mat[m - 1][n - 1] = 'D';
        return solve(mat, 0, 0);
    }

    public int solve(char[][] board, int row, int col) {
        if (isInvalid(board, row, col)) {
            return 0;
        }
        if (board[row][col] == 'D') {
            return 1;
        }
        return solve(board, row, col + 1) + solve(board, row + 1, col);
    }

    public boolean isInvalid(char[][] board, int row, int col) {
        if (row >= board.length || row < 0 || col >= board[0].length || col < 0)
            return true;
        return false;
    }
    public static void main(String[]args){
        int m =3,n=2;
        NoOfPathToReachDestination noOfPathToReachDestination = new NoOfPathToReachDestination();
        System.out.println(noOfPathToReachDestination.uniquePaths(m,n));
    }
}