package matrix;

public class RotateAMatrixBy90 {
    public static void rotate(int[][]mat){
        for(int i=0;i< mat.length;i++){
            for(int j=i+1;j< mat[0].length;j++){
                int temp = mat[j][i];
                mat[j][i] = mat[i][j];
                mat[i][j] = temp;
            }
        }
        for(int i=0;i< mat.length;i++){
            for(int j=0,k= mat[0].length-1;j<k;j++,k--){
                int temp = mat[i][j];
                mat[i][j]=mat[i][k];
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
        int arr[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        rotate(arr);
        printMatrix(arr);
    }
}
