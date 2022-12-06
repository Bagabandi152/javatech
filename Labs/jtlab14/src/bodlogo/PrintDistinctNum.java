package bodlogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PrintDistinctNum {

    PrintDistinctNum(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int n = input.nextInt();
        List<Integer> numbers = new ArrayList<>(n);

        System.out.print("Enter the numbers: ");
        for (int i = 0; i < n; i++) {
            numbers.add(input.nextInt());
        }

        List<Integer> distinctNum = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println("The number of distinct numbers: " + distinctNum.size());
        System.out.println("The distinct numbers are: ");
        distinctNum.stream().forEach(num -> {
            System.out.print(num + " ");
        });
    }

    public static void main(String[] args) {
        new PrintDistinctNum();
    }
}
