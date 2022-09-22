public class Pigeon extends Animal implements Flyable{

    double flying = 0;

    public Pigeon(int x, int y, int age) {
        super(x, y, age);
    }

    public double getFlying() {
        return flying;
    }

    public void setFlying(double flying) {
        this.flying = flying;
    }

    @Override
    public void attack() {
        System.out.println("Peck!!!");
    }

    @Override
    public void fly(int yDistance) {
        flying += yDistance;
    }

    @Override
    public void flyMove(int xDistance, int yDistance) {
        flying += Math.sqrt(xDistance*xDistance + yDistance*yDistance);
    }

    @Override
    public void talk() {
        System.out.println("Guyan guyan");
    }

    @Override
    public String toString() {
        return "Pigeon{" +
                "x=" + x +
                ", y=" + y +
                ", age=" + age +
                ", flying=" + flying +
                '}';
    }
}
