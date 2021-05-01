package multiThreading;

import java.sql.Time;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTest {
    public static int counter =0;
    public static void main(String[] args){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try{
            Future<?> result = executorService.submit(() -> {
                for(int i=0;i<100;i++)
                    FutureTest.counter++;
                return counter;
            });
            System.out.println(result.get(10, TimeUnit.MILLISECONDS));
        }catch (InterruptedException | TimeoutException | ExecutionException te){
            te.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }
}
