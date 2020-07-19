package Table;

public class LecturerTable {
    private long  id;
    private String name;
    private String title;
    private String officeRoom;
    private String school;
    private String supervisor;

    public LecturerTable(long id, String name, String title, String officeRoom, String school, String supervisor) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.officeRoom = officeRoom;
        this.school = school;
        this.supervisor = supervisor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String  getOfficeRoom() {
        return officeRoom;
    }

    public void setOfficeRoom(String officeRoom) {
        this.officeRoom = officeRoom;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }
}
