public class Triangle extends GeometricObject{
    double a, b, c;

    Triangle() throws IllegalTriangleException {
        this(1, 1, 1);
    }

    Triangle(double a, double b, double c) throws IllegalTriangleException {
        if(a + b > c && a + c > b && b + c > a){
            throw new IllegalTriangleException();
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) throws IllegalTriangleException {
        if(a + b > c && a + c > b && b + c > a){
            throw new IllegalTriangleException();
        }
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) throws IllegalTriangleException {
        if(a + b > c && a + c > b && b + c > a){
            throw new IllegalTriangleException();
        }
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) throws IllegalTriangleException {
        if(a + b > c && a + c > b && b + c > a){
            throw new IllegalTriangleException();
        }
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