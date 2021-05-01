package multiThreading;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

class Producer implements Runnable{
    private Queue<Integer> queue;
    private int maxSize;

    Producer(Queue<Integer> queue, int maxSize){
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run(){
        while (true){
            synchronized (queue){
                while(queue.size()==maxSize){
                    try{
                        System.out.println("Queue is full. Waiting for Producer.");
                        queue.wait();
                    }catch (InterruptedException ie){
                        ie.printStackTrace();
                    }
                }
                Random random = new Random();
                int message = random.nextInt();
                System.out.println("Produced element: " + message);
                queue.offer(message);
                queue.notifyAll();
            }
        }
    }
}

class Consumer implements Runnable{
    private Queue<Integer> queue;
    private int maxSize;

    Consumer(Queue<Integer> queue, int maxSize){
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run(){
        while (true){
            synchronized (queue){
                while (queue.isEmpty()){
                    try{
                        System.out.println("Queue is empty. Waiting for Producer");
                        queue.wait();
                    }catch (InterruptedException ie){
                        ie.printStackTrace();
                    }
                }
                System.out.println("Consumed: " + queue.remove());
                queue.notifyAll();
            }
        }
    }
}
public class ProducerConsumerProblemUsingSynchronizedBlock {
    public static void main(String[] args){
        Queue<Integer> queue = new ArrayDeque<>();
        Thread t1 = new Thread(new Producer(queue,10),"Producer");
        Thread t2 = new Thread(new Consumer(queue, 10), "Consumer");
        t1.start();
        t2.start();
    }
}
