public class Kevin extends Human implements Swimable, Programmer{

    double swimming = 0;
    boolean solveProblem;
    boolean writingCode;

    public Kevin(int x, int y, int age, boolean solveProblem, boolean writingCode) {
        super(x, y, age);
        this.solveProblem = solveProblem;
        this.writingCode = writingCode;
    }

    public double getSwimming() {
        return swimming;
    }

    public void setSwimming(double swimming) {
        this.swimming = swimming;
    }

    public boolean isSolveProblem() {
        return solveProblem;
    }

    public void setSolveProblem(boolean solveProblem) {
        this.solveProblem = solveProblem;
    }

    public boolean isWritingCode() {
        return writingCode;
    }

    public void setWritingCode(boolean writingCode) {
        this.writingCode = writingCode;
    }

    @Override
    public void attack() {
        System.out.println("Fight!!!");
    }

    @Override
    public void swim(int xDistance) {
        swimming += xDistance;
    }

    @Override
    public void swimMove(int xDistance, int yDistance) {
        swimming += Math.sqrt(xDistance*xDistance + yDistance*yDistance);
    }

    @Override
    public void solveProblem() {
        if(solveProblem){
            System.out.println("Solved problem.");
        }
    }

    @Override
    public void writingCode() {
        if(writingCode){
            System.out.println("finished.");
        }
    }

    @Override
    public String toString() {
        return "Kevin{" +
                "x=" + x +
                ", y=" + y +
                ", age=" + age +
                ", swimming=" + swimming +
                ", solveProblem=" + solveProblem +
                ", writingCode=" + writingCode +
                '}';
    }
}
