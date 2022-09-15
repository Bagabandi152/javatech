import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Bagaa
 * @project JTHW01
 * @created 15/09/2022 - 2:02 PM
 * @purpose
 * @definition
 */
public class MainApp {
    MainApp(int probNumber){
        switch (probNumber){
            case 1:{
                System.out.println("Problem01: ");
                System.out.println("\tAnswer: " + sumOfDigitInString());
                break;
            }
            case 2:{
                System.out.println("Problem02: ");
                System.out.println("\tAnswer: " + sumOfNumInString());
                break;
            }
            case 3:{
                System.out.println("Problem03: ");
                System.out.println("\tAnswer: " + mergeTwoString());
                break;
            }
            case 4: {
                System.out.println("Problem04: ");
                System.out.println("\tAnswer: " + isSameLastChar());
                break;
            }
            case 5: {
                System.out.println("Problem05: ");
                System.out.println("\tAnswer: " + bigStringCreator());
                break;
            }
            case 6: {
                System.out.println("Problem6: ");
                try{
                    reverseFileLine();
                }catch (IOException exp){
                    exp.printStackTrace();
                }
                break;
            }
            default:{
                System.out.println("\n\tSorry, Problem not found!");
                break;
            }
        }
    }

    static String inputString(String str){
        System.out.print(str);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    static int inputNumber(String str) {
        System.out.print(str);
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public static void main(String[] args) {
        while(true){
            int probNumber = inputNumber("\nEnter a problem number(enter 0 to app finish): ");
            if(probNumber == 0){
                break;
            }
            new MainApp(probNumber);
        }
    }

    /*
    1. Компьютерийн гараас үсэг, цифр,өөр бусад тэмдэгтүүдээс бүтсэн тэмдэгт
    мөр оруул. Энэ тэмдэгт мөр дэх бүх цифрийн нийлбэрийг олж хэвлэ.Жишээлбэл,
    a1b23c4%&50 хувьд 1+2+3+4+5+0=15байна.
    */
    String sumOfDigitInString(){
        String str = inputString("Enter a string: ");
        String digitStr = str.replaceAll("[^0-9]", "");
        int sum = 0;
        String display = "";
        for (char ch: digitStr.toCharArray()) {
            int digitChar = (ch - '0');
            if(digitStr.indexOf(ch) == 0){
                display = Integer.toString(digitChar);
            }else{
                display += (" + " + digitChar);
            }
            sum += digitChar;
        }
        return display + " = " + sum;
    }

    /*
    2. Компьютерийн гараас үсэг, цифр,өөр бусад тэмдэгтүүдээс бүтсэн тэмдэгт
    мөр оруул. Энэ тэмдэгт мөр дэх бүх бүхэл тоонуудын нийлбэрийг ол.Жишээлбэл,
    a1b23c4%&50 хувьд 1 +23+4+50=78байна.
    */
    String sumOfNumInString(){
        String str = inputString("Enter a string: ");
        ArrayList<String> numStrArr = new ArrayList<>(List.of(str.split("[^0-9]")));
        int sum = 0;
        String display = "";
        for (String strNum: numStrArr.stream().filter(f -> f != "").collect(Collectors.toList())) {
            int num = Integer.parseInt(strNum);
            if(sum == 0 && display.equals("")){
                display = strNum;
            }else{
                display += (" + " + strNum);
            }
            sum += num;
        }
        return display + " = " + sum;
    }

    /*
    3. a,b гэдэг хоёр тэмдэгт мөр өгөгдөв. a тэмдэгт мөрийн эхний үсэг, b тэмдэгт
    мөрийн эхний үсэг,a тэмдэгт мөрийн хоёрдахьүсэг, b тэмдэгт мөрийн хоёрдахьүсэг,
    гэх мэтээр тэмдэгт мөр үүсгэнэ. Үлдсэн тэмдэгтүүдийг үүссэнтэмдэгт мөрийн сүүлд залгана.
    ("abc","xyz") → "axbycz"
    */
    String mergeTwoString(){
        StringBuilder mergedStr = new StringBuilder();
        String firstStr = inputString("Enter first a string: ");
        String secondStr = inputString("Enter second a string: ");

        for(int i = 0; i < firstStr.length() || i < secondStr.length(); i++){
            if(i < firstStr.length()){
                mergedStr.append(firstStr.charAt(i));
            }

            if(i < secondStr.length()){
                mergedStr.append(secondStr.charAt(i));
            }
        }

        return mergedStr.toString();
    }

    /*
    4. Хоёр тэмдэгт мөр өгөгдөв, хэрэв эдгээр тэмдэгт
    мөрүүд адил үсгүүдээр төгсдөг бол true үрдүн өгдөг.
    Энд,том жижиг үсгүүдийг ялгаагүй гэж үзнэ. Жишээ:
    "Hiabc","abc"→true
    "AbC","HiaBc"→true
    "abc","abXabc"→true
    */
    String isSameLastChar(){
        String firstStr = inputString("Enter first a string: ");
        String secondStr = inputString("Enter second a string: ");
        boolean isSameLastChar = Character.toLowerCase(firstStr.charAt(firstStr.length() - 1)) == Character.toLowerCase(secondStr.charAt(secondStr.length() - 1));
        if(isSameLastChar){
            return (firstStr + ", " + secondStr + " -> " + "true");
        }else{
            return (firstStr + ", " + secondStr + " -> " + "false");
        }
    }

    /*
    5. Үг(word)ба тусгаарлагч (sep)гэсэнхоёр тэмдэгт мөр өгөгдөв. Тухайн word-г sep-ээр
    тусгаарлан countудаа давтаж том тэмдэгт мөр үүсгэ.
    ("Word", "X", 3) →"WordXWordXWord"
    ("This", "And", 2) →"ThisAndThis"
    ("This", "And", 1) →"This"
     */
    String bigStringCreator(){
        String word = inputString("Enter a word: ");
        String separate = inputString("Enter a separate: ");
        int count = inputNumber("Enter a loop number: ");
        StringBuilder bigString = new StringBuilder();
        for(int i = 0; i < count; i++){
            if(i == 0){
                bigString.append(word);
            }else{
                bigString.append(separate+word);
            }
        }
        return bigString.toString();
    }

    /*
    6. Текст файлын агуулгыг “урвуулдаг”програм зохио: анх өгөгдсөн текст
    файлын мөрүүдээс бүтэх боловч мөрүүд нь урвуу эрэмбэтэй бичигддэг файл
    үүсгэнэ: эхний мөр сүүлчийн мөр болно, хоёрдахь мөр нь сүүлээсээ өмнөх
    мөр болно гэх мэт.
    */
    final String filePath = "src/pro05_file.txt";
    void reverseFileLine() throws IOException {
        File file = new File(filePath);
        Scanner fileInput = new Scanner(file);
        File newFile  = new File("src/reversed_file.txt");
        if (newFile.createNewFile()) {
            System.out.println("File created: " + newFile.getName());
        } else {
            System.out.println("File already exists.");
            return;
        }
        PrintWriter newWriter = new PrintWriter(newFile);
        ArrayList<String> lines = new ArrayList<>();
        while(fileInput.hasNextLine()){
            lines.add(fileInput.nextLine());
        }
        Collections.reverse(lines);
        lines.forEach((line) -> {
            newWriter.println(line);
        });
        newWriter.close();
    }
}
