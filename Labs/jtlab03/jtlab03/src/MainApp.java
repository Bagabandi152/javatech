import java.util.Date;
import java.util.Scanner;

public class MainApp {

    public static Scanner input(String txt){
        System.out.print(txt);
        return new Scanner(System.in);
    }

    MainApp(int probNum){
        switch (probNum){
            case 1: {
                System.out.println("#Problem01: test Triangle class.");
                testTriangleClass();
                break;
            }
            case 2: {
                System.out.println("#Problem02: sum the areas of geometric objects.");
                sumAreasGeoObj();
                break;
            }
            default:{
                System.out.println("Sorry, problem not found!!!");
                break;
            }
        }
    }

    public static void main(String[] args) {
        while (true){
            int probNum = input("\nEnter problem number (if stop app, enter 0): ").nextInt();
            if(probNum == 0){
                break;
            }
            new MainApp(probNum);
        }
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

    static final double pi = 3.14;
    public class Circle extends GeometricObject{
        double radius;

        Circle(){
            this(1);
        }

        Circle(double radius){
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        @Override
        public double getArea() {
            double p = this.getPerimeter()/2;
            return p*getRadius();
        }

        @Override
        public double getPerimeter() {
            return 2*getRadius()*pi;
        }

        @Override
        public String toString() {
            return "Circle{" +
                    "radius=" + getRadius() +
                    ", color='" + getColor() + '\'' +
                    ", filled=" + isFilled() +
                    ", area=" + getArea() +
                    ", perimeter=" + getPerimeter() +
                    '}';
        }
    }

    public class Rectangle extends GeometricObject{
        double a, b;

        Rectangle(){
            this(1, 1);
        }

        Rectangle(double a, double b){
            this.a = a;
            this.b = b;
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

        @Override
        public double getArea() {
            return a*b;
        }

        @Override
        public double getPerimeter() {
            return a + b;
        }

        @Override
        public String toString() {
            return "Rectangle{" +
                    "a=" + getA() +
                    ", b=" + getB() +
                    ", color='" + getColor() + '\'' +
                    ", filled=" + isFilled() +
                    ", area=" + getArea() +
                    ", perimeter=" + getPerimeter() +
                    '}';
        }
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

    //Lab02 ---> 13.12
    public void sumAreasGeoObj(){
        System.out.println("Triangle 1: ");
        GeometricObject tri1 = new Triangle(input("Enter first a side: ").nextDouble(), input("Enter second a side: ").nextDouble(), input("Enter third a side: ").nextDouble());
        System.out.println("Triangle2: ");
        GeometricObject tri2 = new Triangle(input("Enter first a side: ").nextDouble(), input("Enter second a side: ").nextDouble(), input("Enter third a side: ").nextDouble());
        System.out.println("Circle1: ");
        GeometricObject circle1 = new Circle(input("Enter a radius: ").nextDouble());
        System.out.println("Circle2: ");
        GeometricObject circle2 = new Circle(input("Enter a radius: ").nextDouble());
        System.out.println("Rectangle1: ");
        GeometricObject rect1 = new Rectangle(input("Enter first a side: ").nextDouble(), input("Enter second a side: ").nextDouble());
        System.out.println("Rectangle2: ");
        GeometricObject rect2 = new Rectangle(input("Enter first a side: ").nextDouble(), input("Enter second a side: ").nextDouble());

        GeometricObject[] geoArr = { tri1, tri2, circle1, circle2, rect1, rect2 };
        System.out.printf("Geometric objects area sum: %.3f", sumArea(geoArr));
    }

    public static double sumArea(GeometricObject[] a){
        double sum = 0;
        for(int i = 0; i < a.length; i++){
            sum += a[i].getArea();
        }
        return sum;
    }
}
