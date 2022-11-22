package Bodlogo03;

import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    @FunctionalInterface
    public interface FuncInterface {
        String[] split(String str, String splitter);
    }

    MainApp() {
//    MainApp(String str, String regex) {
//        FuncInterface funcInterface = (string, splitter) -> {
//            return new String[0];
//        };

//        System.out.println("Split string: " + funcInterface.split(str, regex));

        String[] temp1 = MyString1.split("WordAttachedlolol", "Attached");
        for (String s : temp1) {
            System.out.println(s);
        }

        String[] temp2 = MyString1.split("Wor#dAt#tac#he#dl#ol#ol", "#");
        for (String s : temp2) {
            System.out.println(s);
        }

    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter a string: ");
//        String str = scanner.nextLine();
//        System.out.print("Enter a regex: ");
//        String regex = scanner.nextLine();
//        new MainApp(str, regex);
        new MainApp();
    }
}
