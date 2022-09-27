public class Square extends GeometricObject implements Colorable{
    double a;

    Square(){
        this(1);
    }

    Square(double a){
        this.a = a;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    @Override
    public double getArea() {
        return a*a;
    }

    @Override
    public double getPerimeter() {
        return 4*a;
    }

    @Override
    public String toString() {
        return "Square{" +
                "a=" + getA() +
                ", color='" + getColor() + '\'' +
                ", filled=" + isFilled() +
                ", area=" + getArea() +
                ", perimeter=" + getPerimeter() +
                '}';
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}