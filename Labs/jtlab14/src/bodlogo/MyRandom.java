package bodlogo;

import java.util.List;
import java.util.function.Supplier;

public class MyRandom {

    static Integer start;
    static Integer end;
    static List<Integer> exclude;

    public MyRandom(Integer start, Integer end, List<Integer> exclude) {
        this.start = start;
        this.end = end;
        this.exclude = exclude;
    }

    public static int getRandom() {
        Integer rand = (int) ((Math.random() * (end - start)) + start);
        Boolean isMatch = exclude.stream().allMatch(i -> i.equals(rand));
        if (isMatch) {
            return getRandom();
        }
        return rand;
    }

    public int runGetRandom(Supplier<Integer> supplier) {
        return supplier.get();
    }
}
