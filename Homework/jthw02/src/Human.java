public abstract class Human extends Creature implements Talkable{
    public Human(int x, int y, int age) {
        super(x, y, age);
    }

    public abstract void attack();

    @Override
    public void talk() {
        System.out.println("Hello, It's me.");
    }
}
