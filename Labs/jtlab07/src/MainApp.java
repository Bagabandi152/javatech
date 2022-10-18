import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class MainApp {

    MainApp(){
        try {
            ArrayList<String> arrayList = readTextFile();
            Collections.sort(arrayList, Collections.reverseOrder());
            Iterator<String> iter = arrayList.iterator();
            while(iter.hasNext()){
                System.out.println(iter.next());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    ArrayList<String> readTextFile() throws IOException {
        File file = new File("src/files/text.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        ArrayList<String> arrList = new ArrayList<>();
        while ((str = br.readLine()) != null) {
            String[] words = str.split(" ");
            for(int i = 0; i < words.length; i++){
                arrList.add(words[i]);
            }
        }
        return arrList;
    }

    public static void main(String[] args) {
        new MainApp();
    }
}
