package problem02;

import java.io.*;
import java.util.Random;

public class MainApp {

    /*
    2. Тус бүр нь 3 элементтэй бүхэл тоон массивуудыг хадгалдаг бинар файл өгөгдөв.
    Шинэ текст файл үүсгэж, түүн лүү элементүүдийн нийлбэр нь хамгийн их байдаг
    массивыг бичдэг програм зохио.
    Жич: өгөгдсөн бинар файлыг өөрсдөө програмын замаар үүсгэнэ. Энэ файлд байх
    массивуудын утгуудыг санамсаргүй тоо санагч хэрэглэж сонгоно.
    */

    File binFile, txtFile;
    DataOutputStream output = null;
    DataInputStream input = null;
    BufferedWriter outputWriter = null;

    MainApp() throws IOException {
        System.out.println("create files (bin and text file).");
        // create binary file and text file.
        binFile = new File("src/files/tmp2_1.dat");
        txtFile = new File("src/files/tmp2_2.txt");

        // write integer arrays to binary file
        writeToBinFile(binFile.exists());

        //read from bin file then find max sum array.
        readFromBinFile();

        //write max sum array to text file.
        writeToTxtFile();
    }

    void writeToBinFile(boolean isAppend) throws IOException {
        Random rand = new Random();
        try {
            output = new DataOutputStream(new FileOutputStream(binFile, isAppend));
            for (int i = 0; i < 100; i++) {
                byte[] arr = {(byte) rand.nextInt(100), (byte) rand.nextInt(100), (byte) rand.nextInt(100)};
                output.write(arr);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            output.close();
        }
    }

    byte[] maxBytes;

    void readFromBinFile() throws IOException {
        input = new DataInputStream(new FileInputStream(binFile));
        int maxSum = 0;
        try {
            while (true) {
                int sum = 0;
                byte[] bytes = input.readNBytes(3);
                for (int i = 0; i < bytes.length; i++) {
                    sum += bytes[i];
                }
                if (maxSum < sum) {
                    maxSum = sum;
                    maxBytes = bytes;
                }
            }
        } catch (EOFException ex) {
            System.out.println("All arrays were read in binary file.");
        } finally {
            input.close();
        }
    }

    void writeToTxtFile() throws IOException {
        outputWriter = new BufferedWriter(new FileWriter(txtFile));
        for (int i = 0; i < maxBytes.length; i++) {
            outputWriter.write(maxBytes[i] + ",");
        }
        outputWriter.flush();
        outputWriter.close();
    }

    public static void main(String[] args) {
        try {
            new MainApp();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
