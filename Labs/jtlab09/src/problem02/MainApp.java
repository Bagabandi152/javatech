package problem02;

public class MainApp {

    Integer number = 0;
    Storage storage;

    MainApp() {
        /*Implement three classes: Storage, Counter, and Printer.
        The Storage class should store an integer.
        The Counter class should create a thread that starts counting from 0 (0, 1, 2, 3 ...)
        and stores each value in the Storage class.
        The Printer class should create a thread that keeps reading the value in the Storage class and printing it.

        Write a program that creates an instance of the Storage class
        and sets up a Counter and a Printer object to operate on it.1
        */
        storage = new Storage(0);

        for (int i = 0; i < 100; i++) {
            Runnable task1 = new Counter();
            Runnable task2 = new Printer();
            Thread thread1 = new Thread(task1);
            Thread thread2 = new Thread(task2);
            thread1.start();
            thread2.start();
        }
    }

    public static void main(String[] args) {
        new MainApp();
    }

    public class Storage {
        Integer integer;

        public Storage(Integer integer) {
            this.integer = integer;
        }

        public Integer getInteger() {
            return integer;
        }

        public void setInteger(Integer integer) {
            this.integer = integer;
        }

        synchronized void print() {
            System.out.println("Storage: " + getInteger());
        }
    }

    public class Printer implements Runnable {
        @Override
        public void run() {
            storage.print();
        }
    }

    public class Counter implements Runnable {

        public synchronized void increment() {
            number++;
            storage.setInteger(number);
        }

        @Override
        public void run() {
//            synchronized (this) {
                this.increment();
//            }
        }
    }
}
