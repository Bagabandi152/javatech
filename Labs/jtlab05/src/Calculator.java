import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    //Bodlogo 12.01
    public static void main(String[] args) {
        try {
            int result = 0;

            String op;
            int a, b;

            Scanner scanner = new Scanner(System.in);
            System.out.print("input a operand: ");
            op = scanner.nextLine();

            System.out.print("input first number: ");
            a = scanner.nextInt();

            System.out.print("input second number: ");
            b = scanner.nextInt();

            // Determine the operator
            switch (op) {
                case "+": {
                    result = a + b;
                    break;
                }
                case "−": {
                    result = a - b;
                    break;
                }
                case "*": {
                    result = a * b;
                    break;
                }
                case "/": {
                    result = a / b;
                    break;
                }
            }

            // Display result
            System.out.println(a + " " + op + " " + b + " = " + result);
        }catch (InputMismatchException ex){
            System.out.println("Input mismatch!");
        }catch (NumberFormatException ex){
            System.out.println(ex.getMessage());
        }
    }
}
