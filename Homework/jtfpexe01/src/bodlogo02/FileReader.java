package bodlogo02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {
    static String filename = "src/bodlogo02/file.txt";

    static void readInFile(String searchVal) {
        try {
            File file = new File(filename);
            Scanner fileInput = new Scanner(file);
            ArrayList<String> arrayList = new ArrayList<>();
            while (fileInput.hasNextLine()) {
                String lineTxt = fileInput.nextLine();
                if (lineTxt.toLowerCase().contains(searchVal.toLowerCase()) && !lineTxt.equalsIgnoreCase(searchVal)) {
                    arrayList.add(lineTxt);
                }
            }

            Stream<String> stream = arrayList.stream();
            System.out.println("\nAnswer: ");
            if (stream.distinct().collect(Collectors.toList()).size() >= 10) {
                final int[] index = {0};
                arrayList.stream().forEach(str -> {
                    if (index[0] < 10) {
                        System.out.println("\t" + (index[0] + 1) + ". " + str);
                    }
                    index[0]++;
                });
            } else {
                System.out.println("Sorry, Search value not found 10 units from text file.");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static void printValue(Consumer<String> consumer, String str) {
        consumer.accept(str);
    }
}
