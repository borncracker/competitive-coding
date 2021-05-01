package multiThreading;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ProducerConsumerImpl{
    private Queue<Integer> queue;
    private int maxSize;
    private Lock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();
    ProducerConsumerImpl(Queue<Integer> queue, int maxSize){
        this.queue = queue;
        this.maxSize = maxSize;
    }

    public void put(){
        try {
            lock.lock();
            while (queue.size() == maxSize){
                System.out.println("Queue is Full. Waiting for Consumer.");
                full.await();
            }
            Random random = new Random();
            int produce = random.nextInt();
            System.out.println("Produced to the queue: " + produce);
            queue.offer(produce);
            empty.signalAll();
        } catch (InterruptedException ie){
            ie.printStackTrace();
        } finally{
            lock.unlock();
        }
    }

    public void get(){
        try{
            lock.lock();
            while (queue.isEmpty()){
                System.out.println("Queue is Empty. Waiting for Producer.");
                empty.await();
            }
            System.out.println("Consumed message: " + queue.remove());
            full.signalAll();
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
class ProducerWithLock implements Runnable{
    private ProducerConsumerImpl producerConsumer;
    ProducerWithLock(ProducerConsumerImpl producerConsumer){
        this.producerConsumer = producerConsumer;
    }

    @Override
    public void run(){
        while (true)
            producerConsumer.put();
    }
}

class ConsumerWithLock implements Runnable{
    private ProducerConsumerImpl producerConsumer;
    ConsumerWithLock(ProducerConsumerImpl producerConsumer){
        this.producerConsumer = producerConsumer;
    }

    @Override
    public void run(){
        while (true)
            producerConsumer.get();
    }
}
public class ProducerConsumerUsingLock {
    public static void main(String[] args){
        Queue<Integer> queue = new ArrayDeque<>();
        int maxSize = 10;
        ProducerConsumerImpl producerConsumer = new ProducerConsumerImpl(queue, maxSize);
        Thread t3 = new Thread(new ProducerWithLock(producerConsumer), "Producer");
        Thread t4 = new Thread(new ConsumerWithLock(producerConsumer), "Consumer");
        t3.start();
        t4.start();
    }
}
