package queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NearestCellWith1 {
    public static class Point{
        int x;
        int y;
        int dist;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

    }
    static int[]X = {-1, 0, 1, 0};
    static int[]Y = { 0,-1, 0, 1};
    public static int[][] calc(int[][]mat){
        int m = mat.length, n = mat[0].length;
        int[][] dis = new int[m][n];
        for(int i=0;i< dis.length;i++){
            Arrays.fill(dis[i],Integer.MAX_VALUE);
        }
        Deque<Point> queue = new ArrayDeque<>();
        for(int i=0;i< mat.length;i++){
            for (int j=0;j< mat[0].length;j++){
                if(mat[i][j]==1){
                    dis[i][j]=0;
                    Point point = new Point(i,j);
                    point.dist =0;
                    queue.addLast(point);
                }
            }
        }
        while (!queue.isEmpty()){
            Point cur = queue.removeFirst();
            for(int i=0;i<X.length;i++){
                if(isValid(mat, X[i] + cur.x, Y[i] +cur.y)){
                    if(cur.dist + 1 < dis[X[i] + cur.x][Y[i] +cur.y]){
                        dis[X[i] + cur.x][Y[i] +cur.y] = cur.dist + 1;
                        Point newPoint = new Point(X[i] + cur.x, Y[i] +cur.y);
                        newPoint.dist = cur.dist+1;
                        queue.addLast(newPoint);
                    }
                }
            }
        }
        return dis;
    }
    public static boolean isValid(int[][] mat, int row, int col){
        if(row>= mat.length || row <0 || col >= mat[0].length || col < 0)
            return false;
        return true;
    }
    public static void main(String[]args){
        int mat[][] = {
                {0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 1, 1, 0}
        };
        int dis[][] = calc(mat);
        for (int i=0;i< dis.length;i++){
            System.out.println(Arrays.toString(dis[i]));
        }
    }
}
