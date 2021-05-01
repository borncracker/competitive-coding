package multiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class DeadLockUsingSynchronized {
    public static void main(String[] args){
        Operations deadLock = new Operations();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                deadLock.operation1();
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                deadLock.operation2();
//            }
//        }).start();

        final ExecutorService executorService = Executors.newFixedThreadPool(10);
        try{
            IntStream.range(0,10).forEach(operation -> executorService.execute(deadLock::operation1));
        }finally{
            executorService.shutdown();
        }

        ExecutorService executorService2 = Executors.newFixedThreadPool(20);
        try{
            IntStream.range(0,20).forEach(operation -> executorService2.execute(deadLock::operation2));
        }finally{
            executorService2.shutdown();
        }
    }
}

class Operations{
    private Object obj1 = new Object();
    private Object obj2 = new Object();
    public void operation1(){
        synchronized (obj1){
            System.out.println("Acquired Lock1");
            synchronized ((obj2)){
                System.out.println("Acquired Lock2");
                try{
                    Thread.sleep(100);
                }catch (InterruptedException ie){
                    ie.printStackTrace();
                }
            }
        }
    }
    public void operation2(){
        synchronized (obj2){
            System.out.println("Acquired Lock2");
            synchronized (obj1){
                System.out.println("Acquired Lock 1");
                try{
                    Thread.sleep(100);
                }catch (InterruptedException ie){
                    ie.printStackTrace();
                }
            }
        }
    }
}