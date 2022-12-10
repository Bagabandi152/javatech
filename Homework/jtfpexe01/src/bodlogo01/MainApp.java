package bodlogo01;

public class MainApp {

    //Бодлого №1. Supplier интерфейсийн  тусламжтайгаар  1000000-аас  их  утгатай  хамгийн  эхний Фибоначчийн тоог ол.
    MainApp() {
        int n = 0;
        while (true) {
            new BigFibonacci(n);
            int fibonacciNum = BigFibonacci.getValue(BigFibonacci::calcValue);
            if (1000000 < fibonacciNum) {
                System.out.println("Answer: " + fibonacciNum);
                break;
            }
            n++;
        }
    }

    public static void main(String[] args) {
        new MainApp();
    }
}
