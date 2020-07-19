package Table;

import java.time.LocalDate;

public class StudentTable {

    private long studentId;
    private String studentName;
    private LocalDate studentBirthday;
    private String studentGender;
    private int studentYearEnrolled;
    private String studentProgramme;

    public StudentTable(long studentId, String studentName, LocalDate studentBirthday, String studentGender, int studentYearEnrolled, String studentProgramme) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentBirthday = studentBirthday;
        this.studentGender = studentGender;
        this.studentYearEnrolled = studentYearEnrolled;
        this.studentProgramme = studentProgramme;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDate getStudentBirthday() {
        return studentBirthday;
    }

    public void setStudentBirthday(LocalDate studentBirthday) {
        this.studentBirthday = studentBirthday;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public int getStudentYearEnrolled() {
        return studentYearEnrolled;
    }

    public void setStudentYearEnrolled(int studentYearEnrolled) {
        this.studentYearEnrolled = studentYearEnrolled;
    }

    public String getStudentProgramme() {
        return studentProgramme;
    }

    public void setStudentProgramme(String studentProgramme) {
        this.studentProgramme = studentProgramme;
    }
}