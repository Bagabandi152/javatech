package problem01;

public class MainApp {
    public static void main(String[] args) {
        Runnable customTask = new CustomTask(100, "thread");
        Runnable customTask1 = new CustomTask(10, "thread1");
        Runnable customTask2 = new CustomTask(1000, "thread2");


        Thread thread = new Thread(customTask);
        Thread thread1 = new Thread(customTask1);
        Thread thread2 = new Thread(customTask2);

        thread.start();
        thread1.start();
        thread2.start();
    }
}
