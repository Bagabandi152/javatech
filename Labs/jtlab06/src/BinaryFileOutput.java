import java.io.*;
import java.util.Random;

public class BinaryFileOutput {
    File file;
    FileOutputStream output = null;

    BinaryFileOutput() throws IOException {
        file = new File("src/files/Exercise17_02.dat");
        writeToFile(file.exists());
    }

    void writeToFile(boolean isAppend) throws IOException {
        Random rand = new Random();
        try {
            output = new FileOutputStream(file, isAppend);
            for (int i = 0; i < 125; i++) {
                output.write(rand.nextInt());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            output.close();
        }
    }

    public static void main(String[] args) {
        try {
            new BinaryFileOutput();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
