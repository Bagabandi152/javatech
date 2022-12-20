import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainApp {

    /*
    Явц №2. Дараах бодлогыг функциональ програмчлал ашиглан бодоорой.
    Өгөгдсөн диск (тухайлбал, C:, D:, гэх мэт) -ээс өгөгдсөн үгийг агуулдаг текст файлын
    нэрс ба тухайн файлд хэдэн удаа давтагдаж орсон тоо зэргийг олдог програм зохио.
     */

    ArrayList<File> textFileList;
    ArrayList<SearchInfo> searchInfoList;
    Scanner input;
    JFileChooser fileChooser;
    FileFilter filter;
    String initPath = "C:\\text";
    String search;

    @FunctionalInterface
    public interface CustomFuncInterface {
        void isTextFile(File file);
    }

    CustomFuncInterface customFuncInterface;

    MainApp() {
        filter = new FileNameExtensionFilter("Txt file", "txt");
        fileChooser = new JFileChooser();
        input = new Scanner(System.in);
        textFileList = new ArrayList<>();
        searchInfoList = new ArrayList<>();

        System.out.print("Enter search a word: ");
        search = input.nextLine();

        customFuncInterface = (file) -> {
            if (file.isFile() && fileChooser.accept(file)) {
                textFileList.add(file);
            } else if (file.isDirectory()) {
                getFiles(file.getPath());
            }
        };
        fileChooser.addChoosableFileFilter(filter);
        getFiles(initPath);

        System.out.println("\nFilename,\tSearch,\tCount");
        textFileList.stream().forEach(file -> {
            try (Stream<String> stream = Files.lines(file.toPath()).filter(filename -> filename.equalsIgnoreCase(search))) {
                searchInfoList.add(new SearchInfo(file.getName(), search, stream.collect(Collectors.toList()).size()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        searchInfoList.stream().map(searchInfo -> (searchInfo.getFileName() + ",\t" + searchInfo.getSearchVal() + ",\t" + searchInfo.getCount())).forEach(System.out::println);
    }

    void getFiles(String filepath) {
        File disk = new File(filepath);
        File[] fileList = disk.listFiles();
        Arrays.stream(fileList).forEach(customFuncInterface::isTextFile);
    }

    public static void main(String[] args) {
        new MainApp();
    }
}
