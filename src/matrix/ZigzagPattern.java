package matrix;

// Java program to print matrix in diagonal order
class ZigzagPattern {
    static void printMatrixDiagonal(int mat[][])
    {
        boolean up = true;
        int i=0,j=0;
        int m = mat.length, n =mat[0].length;
        while (true){
            System.out.print(mat[i][j] + "  ");
            if(i== m-1 && j==n-1){
                break;
            }
            if(up && ((i-1)<0 || (j+1)>=n)){
                if(j+1 >=n){
                    i++;
                }else{
                    j++;
                }
                up =false;
                continue;
            }
            if(!up && ((j-1)<0 ||(i+1)>=m)){
                if(i+1 >= m){
                    j++;
                }else{
                    i++;
                }
                up=true;
                continue;
            }
            if(up){
                i--;
                j++;
            }else {
                j--;
                i++;
            }
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        int mat[][] = { { 1, 2, 3 },
                        { 4, 5, 6 },
                        { 7, 8, 9 } };
        printMatrixDiagonal(mat);
    }
}
