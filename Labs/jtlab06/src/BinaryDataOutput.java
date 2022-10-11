import java.awt.desktop.SystemEventListener;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class BinaryDataOutput {
    File file;
    DataOutputStream output = null;
    DataInputStream input = null;

    BinaryDataOutput() throws IOException {
        System.out.println("create a file.");
        file = new File("src/files/Exercise17_03.dat");
        writeToFile(file.exists());
        sumNumbers();
        System.out.println("Sum: " + sum);
    }

    void writeToFile(boolean isAppend) throws IOException {
        Random rand = new Random();
        try {
            output = new DataOutputStream(new FileOutputStream(file, isAppend));
            for (int i = 0; i < 125; i++) {
                output.write(rand.nextInt(100));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            output.close();
        }
    }

    int sum = 0;

    void sumNumbers() throws IOException {
        input = new DataInputStream(new FileInputStream(file));
        try {
            while (true) {
                sum += input.readInt();
            }
        } catch (EOFException ex) {
            System.out.println("All integers were read");
        } finally {
            input.close();
        }
    }

    public static void main(String[] args) {
        try {
            new BinaryDataOutput();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
