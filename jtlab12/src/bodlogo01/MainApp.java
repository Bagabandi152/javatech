package bodlogo01;

import java.util.Scanner;

public class MainApp {

    MainApp(int len) {
        FuncInterface funcInterface = (n) -> n * (3 * n - 1) / 2;
        for (int i = 1; i <= len; i++) {
            System.out.printf("%7d", funcInterface.getPentagonalNumber(i));
            if (i % 10 == 0) System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter a length: ");
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        new MainApp(len);
    }
}
