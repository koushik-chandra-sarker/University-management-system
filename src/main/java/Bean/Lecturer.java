package Bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Lecturer implements Serializable {
    @Id
    @GeneratedValue
    private long StfId;

    @ManyToOne
    private School schoolId;

    @ManyToOne
    @JoinColumn
    private Lecturer supId;

    @OneToMany(mappedBy = "supId",cascade = CascadeType.ALL)
    private List<Lecturer> lecturer = new ArrayList<>();

    private String  lecturerName;
    private String  lecturerTitle;
    private String  officeRoom;

    @OneToMany(mappedBy = "lecturer",cascade = CascadeType.ALL)
    private List<Lecturer_Course> lecturer_courses = new ArrayList<>();

    @OneToMany(mappedBy = "lecturer",cascade = CascadeType.ALL)
    private List<Committee_Lecturer> committee_lecturers = new ArrayList<>();

    @OneToMany(mappedBy = "lecturer",cascade = CascadeType.ALL)
    private List<Course_Student> course_students = new ArrayList<>();


    public Lecturer() {
    }

    public Lecturer(long stfId, String lecturerName, String lecturerTitle, String officeRoom, School schoolId, Lecturer supId) {
        StfId = stfId;

        this.lecturerName = lecturerName;
        this.lecturerTitle = lecturerTitle;
        this.officeRoom = officeRoom;
        this.schoolId = schoolId;
        this.supId = supId;
    }

    public Lecturer( String lecturerName, String lecturerTitle, String officeRoom, School schoolId, Lecturer supId) {

        this.lecturerName = lecturerName;
        this.lecturerTitle = lecturerTitle;
        this.officeRoom = officeRoom;
        this.schoolId = schoolId;
        this.supId = supId;
    }

    public Lecturer( String lecturerName, String lecturerTitle, String officeRoom, School schoolId) {
        this.lecturerName = lecturerName;
        this.lecturerTitle = lecturerTitle;
        this.officeRoom = officeRoom;
        this.schoolId = schoolId;
    }

    public long getStfId() {
        return StfId;
    }

    public void setStfId(long stfId) {
        StfId = stfId;
    }

    public School getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(School schoolId) {
        this.schoolId = schoolId;
    }

    public Lecturer getSupId() {
        return supId;
    }

    public void setSupId(Lecturer supId) {
        this.supId = supId;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public String getLecturerTitle() {
        return lecturerTitle;
    }

    public void setLecturerTitle(String lecturerTitle) {
        this.lecturerTitle = lecturerTitle;
    }

    public String getOfficeRoom() {
        return officeRoom;
    }

    public void setOfficeRoom(String officeRoom) {
        this.officeRoom = officeRoom;
    }



    public List<Lecturer> getLecturer() {
        return lecturer;
    }

    public void setLecturer(List<Lecturer> lecturer) {
        this.lecturer = lecturer;
    }

    public List<Lecturer_Course> getLecturer_courses() {
        return lecturer_courses;
    }

    public void setLecturer_courses(List<Lecturer_Course> lecturer_courses) {
        this.lecturer_courses = lecturer_courses;
    }

    public List<Committee_Lecturer> getCommittee_lecturers() {
        return committee_lecturers;
    }

    public void setCommittee_lecturers(List<Committee_Lecturer> committee_lecturers) {
        this.committee_lecturers = committee_lecturers;
    }

    public List<Course_Student> getCourse_students() {
        return course_students;
    }

    public void setCourse_students(List<Course_Student> course_students) {
        this.course_students = course_students;
    }
}
