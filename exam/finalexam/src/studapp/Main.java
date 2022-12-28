package studapp;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Bagaa
 * @project finalexam
 * @created 28/12/2022 - 7:16 PM
 * @purpose
 * @definition
 */
public class Main {

    String filePath = "src/studapp/students.txt";
    Scanner input;
    Random random;
    ArrayList<Student> students;

    Main() {
        System.out.println("StudApp starting...");
        input = new Scanner(System.in);
        students = new ArrayList<>();
        createFile();
        while (true) {
            System.out.println("Choose one the following commands." + "\n\t1. Add student to file" + "\n\t2. Update student data on file" + "\n\t3. Delete student data from file" + "\n\t4. Display students data" + "\n\t0. Exit from StudApp");
            int command = input.nextInt();
            if (command == 0) {
                System.out.println("\nExited from StudApp...");
                break;
            } else if (command == 1) {
                String studCode = getNewStudCode();
                System.out.print("\nEnter lastname: ");
                String lName = input.nextLine();
                System.out.print("\nEnter firstname: ");
                String fName = input.nextLine();
                System.out.print("\nEnter GAP: ");
                Double grade = input.nextDouble();
                String charGrade = getCharGrade(grade);
                try {
                    writeToFile(lName + " " + fName + " " + studCode + " " + grade + " " + charGrade);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (command == 2) {

            } else if (command == 3) {

            } else if (command == 4) {
                try {
                    readFromFile();
                    students.forEach(System.out::println);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Command not found!");
                continue;
            }
        }
    }

    Student strToStud(String str) {
        String[] strArr = str.split(" ");
        return new Student(strArr[0], strArr[1], strArr[2], strArr[3], strArr[4]);
    }

    void writeToFile(String student) throws IOException {
        File fOut = new File(filePath);
        FileOutputStream fos = new FileOutputStream(fOut);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        for (int i = 0; i < 10; i++) {
            bw.write(student);
            bw.newLine();
        }
        bw.close();
    }

    void readFromFile() throws FileNotFoundException {
        File myObj = new File(filePath);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            students.add(strToStud(data));
        }
        myReader.close();
    }

    void createFile() {
        try {
            File myObj = new File(filePath);
            if (myObj.createNewFile()) {
                System.out.println("students.txt file created.\n");
            } else {
                System.out.println("students.txt file already exists.\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String getNewStudCode() {
        random = new Random();
        return Integer.toString(random.nextInt(100000, 999999));
    }

    String getCharGrade(Double grade) {
        if (90 <= grade && grade <= 100) {
            return "A";
        } else if (80 <= grade && grade < 90) {
            return "B";
        } else if (70 <= grade && grade < 80) {
            return "C";
        } else if (60 <= grade && grade < 70) {
            return "D";
        } else if (grade < 60) {
            return "F";
        } else {
            return "W";
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
