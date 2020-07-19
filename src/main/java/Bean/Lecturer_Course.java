package Bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Lecturer_Course implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn
    private Lecturer lecturer;

    @Id
    @ManyToOne
    @JoinColumn
    private Course course;

    public Lecturer_Course() {
    }

    public Lecturer_Course(Lecturer lecturer, Course course) {
        this.lecturer = lecturer;
        this.course = course;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
