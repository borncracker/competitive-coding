package multiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockUsingLocks {
    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();

    public void operation1(){
        lock1.lock();
        System.out.println("Lock1 acquired");

        try{
            Thread.sleep(500);
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }

        lock2.lock();
        System.out.println("Lock2 acquired");

        lock2.unlock();
        lock1.unlock();
    }

    public void operation2(){
        lock2.lock();
        System.out.println("Lock2 acquired");

        try {
            Thread.sleep(500);
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }

        lock1.lock();
        System.out.println("Lock1 acquried");

        lock1.unlock();
        lock2.unlock();
    }

    public static void main(String[] args){
        DeadLockUsingLocks deadLock = new DeadLockUsingLocks();
        new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.operation1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.operation2();
            }
        }).start();
    }
}
