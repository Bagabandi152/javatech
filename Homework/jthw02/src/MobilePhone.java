public class MobilePhone implements Callable{
    private int myNumber;
    private boolean isRinging;

    public MobilePhone() {
        this(0,false);
    }

    public MobilePhone(int myNumber, boolean isRinging) {
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
        System.out.println("power on Mobile phone.");
    }

    @Override
    public void dial(int phoneNumber) {
        setRinging(true);
        setMyNumber(phoneNumber);
    }

    @Override
    public void answer() {
        if(this.isRinging){
            System.out.println("Hello, It's mobile phone("+ getMyNumber() + ").");
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
        return "MobilePhone{" +
                "myNumber=" + myNumber +
                ", isRinging=" + isRinging +
                '}';
    }
}
