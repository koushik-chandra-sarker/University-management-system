package Bean;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Programme {

    @Id
    private String  programCode;
    private String programTitle;
    private String programLabel;
    private int programLength;

    @ManyToOne
    private School schoolP;

    @OneToMany(mappedBy = "programme", cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

    @OneToMany(mappedBy = "programmeCourse",cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();

    @OneToMany(mappedBy = "programme",cascade = CascadeType.ALL)
    private List<Committee_Lecturer> committee_lecturers = new ArrayList<>();


    public Programme() {
    }

    public Programme(String programCode,String programTitle,String programLabel, int programLength) {
        this.programCode = programCode;
        this.programTitle = programTitle;
        this.programLabel = programLabel;
        this.programLength = programLength;

    }
    public Programme(String programCode,String programTitle,String programLabel, int programLength,School school) {
        this.programCode = programCode;
        this.programTitle = programTitle;
        this.programLabel = programLabel;
        this.programLength = programLength;
        this.schoolP = school;
    }

    public String getProgramCode() {
        return programCode;
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

    public String getProgramTitle() {
        return programTitle;
    }

    public void setProgramTitle(String programTitle) {
        this.programTitle = programTitle;
    }

    public String getProgramLabel() {
        return programLabel;
    }

    public void setProgramLabel(String programLabel) {
        this.programLabel = programLabel;
    }

    public int getProgramLength() {
        return programLength;
    }

    public void setProgramLength(int programLength) {
        this.programLength = programLength;
    }

    public School getSchoolP() {
        return schoolP;
    }

    public void setSchoolP(School schoolP) {
        this.schoolP = schoolP;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

}
