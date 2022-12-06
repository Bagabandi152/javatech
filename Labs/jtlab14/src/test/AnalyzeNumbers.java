package test;

import java.util.Arrays;
import java.util.Scanner;

public class AnalyzeNumbers {

    AnalyzeNumbers(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int n = input.nextInt();
        double[] numbers = new double[n];

        System.out.print("Enter the numbers: ");
        for (int i = 0; i < n; i++) {
            numbers[i] = input.nextDouble();
        }

        double average = Arrays.stream(numbers).average().getAsDouble();
        int count = (int) Arrays.stream(numbers).filter(num -> num > average).count();

        System.out.println("Average is " + average);
        System.out.println("Number of elements above the average is " + count);
    }

    public static void main(String[] args) {
        new AnalyzeNumbers();
    }
}
