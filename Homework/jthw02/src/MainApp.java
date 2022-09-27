import java.util.Scanner;

public class MainApp {
    MainApp(int probNum){
        switch (probNum){
            case 1: {
                System.out.println("Problem01: ");
                testCallable();
                break;
            }
            case 2: {
                System.out.println("Problem02: ");
                testAbstractClass();
                break;
            }
            default:{
                System.out.println("Sorry, problem not found!");
                break;
            }
        }
    }

    static Scanner input(String str){
        System.out.print(str);
        return new Scanner(System.in);
    }

    public static void main(String[] args) {
        while(true){
            int probNum = input("Enter problem number (if stop it, enter 0): ").nextInt();
            if(probNum == 0){
                break;
            }
            new MainApp(probNum);
        }
    }

    void testCallable(){
        /*
            • Ширээний утас объект үүсгэнэ
            • Гар утас объект үүсгэнэ
            • Утас тус бүрийг асаана.
            • Утас тус бүрээс өгөгдсөн дугаар луу дуудлага хийнэ
            • Утас бүр дуудлагад хариу өгнө
         */
        DeskPhone deskPhone = new DeskPhone();
        MobilePhone mobilePhone = new MobilePhone();
        deskPhone.powerOn();
        mobilePhone.powerOn();
        deskPhone.dial(input("Enter desk phone number: ").nextInt());
        mobilePhone.dial(input("Enter mobile phone number: ").nextInt());
        deskPhone.answer();
        mobilePhone.answer();
    }

    void testAbstractClass(){
        Kevin kevin = new Kevin(input("Enter x of Kevin: ").nextInt(), input("Enter y of Kevin: ").nextInt(), input("Enter age of Kevin: ").nextInt(), true, true);
        Turtle turtle = new Turtle(input("Enter x of Turtle: ").nextInt(), input("Enter y of Turtle: ").nextInt(), input("Enter age of Turtle: ").nextInt());
        Pigeon pigeon = new Pigeon(input("Enter x of Pigeon: ").nextInt(), input("Enter y of Pigeon: ").nextInt(), input("Enter age of Pigeon: ").nextInt());
        kevin.getSwimming();
        kevin.swim(input("Enter swim distance on x of Kevin: ").nextInt());
        kevin.talk();
        kevin.attack();
        kevin.writingCode();
        kevin.toString();
        turtle.getSwimming();
        turtle.attack();
        turtle.swimMove(input("Enter swim distance on x of Turtle: ").nextInt(), input("Enter swim distance on y of Turtle: ").nextInt());
        turtle.toString();
        pigeon.getFlying();
        pigeon.flyMove(input("Enter fly distance on x of Pigeon: ").nextInt(), input("Enter fly distance on x of Pigeon: ").nextInt());
        pigeon.attack();
        pigeon.talk();
        pigeon.toString();
    }
}
