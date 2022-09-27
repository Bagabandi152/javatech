public abstract class Animal extends Creature implements Talkable{
    public Animal(int x, int y, int age) {
        super(x, y, age);
    }

    public abstract void attack();
}
