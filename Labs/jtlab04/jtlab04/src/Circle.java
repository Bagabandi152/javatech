public class Circle extends GeometricObject{
    static final double pi = 3.14;
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