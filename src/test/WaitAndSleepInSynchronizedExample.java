package test;

class ThreadRunnable implements Runnable{
    synchronized public void run(){
        System.out.println("In Run method with thread: " + Thread.currentThread());
        try {
            Thread.sleep(10000);
            System.out.println("Sleeping over");
            System.out.println("Current Time: "+ System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class ThreadRunnableWithWait implements Runnable{
    synchronized public void run(){
        System.out.println("In Run method with thread: " + Thread.currentThread());
        try {
            wait();
            System.out.println("Sleeping over");
            System.out.println("Current Time: "+ System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class WaitAndSleepInSynchronizedExample {
    public static void main(String[]args){
        ThreadRunnable object = new ThreadRunnable();
        Thread t1 = new Thread(object);
        Thread t2 = new Thread(object);
        t1.start();
        t2.start();
    }
}
