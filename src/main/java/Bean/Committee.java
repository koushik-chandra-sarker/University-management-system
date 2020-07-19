package Bean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Committee {
    @Id
    private String committeeTitle;

    @ManyToOne
    private Programme programme;

    private String meetingFreq;

    @OneToMany(mappedBy = "committee",cascade = CascadeType.ALL)
    private List<Committee_Lecturer> committee_lecturers = new ArrayList<>();

    public Committee() {
    }

    public Committee(String committeeTitle, Programme programme, String meetingFreq) {
        this.committeeTitle = committeeTitle;
        this.programme = programme;
        this.meetingFreq = meetingFreq;
    }

    public String getCommitteeTitle() {
        return committeeTitle;
    }

    public void setCommitteeTitle(String committeeTitle) {
        this.committeeTitle = committeeTitle;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public String getMeetingFreq() {
        return meetingFreq;
    }

    public void setMeetingFreq(String meetingFreq) {
        this.meetingFreq = meetingFreq;
    }
}
