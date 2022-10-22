package problem01;

import java.io.*;
import java.util.Random;

public class MainApp {

    /*
    1. Бүхэл тоон утгууд хадгалдаг бинар файл өгөгдөв. Энэ файлын бүх тоог өөр файлд
    бичих ба төгсгөлд нь дээрх тоонуудын нийлбэр болон дундаж утгыг бич.
    Жич: өгөгдсөн бинар файлыг өөрсдөө програмын замаар үүсгэнэ.
    */

    File file, anotherFile;
    DataOutputStream output = null;
    DataInputStream input = null;

    MainApp() throws IOException {
        System.out.println("create files.");
        // create binary file and another binary file.
        file = new File("src/files/tmp1_1.dat");
        anotherFile = new File("src/files/tmp1_2.dat");

        // write integers to binary file
        writeToBinFile(file.exists());

        //copy binary file that contains integers to another binary file. Then calculate sum and average of binary file.
        copyBinFileThenCalcSum(anotherFile.exists());
        System.out.println("Sum: " + sum);
        System.out.println("Counter: " + counter);
        System.out.println("Average: " + (sum*1.0) / counter);
    }

    void writeToBinFile(boolean isAppend) throws IOException {
        Random rand = new Random();
        try {
            output = new DataOutputStream(new FileOutputStream(file, isAppend));
            for (int i = 0; i < 100; i++) {
                output.writeInt(rand.nextInt(100));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            output.close();
        }
    }

    int sum = 0, counter = 0;

    void copyBinFileThenCalcSum(boolean isAppend) throws IOException {
        try {
            output = new DataOutputStream(new FileOutputStream(anotherFile, isAppend));
            input = new DataInputStream(new FileInputStream(file));
            sum = counter = 0;
            try {
                while (true) {
                    output.writeInt(input.readInt());
                    sum += input.readInt();
                    counter++;
                }
            } catch (EOFException ex) {
                System.out.println("All integers were read in binary file.");
            } finally {
                input.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            output.close();
        }
    }

    public static void main(String[] args) {
        try {
            new MainApp();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
