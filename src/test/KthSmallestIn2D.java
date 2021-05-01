package test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class KthSmallestIn2D {
        static class Node{
            int data;
            int row;
            int column;
            Node(int data, int row, int column){
                this.data = data;
                this.row = row;
                this.column = column;
            }
        }
        static class Pair{
            int row;
            int column;
            Pair(int row, int column){
                this.row = row;
                this.column = column;
            }
            @Override
            public boolean equals(Object obj){
                if(obj == null)
                    return false;
                if(obj == this){
                    return true;
                }
                Pair pair = (Pair)obj;
                if(this.row == pair.row && this.column == pair.column)
                    return true;
                return false;
            }

            @Override
            public int hashCode() {
                int result = row;
                result = 31 * result + column;
                return result;
            }
        }
        public static int kthSmallest(int[][] matrix, int k) {
            Set<Pair> set = new HashSet<>();
            Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>(){
                @Override
                public int compare(Node n1, Node n2){
                    return n1.data - n2.data;
                }
            });

            queue.add(new Node(matrix[0][0], 0, 0));
            set.add(new Pair(0,0));
            while(k > 1){
                Node cur = queue.remove();
                Pair colPair = new Pair(cur.column + 1, cur.row);
                if((cur.column +1 < matrix[0].length) && !set.contains(colPair)){
                    set.add(colPair);
                    queue.offer(new Node(matrix[cur.row][cur.column +1], cur.row, cur.column +1));
                }
                Pair rowPair = new Pair(cur.column, cur.row +1);
                if((cur.row +1 < matrix.length) && !set.contains(rowPair)){
                    set.add(rowPair);
                    queue.offer(new Node(matrix[cur.row + 1][cur.column], cur.row + 1, cur.column));
                }
                k--;
            }
            return queue.remove().data;
        }
        public static void main(String[]args){
            int[][]matrix = {{ 1,3,5},
                             {6,7,12},
                             {11,14,14}};
            int k =6;
            System.out.println(kthSmallest(matrix,k));

        }
}
