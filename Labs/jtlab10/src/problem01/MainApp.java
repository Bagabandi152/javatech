package problem01;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class MainApp {

    static Random random = new Random();

    public static void main(String[] args) {
        final int SIZE = 9000000;
        double[] list1 = new double[SIZE];
        double[] list2 = new double[SIZE];

        long startTime = System.currentTimeMillis();
        parallelAssignValues(list1); // Invoke parallel assign values
        long endTime = System.currentTimeMillis();
        System.out.println("\nParallel time with " + Runtime.getRuntime().availableProcessors() + " processors is " + (endTime - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();
        seqAssignValues(list2); // Sequential assign values
        endTime = System.currentTimeMillis();
        System.out.println("\nSequential time is " + (endTime - startTime) + " milliseconds");
    }
    public static void parallelAssignValues(double[] list) {
        RecursiveAction mainTask = new AssignTask(list);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);
    }

    private static class AssignTask extends RecursiveAction {
        private final int THRESHOLD = 100000;
        private double[] list;

        AssignTask(double[] list) {
            this.list = list;
        }

        @Override
        protected void compute() {
            if (list.length < THRESHOLD) {
                for (int i = 0; i < list.length; i++)
                    list[i] = random.nextDouble();
            } else {
                // Obtain the first half
                double[] firstHalf = new double[list.length / 2];

                // Obtain the second half
                int secondHalfLength = list.length - list.length / 2;
                double[] secondHalf = new double[secondHalfLength];

                //Merge two array
                System.arraycopy(firstHalf, 0, list, 0, list.length / 2);
                System.arraycopy(secondHalf, 0, list, list.length / 2, secondHalfLength);
            }
        }
    }

    public static void seqAssignValues(double[] list) {
        for (int i = 0; i < list.length; i++)
            list[i] = random.nextDouble();
    }
}
