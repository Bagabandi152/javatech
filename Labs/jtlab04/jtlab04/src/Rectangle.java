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