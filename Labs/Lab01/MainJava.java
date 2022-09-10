/**
 * @author Bagaa
 * @project Labs
 * @created 10/09/2022 - 5:25 PM
 * @purpose
 * @definition
 */
import java.util.Scanner;
public class MainJava {
    static final double pi = 3.14;
    static final double annualRate = 0.0375;
    MainJava(){
        System.out.println("\n#01 problem");
        this.calcTwoNumberAlgebra();
        System.out.println("\n#02 problem");
        this.calculateAreaTriangle();
        System.out.println("\n#3 problem");
        this.compoundValue();
    }
    public static void main(String[] args) {
        MainJava mainJava = new MainJava();
    }
    void calcTwoNumberAlgebra(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double a = input.nextInt();
        System.out.print("Enter second number: ");
        double b = input.nextInt();
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
    }
    void calculateAreaTriangle(){
        Scanner input = new Scanner(System.in);
        double area, volume, side;
        System.out.print("Enter a side: ");
        side = input.nextDouble();
        area = (Math.sqrt(3)/4)*side*side * pi;
        volume = area * side;
        System.out.println("Area: " + area);
        System.out.println("Volume: " + volume);
    }
    void compoundValue(){
        double finalMoney = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("Хадгалах мөнгөний хэмжээг оруул: ");
        double initialMoney = input.nextDouble();
        System.out.print("Хадгалах сарыг оруул: ");
        int months = input.nextInt();
        for(int i = 0; i < months; i++){
            finalMoney = (initialMoney + finalMoney) * (1 + annualRate/12);
            System.out.printf("%d сарын дараах таны мөнгөний хэмжээ: %.2f\n", (i + 1), finalMoney);
        }
    }
}
