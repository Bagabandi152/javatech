package problem02;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class MainApp {
    static Random random = new Random();

    public static void main(String[] args) {
        int M = 1000;
        int N = 1000;

        int[][] area = new int[M][N];

        for(int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                area[i][j] = 1;
            }
        }

        prepareArea(area);
        System.out.println("Grin seeds count: " + countGrainSeeds(area));
    }

    public static void prepareArea(int[][] list) {
        RecursiveAction mainTask = new PrepareAreaTask(list);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);
    }

    private static class PrepareAreaTask extends RecursiveAction {
        private final int THRESHOLD_M = random.nextInt(2, 10);
        private final int THRESHOLD_N = random.nextInt(2, 10);
        private int[][] list;

        PrepareAreaTask(int[][] list) {
            this.list = list;
        }

        @Override
        protected void compute() {
            if (list.length < THRESHOLD_M && list[0].length < THRESHOLD_N) {
                for(int i = 0; i < list.length; i++){
                    for (int j = 0; j < list[0].length; j++){
                        list[i][j] = 0;
                    }
                }
            } else {
                // Obtain the first half
                int[][] firstHalf = new int[list.length / 2][list[0].length/2];

                // Obtain the second half
                int secondHalfRow = list.length - list.length / 2;
                int secondHalfCol = list[0].length - list[0].length / 2;
                int[][] secondHalf = new int[secondHalfRow][secondHalfCol];

                invokeAll(new PrepareAreaTask(firstHalf), new PrepareAreaTask(secondHalf));
            }
        }
    }


    public static Integer countGrainSeeds(int[][] list) {
        RecursiveTask<Integer> mainTask = new GrainSeedsTask(list);
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(mainTask);
    }

    private static class GrainSeedsTask extends RecursiveTask<Integer> {
        private final int THRESHOLD_M = 100;
        private final int THRESHOLD_N = 100;
        private int[][] list;

        GrainSeedsTask(int[][] list) {
            this.list = list;
        }

        @Override
        protected Integer compute() {
            if (list.length < THRESHOLD_M && list[0].length < THRESHOLD_N) {
                Integer sum = 0;
                for(int i = 0; i < list.length; i++){
                    for (int j = 0; j < list[0].length; j++){
                        if(list[i][j] == 1){
                            sum++;
                        }
                    }
                }
                return sum;
            } else {
                // Obtain the first half
                int[][] firstHalf = new int[list.length / 2][list[0].length/2];

                // Obtain the second half
                int secondHalfRow = list.length - list.length / 2;
                int secondHalfCol = list[0].length - list[0].length / 2;
                int[][] secondHalf = new int[secondHalfRow][secondHalfCol];
                RecursiveTask<Integer> left = new GrainSeedsTask(firstHalf);
                RecursiveTask<Integer> right = new GrainSeedsTask(secondHalf);

                right.fork();
                left.fork();
                return left.join().intValue() + right.join().intValue();
            }
        }
    }
}
