import java.util.Date;
import java.util.Scanner;

public class MainApp {

    MainApp(){
        System.out.println("#Problem01: ");
        testTriangleClass();
    }

    public static void main(String[] args) {
        new MainApp();
    }

    public abstract class GeometricObject{
        private String color = "white";
        private boolean filled;
        private Date dateCreated;

         /** Construct a default geometric object */
        protected GeometricObject() {
          dateCreated = new java.util.Date();
        }

        /** Construct a geometric object with color and filled value */
        protected GeometricObject(String color, boolean filled) {
            dateCreated = new java.util.Date();
            this.color = color;
            this.filled = filled;
        }

        /** Return color */
        public String getColor() {
            return color;
        }

        /** Set a new color */
        public void setColor(String color) {
            this.color = color;
        }

        /** Return filled. Since filled is boolean, the getter method is named isFilled */
        public boolean isFilled() {
          return filled;
        }

        /** Set a new filled */
        public void setFilled(boolean filled) {
            this.filled = filled;
        }

        /** Get dateCreated */
        public java.util.Date getDateCreated() {
            return dateCreated;
        }

        @Override
        public String toString() {
            return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
        }

        /** Abstract method getArea */
        public abstract double getArea();

        /** Abstract method getPerimeter */
        public abstract double getPerimeter();
    }

    public class Triangle extends GeometricObject{
        double a, b, c;

        Triangle(){
            this(1, 1, 1);
        }

        Triangle(double a, double b, double c){
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public double getA() {
            return a;
        }

        public void setA(double a) {
            this.a = a;
        }

        public double getB() {
            return b;
        }

        public void setB(double b) {
            this.b = b;
        }

        public double getC() {
            return c;
        }

        public void setC(double c) {
            this.c = c;
        }

        @Override
        public double getArea() {
            double p = this.getPerimeter()/2;
            return Math.sqrt(p*(p-a)*(p-b)*(p-c));
        }

        @Override
        public double getPerimeter() {
            return a + b + c;
        }

        @Override
        public String toString() {
            return "Triangle{" +
                    "a=" + getA() +
                    ", b=" + getB() +
                    ", c=" + getC() +
                    ", color='" + getColor() + '\'' +
                    ", filled=" + isFilled() +
                    ", area=" + getArea() +
                    ", perimeter=" + getPerimeter() +
                    '}';
        }

        public boolean isTriangle() {
            return a + b > c && a + c > b && b + c > a;
        }
    }

    public Scanner input(String txt){
        System.out.print(txt);
        return new Scanner(System.in);
    }

    //Lab02 ---> 13.01
    public void testTriangleClass(){
        Triangle triangle = new Triangle();
        triangle.setA(input("Enter first a side: ").nextDouble());
        triangle.setB(input("Enter second a side: ").nextDouble());
        triangle.setC(input("Enter third a side: ").nextDouble());
        triangle.setColor(input("Enter color: ").nextLine());
        triangle.setFilled(input("Enter whether was filled: ").nextBoolean());
        System.out.println(triangle);
        System.out.println(triangle.isTriangle() ? "This triangle exist." : "This triangle not exist.");
    }
}
