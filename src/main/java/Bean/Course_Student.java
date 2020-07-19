package Bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course_Student implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn
    private Course course;

    @Id
    @ManyToOne
    @JoinColumn
    private Student student;

    @Id
    @ManyToOne
    @JoinColumn
    private Lecturer lecturer;

    private String  yearTaken;
    private String semesterTaken;
    private String gradeAward;



    public Course_Student() {
    }

    public Course_Student(String yearTaken, String semesterTaken, String gradeAward) {
        this.yearTaken = yearTaken;
        this.semesterTaken = semesterTaken;
        this.gradeAward = gradeAward;
    }

    public Course_Student(Course course, Student student,String yearTaken, String semesterTaken, String gradeAward, Lecturer lecturer) {
        this.course = course;
        this.student = student;
        this.yearTaken = yearTaken;
        this.semesterTaken = semesterTaken;
        this.gradeAward = gradeAward;
        this.lecturer = lecturer;
    }
    public Course_Student(Course course, Student student) {
        this.course = course;
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getYearTaken() {
        return yearTaken;
    }

    public void setYearTaken(String yearTaken) {
        this.yearTaken = yearTaken;
    }

    public String getSemesterTaken() {
        return semesterTaken;
    }

    public void setSemesterTaken(String semesterTaken) {
        this.semesterTaken = semesterTaken;
    }

    public String getGradeAward() {
        return gradeAward;
    }

    public void setGradeAward(String gradeAward) {
        this.gradeAward = gradeAward;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }
}
