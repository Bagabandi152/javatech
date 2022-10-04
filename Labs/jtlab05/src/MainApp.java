import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        //Bodlogo 12.04
        try{
            Loan loan = new Loan(inputNumber("annualInterestRate: ").nextDouble(), inputNumber("loanAmount: ").nextInt(), inputNumber("numberOfYears: ").nextDouble());
            loan.setAnnualInterestRate(inputNumber("change annualInterestRate: ").nextDouble());
            loan.setLoanAmount(inputNumber("change loanAmount: ").nextDouble());
            loan.setNumberOfYears(inputNumber("change numberOfYears: ").nextInt());
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        //Bodlogo 12.05
        try{
            Triangle tri = new Triangle(inputNumber("a: ").nextDouble(), inputNumber("b: ").nextDouble(), inputNumber("c: ").nextDouble());
            tri.setA(inputNumber("change A: ").nextDouble());
            tri.setB(inputNumber("change B: ").nextDouble());
            tri.setC(inputNumber("change C: ").nextDouble());
        }catch (IllegalTriangleException ex){
            System.out.println(ex.getMessage());
        }
    }
    static Scanner inputNumber(String str){
        System.out.print(str);
        return new Scanner(System.in);
    }
}
