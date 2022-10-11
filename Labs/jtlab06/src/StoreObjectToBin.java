import java.io.*;
import java.util.Date;

public class StoreObjectToBin {

    int[] arr = {1, 2, 3, 4, 5};
    Date date;
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;

    double db = 10.5;

    StoreObjectToBin() throws IOException, ClassNotFoundException {
        date = new Date();
        File file = new File("src/files/binObj.dat");
        outputStream = new ObjectOutputStream(new FileOutputStream(file));
        writeObjToBin();
        inputStream = new ObjectInputStream(new FileInputStream(file));
        readObjFromBin();
    }

    void writeObjToBin() throws IOException {
        outputStream.writeObject(date);
        outputStream.writeObject(arr);
        outputStream.writeObject(new Double(db));
        outputStream.close();
    }

    void readObjFromBin() throws IOException, ClassNotFoundException {
        Date date = (Date) inputStream.readObject();
        int[] arr = (int[]) inputStream.readObject();
        Double db = (Double) inputStream.readObject();

        System.out.println("date: " + date);
        System.out.println("arr: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("\tarr[" + i + "]: " + arr[i]);
        }
        System.out.println("db: " + db);
        inputStream.close();
    }

    public static void main(String[] args) {
        try {
            new StoreObjectToBin();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
