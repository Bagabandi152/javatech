package prob02;

import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class MainApp {

    StackOfIntegers stack = new StackOfIntegers(20);

    MainApp() {
        System.out.print("Enter a positive integer: ");
        int num = new Scanner(System.in).nextInt();
        consumer.accept(num);
    }

    public static void main(String[] args) {
        new MainApp();
    }

    Consumer<Integer> consumer = (num) -> {
        int factor = 2;
        while (atLeast.test(factor, num)) {
            if (isDivider.test(factor, num)) {
                stack.push(factor);
                num /= factor;
            } else {
                factor++;
            }
        }

        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    };

    static BiPredicate<Integer, Integer> atLeast = (factor, num) -> factor <= num;

    static BiPredicate<Integer, Integer> isDivider = (factor, num) -> num%factor == 0;

}
