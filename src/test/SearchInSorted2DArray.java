package test;

public class SearchInSorted2DArray {
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString(){
            return "X: " + x + " Y: " + y;
        }
    }
    public static Pair getIndex(int[][]arr, int k){
        int i = 0,j = arr[0].length-1;
        while(i < arr.length && j >= 0){
            if(arr[i][j] == k)
                return new Pair(i,j);
            else if(k < arr[i][j]){
                j--;
            }else
                i++;
        }
        return null;
    }
    public static void main(String[]args){
        int[][]arr ={
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };
        System.out.println(getIndex(arr,29));
        int[][]arr1 ={
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 28, 37, 48},
                {32, 33, 39, 50}
        };
        System.out.println(getIndex(arr1,29));
    }
}
