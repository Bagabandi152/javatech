package test;

import java.util.Scanner;

public class MainApp {



    DoIt sum, minus, div, multi;

    MainApp(int a, int b){
        sum = (x, y) -> x + y;
        minus = (x, y) -> x - y;
        div = (x, y) -> x / y;
        multi = (x, y) -> x * y;
        System.out.println("Sum: " + sum.go(a, b));
        System.out.println("Minus: " + minus.go(a, b));
        System.out.println("Divide: " + div.go(a, b));
        System.out.println("Multiple: " + multi.go(a, b));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = input.nextInt();
        System.out.print("Enter second number: ");
        int b = input.nextInt();
        new MainApp(a, b);
    }
}
