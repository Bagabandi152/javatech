import java.io.*;
import java.util.Scanner;

public class MainApp {

    MainApp(){
        System.out.println("Problem#01: RegEx practice");
        charCounter();
        System.out.println("\nProblem#02:");
        try{
            readInFile();
        }catch (Exception exp){
            throw new RuntimeException(exp);
        }
        System.out.println("\nProblem#03:");
        try{
            replaceWordInFile();
        }catch (Exception exp){
            throw new RuntimeException(exp);
        }
    }

    public static void main(String[] args) {
        new MainApp();
    }

    String getStringFromOut(String str){
        System.out.println(str);
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    //Problem#01
    void charCounter(){
        String str = getStringFromOut("Enter a string: ");
        String[] lines = str.split("[\r|\n]");
        String[] words = str.split("[\\s]");
        int lineCnt = lines.length, charCnt = str.length(), wordCtn = words.length;
        System.out.println("\n" + charCnt + " characters");
        System.out.println("\n" + wordCtn + " words");
        System.out.println("\n" + lineCnt + " lines");
    }

    //Problem#02
    String filename = "src/demo.txt";
    void readInFile() throws FileNotFoundException {
        File file = new File(filename);
        Scanner fileInput = new Scanner(file);
        String searchVal = getStringFromOut("Enter a search value: ");
        int rowCnt = 0;
        while(fileInput.hasNextLine()){
            rowCnt++;
            if(fileInput.nextLine().equals(searchVal)){
                System.out.println("Result: search value = " + fileInput.nextLine() + ", found on " + rowCnt + " row.");
                break;
            }
        }
    }

    void replaceWordInFile() throws IOException {
        File file = new File(filename);
        Scanner fileInput = new Scanner(file);
        String searchVal = getStringFromOut("Enter a search value: ");
        String replaceVal = getStringFromOut("Enter a replace value: ");
        File newFile  = new File("filename.txt");
        if (newFile.createNewFile()) {
            System.out.println("File created: " + newFile.getName());
        } else {
            System.out.println("File already exists.");
            return;
        }

        PrintWriter newWriter = new PrintWriter(newFile);

        while(fileInput.hasNextLine()){
            if(fileInput.nextLine().equals(searchVal)){
                newWriter.println(replaceVal);
            }else{
                newWriter.println(fileInput.nextLine());
            }
        }
        newWriter.close();
    }
}
