package test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;

class Node{
    int freq;
    Node left;
    Node right;
}

class MyComparator implements Comparator<Node>{
    @Override
    public int compare(Node o1, Node o2) {
        return o1.freq - o2.freq;
    }
}
public class Test {
    static int staticTestVar = 10;
    int nonStaticTestVar = 15;
    Thread t1 = Thread.currentThread();
    Test test = new Test();
    public void nonStaticTestFun(){
        System.out.println(staticTestVar);
        System.out.println(nonStaticTestVar);
       // System.out.println(Test.nonStaticTestVar);
    }
    public static void staticTestFun(){
        System.out.println(staticTestVar);
        //System.out.println(nonStaticTestVar); //Failed
    }

    public static String exceptions() {
         String result = "";
         String v = null;
             try {
                 result += "before";
                 v.length();
                 result += "after";
             } catch (NullPointerException e) {
                 result += "catch";
                 return result;
             } finally {
                 result += "finally";
                 return result;
             }
    }
    public static void main(String args[]){
        System.out.println("Exceptions: " + exceptions());
        ModelType modelType = null;
        switch (modelType){
            case BMW:
                System.out.println("BMW");
            case FERRARI:
                System.out.println("Ferrari");
            default:
                System.out.println("default");
        }
        String one="1000";
        String two = "2500";
        System.out.println(one.compareTo(two));
        Integer x = 50;
        System.out.println(x.toString());
        Map<String, Integer> map = new HashMap<>();
        map.put("a",1);
        System.out.println(map.get("a"));
        System.out.println(map.get("b"));
        List<String> list = null;
        for(String str: list){
            System.out.println(str);
        }
        String str1 = null;
        String str2 = null;
        System.out.println("Null Equality: " + str1.equals(str2));
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.shutdownNow();
        useCallable(()-> {throw new IOException(); });
        ForkJoinPool pool = new ForkJoinPool(3);
    }
    public static void use(Supplier<Integer> expression){
        System.out.println("Supplier");
    }
    public static void use(Callable<Integer> expression){
        System.out.println("Callable");
    }
    public static void useSupplier(Supplier<Integer> expression){
        System.out.println("Supplier");
    }
    public static void useCallable(Callable<Integer> expression){
        System.out.println("Callable");
    }
}
