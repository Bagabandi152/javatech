import com.sun.tools.javac.Main;

import java.util.Scanner;

public class MainApp {
    MainApp(int probNum){
        switch (probNum){
            case 1: {
                System.out.println("Problem01: ");
                testCallable();
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
}
