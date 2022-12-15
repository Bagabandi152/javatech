package hw;

import java.util.ArrayList;
import java.util.Scanner;

public class SquareRootMultiple {

    /*
    Бодлого №2. Өгөгдсөн ArrayList дэх утгуудын квадрат язгууруудын үржвэрийг олдог програм зохио.
    Зөвлөмж: Энэ програмыг зохиоход reduce методыг хэрэглээрэй.
     */

    ArrayList<Integer> intList;
    Scanner input = new Scanner(System.in);

    SquareRootMultiple() {
        System.out.print("Enter length of array: ");
        Integer len = input.nextInt();

        System.out.println("\nEnter elements of array: ");
        intList = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            intList.add(input.nextInt());
        }

        Double squareRootMultiple = intList.stream().mapToDouble(num -> Math.sqrt(num)).reduce((a, b) -> a * b).getAsDouble();
        System.out.printf("\nAnswer: %.5f", squareRootMultiple);
    }

    public static void main(String[] args) {
        new SquareRootMultiple();
    }
}
