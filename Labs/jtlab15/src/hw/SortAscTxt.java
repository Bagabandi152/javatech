package hw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SortAscTxt {

    /*
    Бодлого №1. Текст файлд хадгалсан нэгэн шүлгийн бүх мөрийг уншиж авчраад жагсаалтад хадгална.
    Хадгалсан мөрүүдээ уртын хувьд өсөхөөр эрэмбэлж хэвлэх програм зохио.
     */

    ArrayList<String> textList = new ArrayList<>();

    SortAscTxt() {
        readInFile();
        //sorted() функц нь default - оор өсөхөөр эрэмбэлдэг. Ө.х sorted((a, b) -> a.length() - b.length()) --> sorted()

        //Өсөхөөр эрэмбэлэх
        System.out.println("ASC SORTED: ");
        textList.stream().sorted().forEach(System.out::println);

        //Буурахаар эрэмбэлэх
        System.out.println("\nDESC SORTED: ");
        textList.stream().sorted((a, b) -> b.length() - a.length()).forEach(System.out::println);
    }

    String filename = "src/files/MyNativeLand.txt";

    void readInFile() {
        try {
            File file = new File(filename);
            Scanner fileInput = new Scanner(file);
            while (fileInput.hasNextLine()) {
                String lineTxt = fileInput.nextLine();
                textList.add(lineTxt);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new SortAscTxt();
    }
}
