package Bean;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class School {
    @Id
    @GeneratedValue
    private int schoolId;
    private String schoolName;
    private String schoolBuilding;

    @ManyToOne
    private Campus Campus;

    @OneToMany(mappedBy = "schoolP",cascade = CascadeType.ALL)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Programme> programme = new ArrayList<>();


    @OneToMany(mappedBy = "schoolId")
    private List<Lecturer> lecturers = new ArrayList<>();

    public School() {
    }
    public School(String schoolName, String schoolBuilding ) {

        this.schoolName =schoolName;
        this.schoolBuilding = schoolBuilding;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolBuilding() {
        return schoolBuilding;
    }

    public void setSchoolBuilding(String schoolBuilding) {
        this.schoolBuilding = schoolBuilding;
    }

    public Bean.Campus getCampus() {
        return Campus;
    }

    public void setCampus(Bean.Campus campus) {
        Campus = campus;
    }

    public List<Programme> getProgramme() {
        return programme;
    }

    public void setProgramme(List<Programme> programme) {
        this.programme = programme;
    }

}
