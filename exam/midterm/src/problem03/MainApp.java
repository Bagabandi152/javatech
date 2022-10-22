package problem03;

import java.io.*;
import java.util.Date;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class MainApp {

    /*
    3. Киноны мэдээлэл хадгалдаг класс зохио:
        • Киноны нэр, бүтээсэн он, бүтээсэн улс, төрөл, бүтээсэн нийт өртөг
    Олон киноны мэдээллийг хадгалдаг файлд үүсгэ. Энэ файлаас дараах мэдээлэл
    олоход тусалдаг програм зохио.
        – хамгийн өндөр өртгөөр бүтсэн киног ол;
        – хамгийн эрт хийгдсэн киноны мэдээлэлийг ол;
    Жич: энэ бодлогод хэрэглэгдэх өгөгдлийг интернэтээс хайн олж болно.
    ЗӨВЛӨГӨӨ: энэ бодлогод ObjectStream буюу объект элементүүдийн урсгал
        үүсгэн ашиглаж болно. Эсвэл RandomAccess файл хэрэглэх боломжтой
    */

    static final String filepath = "src/files/";
    ObjectOutputStream objectOut;
    FileOutputStream fileOut;

    MainApp() throws IOException {
        System.out.println("create movies file.");
        writeToFile();

        // хамгийн өндөр өртгөөр бүтсэн киног олох;
        maxTotalPriceMovie();
        // хамгийн эрт хийгдсэн киноны мэдээлэлийг олох;
        mostEarlyMovie();
    }

    void writeToFile() throws IOException {
        try {
            fileOut = new FileOutputStream(filepath);
            objectOut = new ObjectOutputStream(fileOut);
            for (int i = 0; i < 100; i++) {
                objectOut.writeObject(new Movie(("movie" + i), new Date(), ("country" + 1), ("type" + i), i * 100.0));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            objectOut.close();
        }
    }

    void mostEarlyMovie() {

    }


    void maxTotalPriceMovie() {

    }

    public static void main(String[] args) {
        try {
            new MainApp();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
