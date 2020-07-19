package Bean;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    private String courseCode;

    @ManyToOne
    private Programme programmeCourse;
    private String courseTitle;

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Course_Student> course_students = new ArrayList<>();

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Lecturer_Course> lecturer_courses = new ArrayList<>();

    public Course() {
    }

    public Course(String courseCode, String courseTitle) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
    }
    public Course(String courseCode, String courseTitle,Programme programme) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.programmeCourse = programme;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Programme getProgrammeCourse() {
        return programmeCourse;
    }

    public void setProgrammeCourse(Programme programmeCourse) {
        this.programmeCourse = programmeCourse;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }


    public List<Course_Student> getCourse_students() {
        return course_students;
    }

    public void setCourse_students(List<Course_Student> course_students) {
        this.course_students = course_students;
    }

    public List<Lecturer_Course> getLecturer_courses() {
        return lecturer_courses;
    }

    public void setLecturer_courses(List<Lecturer_Course> lecturer_courses) {
        this.lecturer_courses = lecturer_courses;
    }
}
