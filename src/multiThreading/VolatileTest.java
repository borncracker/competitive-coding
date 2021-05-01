package multiThreading;

public class VolatileTest {
    public static volatile int MY_INT = 0;
    static class ChangeListener implements Runnable{
        @Override
        public void run(){
            int local_value = MY_INT;
            while(local_value < 5){
                if(local_value !=MY_INT){
                    System.out.println("Detected change for MY_INT: " + MY_INT);
                    local_value = MY_INT;
                }
            }
        }
    }
    static class ChangeMaker implements Runnable{
        @Override
        public void run(){
            int local_value = MY_INT;
            while(local_value < 5){
                System.out.println("Incrementing the MY_INT: " + (local_value + 1));
                MY_INT = ++local_value;
                try{
                    Thread.sleep(500);
                }catch (InterruptedException ie){
                    ie.printStackTrace();
                }
            }
        }
    }
    public static void main(String[]args){
        new Thread(new ChangeListener()).start();
        new Thread(new ChangeMaker()).start();
    }
}
