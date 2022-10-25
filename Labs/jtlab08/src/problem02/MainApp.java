package problem02;

import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainApp {

    static List<Integer> divList = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        Runnable mostDivTask1 = new MostDividerTask(1, 2500);
        Runnable mostDivTask2 = new MostDividerTask(2501, 5000);
        Runnable mostDivTask3 = new MostDividerTask(5001, 7500);
        Runnable mostDivTask4 = new MostDividerTask(7501, 10000);

        Thread thread0 = new Thread(mostDivTask1);
        Thread thread1 = new Thread(mostDivTask2);
        Thread thread2 = new Thread(mostDivTask3);
        Thread thread3 = new Thread(mostDivTask4);

        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("Result: " + divList);
    }

    public static class MostDividerTask implements Runnable{
        Integer min, max;
        MostDividerTask(Integer min, Integer max){
            this.min = min;
            this.max = max;
        }

        @Override
        public void run() {
            int maxCnt = 2;
            for(int i = min; i <= max; i++){
                int divCnt = 2;
                for(int j = 2; j <= i/2; j++){
                    if(i%j == 0) {
                        divCnt++;
                    }
                }
                if(maxCnt < divCnt){
                    maxCnt = divCnt;
                }
            }
            divList.add(maxCnt);
        }
    }
}
