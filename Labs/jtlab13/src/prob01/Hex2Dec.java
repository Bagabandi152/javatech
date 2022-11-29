package prob01;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Hex2Dec {

    Hex2Dec() {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a hex number: ");
        String hex = input.nextLine();

        System.out.println("The decimal value for hex number " + hex + " is " + hexToDecimal.apply(hex.toUpperCase()));
    }

    /**
     * Main method
     */
    public static void main(String[] args) {
        new Hex2Dec();
    }

    Function<String, Integer> hexToDecimal = (hex) -> {
        int decimalValue = 0;
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            decimalValue = decimalValue * 16 + hexCharToDecimal.apply(hexChar);
        }

        return decimalValue;
    };

    static Function<Character, Integer> hexCharToDecimal = (ch) -> {
        if (ch >= 'A' && ch <= 'F') {
            return 10 + ch - 'A';
        } else {
            // ch is '0', '1', ..., or '9'
            return ch - '0';
        }
    };
}
