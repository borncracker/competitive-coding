package matrix;

public class RotateAMatrixBy180 {
    public static void reverseColWise(int[][]mat){
        for(int col=0; col< mat[0].length;col++){
            for(int row=0,k= mat.length-1; row < k;row++, k--){
                int temp = mat[row][col];
                mat[row][col]=mat[k][col];
                mat[k][col] = temp;
            }
        }
    }
    public static void reverseRowWise(int[][]mat){
        for(int i=0;i< mat.length;i++){
            for(int j=0, k= mat[0].length-1;j<k;j++,k--){
                int temp = mat[i][j];
                mat[i][j] = mat[i][k];
                mat[i][k] = temp;
            }
        }
    }
    // Function for print matrix
    static void printMatrix(int arr[][])
    {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length;
                 j++)
                System.out.print(arr[i][j] + " ");
            System.out.println("");
        }
    }
    public static void main(String[]args){
        int[][] mat = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        reverseRowWise(mat);
        reverseColWise(mat);
        printMatrix(mat);
    }
}
