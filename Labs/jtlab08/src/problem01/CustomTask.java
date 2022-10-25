package problem01;

import java.util.Random;

public class CustomTask implements Runnable {

    Integer len;
    String threadName;
    Integer sum = 0;
    Random random = new Random();

    CustomTask(Integer len, String threadName) {
        this.threadName = threadName;
        this.len = len;
    }

    @Override
    public void run() {
        for (int i = 0; i < len; i++) {
            sum += random.nextInt(len);
        }
        System.out.println(threadName + ", sum: " + sum);
    }
}
