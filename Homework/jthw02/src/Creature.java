public abstract class Creature {
    int x;
    int y;
    int age;

    public Creature(int x, int y, int age) {
        this.x = x;
        this.y = y;
        this.age = age;
    }

    public void age(){
        age++;
    }

    public void move(int xDistance){
        x += xDistance;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
