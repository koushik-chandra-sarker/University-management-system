package Bean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Campus {
    @Id
    @GeneratedValue
    private int CampId;
    private String CampName;
    private String CampAddress;

    @OneToMany(mappedBy = "Campus",cascade = CascadeType.ALL)
    private List<School> school = new ArrayList<>();

   public Campus() {
    }

    public Campus(String campName, String campAddress) {
        CampName = campName;
        CampAddress = campAddress;
    }


    public Campus(String campName, String campAddress, List<School> school) {
        CampName = campName;
        CampAddress = campAddress;
        this.school = school;
    }

    public int getCampId() {
        return CampId;
    }

    public void setCampId(int campId) {
        CampId = campId;
    }

    public String getCampName() {
        return CampName;
    }

    public void setCampName(String campName) {
        CampName = campName;
    }

    public String getCampAddress() {
        return CampAddress;
    }

    public void setCampAddress(String campAddress) {
        CampAddress = campAddress;
    }

    public List<School> getSchool() {
        return school;
    }

    public void setSchool(List<School> school) {
        this.school = school;
    }
}
