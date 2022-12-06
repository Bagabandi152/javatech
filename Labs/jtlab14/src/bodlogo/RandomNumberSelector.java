package bodlogo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomNumberSelector {

    RandomNumberSelector() {
        for (int i = 1; i <= 90; i++) {
            List<Integer> list = new ArrayList<>(Arrays.asList(5, 2, 1));
            MyRandom myRandom = new MyRandom(1, 10, list);
            System.out.printf("%4d", myRandom.runGetRandom(MyRandom::getRandom));
            if (i % 15 == 0) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        new RandomNumberSelector();
    }
}
