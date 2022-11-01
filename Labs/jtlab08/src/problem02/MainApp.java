package problem02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MainApp {

    static List<NumWithDivs> mostDivsNumList = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        Runnable mostDivTask1 = new MostDividerTask(1, 2000);
        Runnable mostDivTask2 = new MostDividerTask(2001, 4000);
        Runnable mostDivTask3 = new MostDividerTask(4001, 6000);
        Runnable mostDivTask4 = new MostDividerTask(6001, 8000);
        Runnable mostDivTask5 = new MostDividerTask(8001, 10000);

        Thread thread1 = new Thread(mostDivTask1);
        Thread thread2 = new Thread(mostDivTask2);
        Thread thread3 = new Thread(mostDivTask3);
        Thread thread4 = new Thread(mostDivTask4);
        Thread thread5 = new Thread(mostDivTask5);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

    public static synchronized void addList(NumWithDivs num) {
        mostDivsNumList.add(num);
        if (mostDivsNumList.size() == 5) {
            findResult(mostDivsNumList);
        }
    }

    static Integer result = null;

    static synchronized void findResult(List<NumWithDivs> arr) {
        AtomicInteger divCounter = new AtomicInteger(arr.get(0).divCnt);
        arr.forEach(innElm -> {
            if (divCounter.get() < innElm.divCnt) {
                divCounter.set(innElm.divCnt);
                result = innElm.self;
            }
        });
        System.out.println("Result: " + result);
    }

     public static class NumWithDivs {
        Integer self;
        Integer divCnt;

        public NumWithDivs(Integer self, Integer divCnt) {
            this.self = self;
            this.divCnt = divCnt;
        }
    }

    public static class MostDividerTask implements Runnable {
        Integer min, max;

        MostDividerTask(Integer min, Integer max) {
            this.min = min;
            this.max = max;
        }

        @Override
        public void run() {
            int maxCnt = 2;
            int mostMultiDivs = min;
            for (int i = min; i <= max; i++) {
                int divCnt = 2;
                for (int j = 2; j <= i / 2; j++) {
                    if (i % j == 0) {
                        divCnt++;
                    }
                }
                if (maxCnt < divCnt) {
                    maxCnt = divCnt;
                    mostMultiDivs = i;
                }
            }
            addList(new NumWithDivs(mostMultiDivs, maxCnt));
        }
    }
}
