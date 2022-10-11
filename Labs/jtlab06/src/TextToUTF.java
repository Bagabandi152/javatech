import java.io.*;

public class TextToUTF {

    TextToUTF() {
        try {
            readTextFile();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void readTextFile() throws IOException {
        File file = new File("src/files/tmp.txt");
        File binFile = new File("src/files/utf.dat");
        BufferedReader br = new BufferedReader(new FileReader(file));
        DataOutputStream output = new DataOutputStream(new FileOutputStream(binFile));
        String str;
        while ((str = br.readLine()) != null) {
            output.writeUTF(str);
        }
        output.close();

        System.out.println("text file: " + file.length());
        System.out.println("utf file: " + binFile.length());
    }

    public static void main(String[] args) {
        new TextToUTF();
    }
}
