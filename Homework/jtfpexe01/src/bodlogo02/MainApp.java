package bodlogo02;

import java.util.Scanner;

public class MainApp {

    /*
    Бодлого №2. Файлаас бүх текстийг унших ба гарнаас оруулсан үсгийг агуулдаг эхний 10 ялгаатай үгийг хайж ол.
    Үгүүд 5-аас цөөнгүй үсгээс бүтсэн байна. Үгүүд нь цагаан толгойн дарааллаар эрэмбэлэгдсэн,
    жижиг үсгүүдээр бичигдсэн байна. Хэрэв ийм үгүүд 10-аас цөөн тоотой байвал тэдгээр үгийг олно,
    харин ийм үгүүд байхгүй бол энэ талаар мэдэгдэнэ.
    */
    MainApp() {
        System.out.println("Enter search a word: ");
        Scanner scanner = new Scanner(System.in);
        FileReader.printValue(FileReader::readInFile, scanner.next());
    }

    public static void main(String[] args) {
        new MainApp();
    }
}
