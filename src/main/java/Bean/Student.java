package Bean;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.security.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long stdId;

    private String stdName;
    private LocalDate stdBirthday;
    private String  stdGender;
    private int stdYearEnrolled;

    @ManyToOne
    private Programme programme;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Course_Student> course_students = new ArrayList<>();

    public Student() {
    }

    public Student(String stdName,LocalDate stdBirthday,String stdGender) {
        this.stdName = stdName;
        this.stdBirthday = stdBirthday;
        this.stdGender = stdGender;
    }


    public Student(String stdName,LocalDate stdBirthday,String stdGender,int stdYearEnrolled, Programme programme) {
        this.stdName = stdName;
        this.stdBirthday = stdBirthday;
        this.stdGender = stdGender;
        this.stdYearEnrolled = stdYearEnrolled;
        this.programme = programme;
    }

    public Student(long stdId,String stdName,LocalDate stdBirthday,String stdGender,int stdYearEnrolled, Programme programme) {

        this.stdId = stdId;
        this.stdName = stdName;
        this.stdBirthday = stdBirthday;
        this.stdGender = stdGender;
        this.stdYearEnrolled = stdYearEnrolled;
        this.programme = programme;
    }

    public long getStdId() {
        return stdId;
    }

    public void setStdId(long stdId) {
        this.stdId = stdId;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public LocalDate getStdBirthday() {
        return stdBirthday;
    }

    public void setStdBirthday(LocalDate stdBirthday) {
        this.stdBirthday = stdBirthday;
    }

    public String getStdGender() {
        return stdGender;
    }

    public void setStdGender(String stdGender) {
        this.stdGender = stdGender;
    }

    public int getStdYearEnrolled() {
        return stdYearEnrolled;
    }

    public void setStdYearEnrolled(int stdYearEnrolled) {
        this.stdYearEnrolled = stdYearEnrolled;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

}
