package graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class KnightMinStepsToReachDestination {
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
//        @Override
//        public int hashCode(){
//            int prime = 31;
//            int result = 7;
//            result = result*prime + x;
//            result = result*prime + y;
//            return result;
//        }
//        @Override
//        public boolean equals(Object obj){
//            if(obj == null)
//                return false;
//            if(obj.getClass() != getClass())
//                return false;
//            if(obj ==  this)
//                return true;
//            Point point = (Point)obj;
//            if(this.x == point.x && this.y == point.y)
//                return true;
//            return false;
//        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    static class Pair{
        Point point;
        int move;
        Pair(Point point, int move){
            this.point=point;
            this.move = move;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "point=" + point +
                    ", move=" + move +
                    '}';
        }
    }
    static int[] X ={-2, -2,  1, -1,  2, 2, 1, -1};
    static int[] Y ={-1,  1, -2, -2, -1, 1, 2,  2};
    public static int minStepToReachTarget(int[] knightPosition, int[]targetPosition, int N){
        Deque<Pair> queue = new ArrayDeque<>();
        Point start = new Point(knightPosition[0],knightPosition[1]);
        Point end = new Point(targetPosition[0],targetPosition[1]);
        queue.addLast(new Pair(start,0));
        Set<Point> visited = new HashSet<>();
        int count =1;
        while (!queue.isEmpty()){
            Pair cur = queue.removeFirst();

            Point curPoint = cur.point;
            if(visited.contains(curPoint)){
                continue;
            }
            System.out.println(curPoint + " Count: " + count++);
            visited.add(curPoint);
            if (curPoint.equals(end)){
                return cur.move;
            }
            for(int i=0;i<X.length;i++){
                Point newPoint = new Point(curPoint.x+X[i],curPoint.y+Y[i]);
                if(isValid(newPoint, N, visited)){
                    queue.addLast(new Pair(newPoint, cur.move+1));
                }
            }
        }
        return -1;
    }
    public static boolean isValid(Point newPoint, int N, Set<Point> visited){
        if(newPoint.x>=0 && newPoint.y>=0 && newPoint.x<N && newPoint.y<N && !visited.contains(newPoint)){
            return true;
        }
        return false;
    }
    public static void main(String[]args){
        int N = 30;
        int knightPos[] = { 1, 1 };
        int targetPos[] = { 29, 29 };
        System.out.println(
                minStepToReachTarget(
                        knightPos, targetPos, N));
    }
}
