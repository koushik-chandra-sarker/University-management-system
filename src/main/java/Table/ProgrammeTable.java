package Table;

import Bean.School;

import javax.persistence.ManyToOne;

public class ProgrammeTable {
    private String  programCode;
    private String programTitle;
    private String programLabel;
    private int programLength;
    private String  programmeSclName;

    public ProgrammeTable(String programCode, String programTitle, String programLabel, int programLength, String programmeSclName) {
        this.programCode = programCode;
        this.programTitle = programTitle;
        this.programLabel = programLabel;
        this.programLength = programLength;
        this.programmeSclName = programmeSclName;
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

    public String getProgrammeSclName() {
        return programmeSclName;
    }

    public void setProgrammeSclName(String programmeSclName) {
        this.programmeSclName = programmeSclName;
    }
}
