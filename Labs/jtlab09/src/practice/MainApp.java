package practice;

public class MainApp {

    /*
    2.a. Write a short program in which two threads both increment a shared
     integer repeatedly, without proper synchronisation, 1,000,000 times,
     printing the result at the end of the program.
     */

    Integer number = 0;
    MainApp(){
        Runnable customTask = new CustomTask();
        Runnable customTask1 = new CustomTask();

        Thread thread = new Thread(customTask);
        Thread thread1 = new Thread(customTask1);

        thread.start();
        thread1.start();
    }

    public static void main(String[] args) {
        new MainApp();
    }

    public class CustomTask implements Runnable {
        public synchronized void increment(){
            for (int i = 0; i < 1000000; i++) {
                number++;
            }
            System.out.println("sum: " + number);
        }

        @Override
        public void run() {
            synchronized (this){
               this.increment();
            }
        }
    }
}
