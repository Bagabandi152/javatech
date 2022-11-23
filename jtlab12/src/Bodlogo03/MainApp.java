package Bodlogo03;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

    MainApp(String str, String splitter) {
        FuncInterface funcInterface = (s, regex, type) -> {
            ArrayList<String> temp = new ArrayList<>();
            if (type.equals("word")) {
                int newIndex = 0;
                for (int i = 0; i < s.length() - regex.length(); i++) {
                    if (regex.compareTo(s.substring(i, i + regex.length())) == 0) {
                        temp.add(s.substring(newIndex, i));
                        temp.add(regex);
                        newIndex = i + regex.length();
                    }

                }
                temp.add(s.substring(newIndex));
                return temp.toArray(new String[temp.size()]);
            } else if (type.equals("array")) {
                char[] regexChars = getRegex(regex);
                int newIndex = 0;
                for (int i = 0; i < s.length(); i++) {
                    char ch = s.charAt(i);
                    for (int j = 0; j < regexChars.length; j++) {
                        if (ch == regexChars[j]) {
                            if (newIndex != i) temp.add(s.substring(newIndex, i));
                            temp.add("" + regexChars[j]);
                            newIndex = i + 1;
                        }
                    }
                }
                temp.add(s.substring(newIndex));
                return temp.toArray(new String[temp.size()]);
            } else {
                return new String[0];
            }
        };

        System.out.print("Split string: ");
        for (String s : funcInterface.split(str, splitter)) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    char[] getRegex(String regex) {
        if (regex.charAt(0) != '[' && regex.charAt(regex.length() - 1) != ']') return regex.toCharArray();
        else return regex.substring(1, regex.length() - 1).toCharArray();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        System.out.print("Enter a regex: ");
        String regex = scanner.nextLine();
        new MainApp(str, regex);
    }
}
