import java.util.Scanner;

public class ArrBoundException {

    //Bodlogo 12.02
    public static void main(String[] args) {
        try{
            String[] months = {"January", "February", "March", "April",
                    "May", "June","July", "August", "September", "October",
                    "November", "December"};
            int[] dom = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter month number: ");
            int monthNumber = scanner.nextInt();
            System.out.println("Month name is " + months[monthNumber - 1] + ", days are " + dom[monthNumber - 1]);
        }catch (ArrayIndexOutOfBoundsException ex){
            System.out.print(ex.getMessage());
        }
    }
}
