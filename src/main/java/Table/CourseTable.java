package Table;

public class CourseTable {

    private String Course_code;
    private String Course_title;
    private String Programme;

    public CourseTable(String course_code, String course_title, String programme) {
        Course_code = course_code;
        Course_title = course_title;
        Programme = programme;
    }

    public String getCourse_code() {
        return Course_code;
    }

    public void setCourse_code(String course_code) {
        Course_code = course_code;
    }

    public String getCourse_title() {
        return Course_title;
    }

    public void setCourse_title(String course_title) {
        Course_title = course_title;
    }

    public String getProgramme() {
        return Programme;
    }

    public void setProgramme(String programme) {
        Programme = programme;
    }
}