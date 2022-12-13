import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DisplayPrimeNumber {

    Scanner input;

    DisplayPrimeNumber() {
        System.out.println("Enter length of numbers: ");
        input = new Scanner(System.in);
        Integer len = input.nextInt();
        ArrayList<Integer> primes = new ArrayList<>(len);

        System.out.print("\nEnter numbers: ");
        for (int i = 0; i < len; i++) {
            primes.add(input.nextInt());
        }

        System.out.println("Entered prime numbers: ");
        printArr((ArrayList<Integer>) primes.stream().filter(elm -> isPrime(elm).isPresent()).collect(Collectors.toList()));
    }

    Optional<Integer> isPrime(Integer num) {
        Integer check, s = 0;
        if (num == 1) {
            check = null;
        } else if (num == 2) {
            check = num;
        } else {
            for (int i = 3; i <= Math.floor(Math.sqrt(num)); i++) {
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

    void printArr(ArrayList<Integer> arrayList) {
        arrayList.stream().forEach(elm -> System.out.print(elm + " "));
    }

    public static void main(String[] args) {
        new DisplayPrimeNumber();
    }
}
