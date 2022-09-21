public class DeskPhone implements Callable {
    private int myNumber;
    private boolean isRinging;

    public DeskPhone() {
        this(0,false);
    }
    public DeskPhone(int myNumber, boolean isRinging) {
        this.myNumber = myNumber;
        this.isRinging = isRinging;
    }

    public int getMyNumber() {
        return myNumber;
    }

    public void setMyNumber(int myNumber) {
        this.myNumber = myNumber;
    }

    public boolean isRinging() {
        return isRinging;
    }

    public void setRinging(boolean ringing) {
        isRinging = ringing;
    }

    @Override
    public void powerOn() {
        System.out.println("power on Desk phone.");
    }

    @Override
    public void dial(int phoneNumber) {
        setRinging(true);
        setMyNumber(phoneNumber);
    }

    @Override
    public void answer() {
        if(this.isRinging){
            System.out.println("Hello, It's desk phone("+ getMyNumber() + ").");
        }else{
            System.out.println("Sorry, It's power off.");
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        return this.myNumber == phoneNumber;
    }

    @Override
    public String toString() {
        return "DeskPhone{" +
                "myNumber=" + myNumber +
                ", isRinging=" + isRinging +
                '}';
    }
}
