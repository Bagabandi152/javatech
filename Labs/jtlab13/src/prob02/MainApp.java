package prob02;

import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;

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
        while (atLeast.apply(factor, num) == 1) {
            if (isDivider.apply(factor, num) == 1) {
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

    static BinaryOperator<Integer> atLeast = (factor, num) -> {
        if (factor <= num) {
            return 1;
        } else {
            return 0;
        }
    };


    static BinaryOperator<Integer> isDivider = (factor, num) -> {
        if (num % factor == 0) {
            return 1;
        } else {
            return 0;
        }
    };

}
