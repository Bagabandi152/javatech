package bodlogo01;
import java.util.function.Supplier;

public class BigFibonacci {
    static Integer n;

    public BigFibonacci(Integer n) {
        this.n = n;
    }

    public static int fibonacci(int n){
        if(n == 0) return 0;
        else if(n == 1) return 1;
        else return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public static int calcValue(){
        return fibonacci(n);
    }

    public static int getValue(Supplier<Integer> supplier){
        return supplier.get();
    }
}
