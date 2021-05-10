package matrix;
// Java program to find the size of the largest '+'
// formed by all 1's in given binary matrix

import java.io.*;

class LargestPlus {

    // size of binary square matrix
    static int N = 4;

    // Function to find the size of the largest '+'
    // formed by all 1's in given binary matrix
    static int findLargestPlus(int mat[][])
    {

        // left[j][j], right[i][j], top[i][j] and
        // bottom[i][j] store maximum number of
        // consecutive 1's present to the left,
        // right, top and bottom of mat[i][j]
        // including cell(i, j) respectively
        int left[][] = new int[N][N];
        int right[][] = new int[N][N];
        int top[][] = new int[N][N];
        int bottom[][] = new int[N][N];

        // initialize above four matrix
        for (int i = 0; i < N; i++) {

            // initialize first row of top
            top[0][i] = mat[0][i];

            // initialize last row of bottom
            bottom[N - 1][i] = mat[N - 1][i];

            // initialize first column of left
            left[i][0] = mat[i][0];

            // initialize last column of right
            right[i][N - 1] = mat[i][N - 1];
        }

        // fill all cells of above four matrix
        for (int i = 1; i < N-1; i++) {
            for (int j = 1; j < N-1; j++) {

                // calculate left matrix
                // (filled left to right)
                if (mat[i][j] == 1)
                    left[i][j] = left[i][j - 1] + 1;
                else
                    left[i][j] = 0;

                // calculate top matrix
                if (mat[i][j] == 1)
                    top[i][j] = top[i - 1][j] + 1;
                else
                    top[i][j] = 0;

                // calculate new value of j to
                // calculate value of bottom(i, j)
                // and right(i, j)
                // as we are populating the bottom matrix from bottom i.e n-1 and
                // right matrix from right i,e n-1
                j = N - 1 - j;
                i = N - 1 - i;
                // calculate bottom matrix
                if (mat[i][j] == 1)
                    bottom[i][j] = bottom[i + 1][j] + 1;
                else
                    bottom[i][j] = 0;

                // calculate right matrix
                if (mat[i][j] == 1)
                    right[i][j] = right[i][j + 1] + 1;
                else
                    right[i][j] = 0;

                // revert back to old j
                j = N - 1 - j;
                i = N - 1 - i;
            }
        }

        // n stores length of longest + found so far
        int n = 0;

        // compute longest +
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // find minimum of left(i, j),
                // right(i, j), top(i, j),
                // bottom(i, j)
                int len = Math.min(Math.min(top[i][j],
                        bottom[i][j]),Math.min(left[i][j],
                        right[i][j]));

                // largest + would be formed by a
                // cell that has maximum value
                if (len > n)
                    n = len;
            }
        }

        // 4 directions of length n - 1 and 1 for
        // middle cell
        if (n > 0)
            return 4 * (n - 1) + 1;

        // matrix contains all 0's
        return 0;
    }

    /* Driver function to test above functions */
    public static void main(String[] args)
    {

        // Binary Matrix of size N
        int mat[][] = {
                { 0, 0, 1, 0},
                { 0, 1, 1, 1},
                { 0, 0, 1, 1},
                { 1, 1, 0, 1}
        };
        System.out.println(findLargestPlus(mat));
    }
}

// This code is contributed by vt_m.
