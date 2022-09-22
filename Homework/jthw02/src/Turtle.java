public class Turtle extends Animal implements Swimable{

    double swimming = 0;

    public Turtle(int x, int y, int age) {
        super(x, y, age);
    }

    public double getSwimming() {
        return swimming;
    }

    public void setSwimming(double swimming) {
        this.swimming = swimming;
    }

    @Override
    public void attack() {
        System.out.println("Bite!!!");
    }

    @Override
    public void swim(int xDistance) {
        swimming += xDistance;
    }

    @Override
    public void swimMove(int xDistance, int yDistance) {
        swimming += Math.sqrt(xDistance * xDistance + yDistance*yDistance);
    }

    @Override
    public void talk() {
        System.out.println("Aun aun");
    }

    @Override
    public String toString() {
        return "Turtle{" +
                "x=" + x +
                ", y=" + y +
                ", age=" + age +
                ", swimming=" + swimming +
                '}';
    }
}
