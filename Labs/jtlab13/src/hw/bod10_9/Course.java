package hw.bod10_9;

import java.util.function.Consumer;

public class Course implements Cloneable {
    private String courseName;
    private static String[] students = new String[10];
    private static int numberOfStudents;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public static void addStudent(String student) {
        if (numberOfStudents >= students.length) {
            String[] temp = new String[students.length * 2];
            System.arraycopy(students, 0, temp, 0, students.length);
            students = temp;
        }
        students[numberOfStudents++] = student;
    }

    public void runAddStudent(String student, Consumer<String> customer) {
        customer.accept(student);
    }

    public String[] getStudents() {
        return students;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public static void dropStudent(String student) {
        for (int i = 0; i < students.length; i++) {
            if (student.equalsIgnoreCase(students[i])) {
                students[i] = null; // sets dropped student's value to null
                numberOfStudents--;
                while (i < numberOfStudents) {
                    students[i] = students[i + 1];
                    i++;
                }
                break;
            }
        }
    }

    public void runDropStudent(String student, Consumer<String> consumer) {
        consumer.accept(student);
    }

    public void clear() {
        students = new String[25];
        numberOfStudents = 0;
    }

    public Object clone() {
        Course course = null;
        try {
            course = (Course) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        course.students = students.clone();
        course.courseName = new String(courseName);

        return course;
    }
}
