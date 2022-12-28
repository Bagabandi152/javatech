package studapp;

/**
 * @author Bagaa
 * @project finalexam
 * @created 28/12/2022 - 7:39 PM
 * @purpose
 * @definition
 */
public class Student {
    String lName;
    String fName;
    String studCode;
    String grade;
    String gradeChar;

    public Student(String lName, String fName, String studCode, String grade, String gradeChar) {
        this.lName = lName;
        this.fName = fName;
        this.studCode = studCode;
        this.grade = grade;
        this.gradeChar = gradeChar;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getStudCode() {
        return studCode;
    }

    public void setStudCode(String studCode) {
        this.studCode = studCode;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGradeChar() {
        return gradeChar;
    }

    public void setGradeChar(String gradeChar) {
        this.gradeChar = gradeChar;
    }
}
