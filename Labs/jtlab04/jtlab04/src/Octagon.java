import java.util.Date;

public class Octagon extends GeometricObject implements Cloneable, Comparable<Octagon>, Colorable{

    double side;

    Octagon(){
        this.side = 0;
    }

    Octagon(double side){
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return (2 + 4/Math.sqrt(2)) * side * side;
    }

    @Override
    public double getPerimeter() {
        return 8*side;
    }

    @Override
    public int compareTo(Octagon o) {
        if(getArea() > o.getArea()){
            return 1;
        }else if(getArea() < o.getArea()){
            return -1;
        }else{
            return 0;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Octagon o = (Octagon) super.clone();
        o.setDateCreated(new Date());
        return o;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all eight sides");
    }
}
