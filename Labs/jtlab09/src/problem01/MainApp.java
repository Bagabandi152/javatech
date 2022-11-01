//package problem01;
//
//import java.util.Scanner;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class MainApp {
//
//    /*
//    Lab09-Bod01. Neg duureg 1 hulbumbugiin talbai, m bag buguud 1 udurt 5n bagiig l huleej awdag.
//        1. m bagiig togluulahad hden udur shaardlagatai we?
//        2. 1 sard heden udaa togloj boloh we?
//     */
//
//    public static void main(String[] args) {
//
//        Scanner input = new Scanner(System.in);
//        System.out.print("Bagiin toog oruul: ");
//        Integer m = input.nextInt();
//
//        // Create a thread pool with two threads
//        ExecutorService executor = Executors.newFixedThreadPool(m);
//        executor.execute(new ConsumerProducer.ProducerTask());
//        executor.execute(new ConsumerProducer.ConsumerTask());
//        executor.shutdown();
//    }
//}
