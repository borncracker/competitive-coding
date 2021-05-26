package graph;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class OliverAndTheGame {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
 */
        //Scanner
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();                 // Reading input from STDIN
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i=0;i<n-1;i++){
            int a = s.nextInt();
            int b = s.nextInt();
            if(adjList.containsKey(a)){
                List<Integer> list = adjList.get(a);
                list.add(b);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(b);
                adjList.put(a, list);
            }
            if(adjList.containsKey(b)){
                List<Integer> list = adjList.get(b);
                list.add(a);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(a);
                adjList.put(b, list);
            }
        }
        Map<Integer, Integer> inTime = new HashMap<>();
        Map<Integer, Integer> outTime = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        dfs(1, adjList, visited, inTime, outTime);
        int queries = s.nextInt();
        int[][] query = new int[queries][3];
        for(int i=0;i<queries;i++){
            int dir =s.nextInt();
            int x =s.nextInt();
            int y = s.nextInt();
            if(dir ==0){
                if(check(x,y,inTime,outTime))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }else{
                if(check(y,x,inTime,outTime))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }

    }
    static int time =0;
    public static void dfs(int src, Map<Integer, List<Integer>> adjList, Set<Integer> visited, Map<Integer, Integer> inTime, Map<Integer, Integer> outTime){
        if(visited.contains(src)){
            return;
        }
        visited.add(src);
        inTime.put(src, time++);
        if(Objects.nonNull(adjList.get(src))){
            for(int node: adjList.get(src)){
                dfs(node, adjList,visited, inTime, outTime);
            }
            outTime.put(src, time++);
        }
    }
    public static boolean check(int src, int dest, Map<Integer, Integer> inTime, Map<Integer, Integer> outTime){
        List<Integer>[] adjList = new ArrayList[1];
            if(inTime.get(src) < inTime.get(dest)  && outTime.get(src)>outTime.get(dest))
                return true;
        return false;
    }
}

