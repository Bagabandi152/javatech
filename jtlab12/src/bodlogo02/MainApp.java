package bodlogo02;

import java.util.Scanner;

public class MainApp {
    @FunctionalInterface
    public interface FuncInterface {
        String reverse(String str);
        default boolean isPalindrome(String str){
            return str.equals(reverse(str));
        }
    }

    MainApp(String str){
        FuncInterface funcInterface = (string) -> {
            StringBuilder stringBuilder = new StringBuilder(string);
            return stringBuilder.reverse().toString();
        };

        System.out.println("isPalindrome: " + funcInterface.isPalindrome(str));
     }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String str = scanner.nextLine();
        new MainApp(str);
    }
}
