package matrix;

public class RotateAMatrix {
    public static void rotate(int[][]mat){
        int top = 0, bottom = mat.length-1;
        int left = 0, right = mat[0].length-1;
        while (top<bottom && left<right){
            int row = top, col = left;
            int prev = mat[row+1][col];
            while (col <= right){
                int temp = mat[row][col];
                mat[row][col] = prev;
                prev = temp;
                col++;
            }
            top++;
            col--;
            row++;
            while (row <= bottom){
                int temp = mat[row][col];
                mat[row][col] = prev;
                prev = temp;
                row++;
            }
            row--;
            col--;
            right--;
            while (col >= left){
                int temp = mat[row][col];
                mat[row][col] = prev;
                prev = temp;
                col--;
            }
            row--;
            col++;
            bottom--;
            while (row >= top){
                int temp = mat[row][col];
                mat[row][col] = prev;
                prev = temp;
                row--;
            }
            left++;
        }
    }
    public static void main(String[]args){
        // Test Case 1
        int a[][] = { {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 16} };
        rotate(a);
        for(int i=0;i< a.length;i++){
            for(int j=0;j<a[0].length;j++)
                System.out.print(a[i][j]+"  ");
            System.out.println();
        }
    }
}
