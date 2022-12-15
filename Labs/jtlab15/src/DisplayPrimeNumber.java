import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class DisplayPrimeNumber {
    Scanner input;

    DisplayPrimeNumber() {
        System.out.print("Enter length of numbers: ");
        input = new Scanner(System.in);
        Integer len = input.nextInt();
        ArrayList<Integer> primes = new ArrayList<>(len);

        System.out.print("\nEnter numbers: ");
        for (int i = 0; i < len; i++) {
            primes.add(input.nextInt());
        }

        System.out.println("Entered prime numbers: ");
        primes.stream().filter(this::checkPrime).forEach(elm -> System.out.print(elm + " "));
    }

    Boolean checkPrime(Integer elm) {
        return isPrime(elm).isPresent();
    }

    Optional<Integer> isPrime(Integer num) {
        Integer check, s = 0;
        if (num == 1) {
            check = null;
        } else if (num == 2) {
            check = num;
        } else {
            for (int i = 2; i <= Math.floor(Math.sqrt(num)); i++) {
                if (num % i == 0) {
                    s++;
                }
            }
            if (s == 0) {
                check = num;
            } else {
                check = null;
            }
        }
        return Optional.ofNullable(check);
    }

    public static void main(String[] args) {
        new DisplayPrimeNumber();
    }
}
