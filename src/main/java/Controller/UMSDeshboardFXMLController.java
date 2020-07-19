package Controller;

import Bean.*;
import DAO.*;
import Helper.factoryProvider;
import Table.CourseTable;
import Table.LecturerTable;
import Table.ProgrammeTable;
import Table.StudentTable;
import animatefx.animation.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class UMSDeshboardFXMLController implements Initializable {

    @FXML
    private Button dashboardBtn, btn_2, StudentBtn, courseBtn, courseAddBtn, btn_5,
            sclAddBtn, progAddBtn, campusAddBtn, stdAddBtn, StudentDeleteBtn,
            studentUpdateBtn, seePrgListBtn, prgUpdateBtn, prgDeleteBtn,prgUpdateActionBtn,
            courseUpdateBtn,courseDeleteBtn, courseUpdateActionBtn,lecAddBtn, lecAddActionBtn,
            lecturerBtn, updateLecBtn, updateLecActionBtn, deleteLecBtn, lecCourseInfo,
            addLecCourse, dropLecCourse, StdCourseInfoBtn, addStdCourseBtn, dropStudentCourseBtn,
            updateStdGradeBtn,stdUpdateActionBtn;

    @FXML
    private AnchorPane dashboardPage, page2, studentPage, coursePage, programmeListPage,
            updatePrgPage, updateCoursePage, AddLecPage, lecturerPage, updateLecPage, lecCoursePage,
            stdCoursePage,updateStdPage;

    @FXML
    private Label lecCourseLecIdLabel, lecCourseLecNameLabel, lecCourseLecTitleLabel, lecCourseLecOfficeLabel,
            lecCourseLecSchoolLabel, lecCourseLecSupLabel, stdCourseStdIdLabel, stdCourseStdNameLabel, stdCourseStdPrgLabel;

    @FXML
    private TextField /*stdNameField,*/ stdEnrolledYearField;


//    @FXML
//    private ComboBox stdGenderCombo;

//    @FXML
//    private ComboBox stdPrgCombo;
//    ObservableList<String> programmeList = FXCollections.observableArrayList();

   /* @FXML
    private DatePicker stdBirthdayPicker;*/

    @FXML
    private ComboBox<String> sclcombo = new ComboBox<String>();
    @FXML
    private Button ld;
    ObservableList<String> stateList = FXCollections.observableArrayList();

    @FXML
    private ComboBox<String> progCombo = new ComboBox<>();
    ObservableList<String> schoolList = FXCollections.observableArrayList();

    @FXML
    private ComboBox<String> courseCombo = new ComboBox<>();
    ObservableList<String> programmeList = FXCollections.observableArrayList();

    @FXML
    private ComboBox<String> stdGenderCombo = new ComboBox<>();

    @FXML
    private ComboBox<String> stdPrgCombo = new ComboBox<>();
    ObservableList<String> programmeList1 = FXCollections.observableArrayList();

    @FXML
    private TextField sclNameFIeld, sclBuildingField, progCodeField, progTitleField, progLabelField,
            progLengthField, campusNameField, campusAddressField, courseCodeField, courseTitleField,
            stdNameField, stdEnrolledYear, stdUpdateIdField, stdUpdateNameField, stdUpdateEnrolledYearField, updatePrgCodeField, updatePrgTitleField, updatePrgLabelField,
            updatePrgLengthField, updateCourseCodeField, updateCourseTitleField, lecNameField,
            lecTitleField,lecOfficeRoomField, updateIdField,updateLecNameField, updateLecTitleField, updateLecOfficeRoomField,
            stdGradeAwardField;
    @FXML
    private ComboBox updatePrgCombo,updateCourseCombo,lecSclCombo,lecSupCombo, updateLecSclCombo, updateLecSupCombo,
            stdSemesterCombo, stdSemesterYearCombo, stdUpdateGenderCombo, stdUpdatePrgCombo;
    ObservableList<String> stdSemesterList = FXCollections.observableArrayList();


    @FXML
    private ListView<String> sclListView = new ListView<>();
    ObservableList<String> schoolList2 = FXCollections.observableArrayList();
    ObservableList<String> lecturerList = FXCollections.observableArrayList();
    @FXML
    private ListView lecCourseListView, lecGivenCourseListView,stdCourseListView, stdGivenCourseListView;
    ObservableList<String> lecCourseList = FXCollections.observableArrayList();
    ObservableList<String> lecGivenCourseList = FXCollections.observableArrayList();
    ObservableList<String> stdCourseList = FXCollections.observableArrayList();
    ObservableList<String> stdGivenCourseList = FXCollections.observableArrayList();


    @FXML
    private DatePicker stdBirthdayPicker, stdUpdateBirthdayPicker;

    @FXML
    private TableView courseTableView, StudentTableView, prgTableView ,lecTableView;
    @FXML
    private TableColumn tbCourseCode, tbCourseTitle, tbCourseProgramme,tbStudentId, tbStudentName,
            tbStudentBirthday, tbStudentGender, tbStudentYearEnrolled, tvStudentProgramme, tbPrgCode,
            tbPrgTitle, tbPrgLabel, tbPrgLength, tbPrgSclName, tbLecId, tbLecName, tbLecTitle,
            tbLecOffice, tbLecSchool,tbLecSupervisor;
    ObservableList<CourseTable> courseList = FXCollections.observableArrayList();//for Course table
    ObservableList<StudentTable> StudentList = FXCollections.observableArrayList(); //for Student table
    ObservableList<ProgrammeTable> programmeList2 = FXCollections.observableArrayList();//for See Programme List
    ObservableList<LecturerTable> tableLecturerList = FXCollections.observableArrayList(); //for Lecturer table.


    @FXML
    private ImageView PrgBack, updatePrgClose, closeUpdateCourseBtn,closeAddLecPage, closeUpdateLecPage, closeLecCoursePage, closeStdCoursePage, closeUpdateStd;

    @Override
    public void initialize(URL event, ResourceBundle rb) {
        loadSclCombo();
        loadProgCombo();
        loadSchoolList();
        loadCourseCombo();
        setCourseTable();
        stdGenderCombo.getItems().addAll("Male", "Female");
        loadStudentCombo();
        setStudentTable();
        loadUpdatePrgCombo();
        setLecturerTable();
    }


    public void pageControlAction(ActionEvent event) {
        if (event.getSource() == dashboardBtn) {
            dashboardPage.toFront();
            new FadeInRight(dashboardPage).play();
        } else if (event.getSource() == btn_2) {
            page2.toFront();
            new FadeInRight(page2).play();
        } else if (event.getSource() == StudentBtn) {
            studentPage.toFront();
            new FadeInRight(studentPage).play();
        } else if (event.getSource() == courseBtn) {
            coursePage.toFront();
            new FadeInRight(coursePage).play();
        }
         else if (event.getSource() == lecturerBtn) {
            lecturerPage.toFront();
            new FadeInRight(lecturerPage).play();
        }

    }


    @FXML
    private void ButtonHandleAction(ActionEvent event) {
        if (event.getSource() == sclAddBtn) {
            if (sclNameFIeld.getText().trim().equals("")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("School name is Empty ! Fill the Field...");
                alert.show();
            }
            else if (sclBuildingField.getText().trim().equals("")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("School building is Empty ! Fill the Field...");
                alert.show();
            }
            else if (sclcombo.getItems().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("School not Selected ! Select a School...");
                alert.show();
            }
            else {
                String sclName = sclNameFIeld.getText();
                String sclBuilding = sclBuildingField.getText();
                String campusName = sclcombo.getValue();


                Campus campus = new Campus();
                CampusDAO campusDAO = new CampusDAO();

                campus = campusDAO.selectCampusByName(campusName);

                School school = new School(sclName, sclBuilding);
                school.setCampus(campus);
                SchoolDAO schoolDAO = new SchoolDAO();
                schoolDAO.addSchool(school);

                loadSchoolList();
                loadProgCombo();
                sclNameFIeld.setText("");
                sclBuildingField.setText("");
                sclcombo.setValue(null);
            }
        }
        else if (event.getSource() == progAddBtn) {

            if (progCodeField.getText().trim().equals("")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Programme code is Empty ! Fill the Field...");
                alert.show();
            }
            else if (progTitleField.getText().trim().equals("")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Programme title is Empty ! Fill the Field...");
                alert.show();
            }
            else if (progLabelField.getText().trim().equals("")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Programme label is Empty ! Fill the Field...");
                alert.show();
            }
            else if (progLengthField.getText().trim().equals("")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Programme length is Empty ! Fill the Field...");
                alert.show();
            }
            else if (progCombo.getValue()==null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("School not Selected ! Select a School...");
                alert.show();
            }
            else if (!progLengthField.getText().trim().equals("")){
                try
                {
                    Integer.parseInt(progLengthField.getText());
                    String code = progCodeField.getText();
                    String title = progTitleField.getText();
                    String label = progLabelField.getText();
                    int length = Integer.parseInt(progLengthField.getText());
                    String schoolName = progCombo.getValue();


                    SchoolDAO schoolDAO = new SchoolDAO();

                    School school = new School();
                    school = schoolDAO.selectSchoolByName(schoolName);

                    Programme programme = new Programme(code, title, label, length, school);
                    ProgrammeDAO programmeDAO = new ProgrammeDAO();
                    programmeDAO.addProgramme(programme);


                    loadCourseCombo();
                    progCodeField.setText("");
                    progTitleField.setText("");
                    progLabelField.setText("");
                    progLengthField.setText("");
                    progCombo.setValue(null);
                }
                catch (NumberFormatException e)
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Length can't contain String ! Please enter a number..");
                    alert.show();
                }
            }






        }
        else if (event.getSource() == courseAddBtn) {

            String code = courseCodeField.getText();
            String title = courseTitleField.getText();

            String programmeTitle = courseCombo.getValue();

            ProgrammeDAO programmeDAO = new ProgrammeDAO();

            Programme programme = new Programme();
            programme = programmeDAO.selectProgrammeByName(programmeTitle);

            Course course = new Course(code, title, programme);
            CourseDAO courseDAO = new CourseDAO();
            courseDAO.addCourse(course);

            setCourseTable();
            courseCodeField.setText("");
            courseTitleField.setText("");
            courseCombo.setValue(null);
        }
        else if (event.getSource() == campusAddBtn) {
            String name = campusNameField.getText();
            String address = campusAddressField.getText();


            Campus campus = new Campus(name, address);
            CampusDAO campusDAO = new CampusDAO();
            campusDAO.addCampus(campus);
            loadSclCombo();
            campusNameField.setText("");
            campusAddressField.setText("");


        }
        else if (event.getSource() == stdAddBtn) {

            String name = stdNameField.getText();
            int year = Integer.parseInt(stdEnrolledYear.getText());

            LocalDate birthday = stdBirthdayPicker.getValue();
            String gender = stdGenderCombo.getValue();
            String programmeTitle = stdPrgCombo.getValue();

            ProgrammeDAO programmeDAO = new ProgrammeDAO();

            Programme programme = new Programme();
            programme = programmeDAO.selectProgrammeByName(programmeTitle);

            Student student = new Student(name, birthday, gender, year, programme);
            StudentDAO studentDAO = new StudentDAO();
            studentDAO.addStudent(student);

            setStudentTable();
            stdNameField.setText("");
            stdEnrolledYear.setText("");
            stdBirthdayPicker.getEditor().clear();
            stdGenderCombo.setValue(null);
            stdPrgCombo.setValue(null);
        }
        else if (event.getSource() == seePrgListBtn) {

            setProgrammeTable();
            programmeListPage.setVisible(true);
            programmeListPage.setDisable(false);
            new ZoomIn(programmeListPage).play();

        }
        else if (event.getSource() == lecAddActionBtn) {

            if (lecNameField.getText().trim().equals("")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Name field is Empty ! Fill the Field...");
                alert.show();
            }
            else if (lecTitleField.getText().trim().equals("")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Title field is Empty ! Fill the Field...");
                alert.show();
            }
            else if (lecOfficeRoomField.getText().trim().equals("")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Office room field is Empty ! Fill the Field...");
                alert.show();
            }
            else if (lecSclCombo.getValue()==null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("School not Selected ! Select a School...");
                alert.show();
            }
            else {
                String name = lecNameField.getText();
                String title = lecTitleField.getText();
                String office = lecOfficeRoomField.getText();
                String schoolName = (String) lecSclCombo.getValue();
                String supervisorName = (String) lecSupCombo.getValue();

                SchoolDAO schoolDAO = new SchoolDAO();
                School school = new School();
                school = schoolDAO.selectSchoolByName(schoolName);

                Lecturer lecturer = new Lecturer();
                LecturerDAO lecturerDAO = new LecturerDAO();
                if(lecSupCombo.getValue()!=null){
                    lecturer = lecturerDAO.selectLecturerByName(supervisorName);
                    Lecturer lecturer1 = new Lecturer(name, title, office, school,lecturer);
                    lecturerDAO.addLecturer(lecturer1);
                }
                else {
                    Lecturer lecturer1 = new Lecturer(name, title, office, school);
                    lecturerDAO.addLecturer(lecturer1);
                }

                setLecturerTable();
                loadCourseCombo();
                lecNameField.setText("");
                lecTitleField.setText("");
                lecOfficeRoomField.setText("");
                lecSupCombo.setValue(null);
                lecSclCombo.setValue(null);
            }
        }
        else if (event.getSource() == lecCourseInfo){

            LecturerTable lecturerTable = (LecturerTable) lecTableView.getSelectionModel().getSelectedItem();
            if (lecturerTable == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText(null);
                alert.setContentText("No Lecturer Selected.");
                alert.show();
            }else {
                lecCoursePage.setDisable(false);
                lecCoursePage.setVisible(true);
                new ZoomIn(lecCoursePage).play();

                lecCourseLecIdLabel.setText(String.valueOf(lecturerTable.getId()));
                lecCourseLecNameLabel.setText(lecturerTable.getName());
                lecCourseLecTitleLabel.setText(lecturerTable.getTitle());
                lecCourseLecOfficeLabel.setText(lecturerTable.getOfficeRoom());
                lecCourseLecSchoolLabel.setText(lecturerTable.getSchool());
                lecCourseLecSupLabel.setText(lecturerTable.getSupervisor());

                loadLecCourseListView();
                LecturerDAO ld = new LecturerDAO();
                Lecturer l = ld.selectLecturerById(lecturerTable.getId());
                loadLecGivenCourseListView(l);
            }


        }
        else if (event.getSource() == addLecCourse){

            if (lecCourseListView.getSelectionModel().getSelectedItem() == null){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("No course Selected..");
                alert.show();

            }
            else {
                long lecId = Long.parseLong(lecCourseLecIdLabel.getText().trim());
                LecturerDAO lecturerDAO = new LecturerDAO();
                Lecturer l = lecturerDAO.selectLecturerById(lecId);

                String courseCode = lecCourseListView.getSelectionModel().getSelectedItem().toString().trim();


                CourseDAO cd = new CourseDAO();
                Course c = cd.selectCourseByCourseCode(courseCode);
                Lecturer_Course lc = new Lecturer_Course(l,c);

                Lecturer_CourseDAO lcd = new Lecturer_CourseDAO();
                lcd.addLecturerCourse(lc);
                loadLecGivenCourseListView(l);

            }



        }
        else if (event.getSource() == dropLecCourse) {

            if (lecGivenCourseListView.getSelectionModel().getSelectedItem() == null){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("No course Selected..");
                alert.show();

            } else {

                LecturerDAO lecturerDAO = new LecturerDAO();
                Lecturer l = lecturerDAO.selectLecturerById(Long.parseLong(lecCourseLecIdLabel.getText().trim()));

                String courseCode = lecGivenCourseListView.getSelectionModel().getSelectedItem().toString().trim();
                CourseDAO cd = new CourseDAO();
                Course c = cd.selectCourseByCourseCode(courseCode);

                Lecturer_Course lc = new Lecturer_Course(l,c);

                Lecturer_CourseDAO lcd = new Lecturer_CourseDAO();
                lcd.deleteLecturerCourse(lc);
                loadLecGivenCourseListView(l);

            }
        }
        else if (event.getSource() == StdCourseInfoBtn){

            StudentTable studentTable = (StudentTable) StudentTableView.getSelectionModel().getSelectedItem();
            if (studentTable == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setContentText("No Student Selected.");
                alert.show();
            }else {

                stdCoursePage.setVisible(true);
                stdCoursePage.setDisable(false);
                new ZoomIn(stdCoursePage).play();

                stdCourseStdIdLabel.setText(String.valueOf(studentTable.getStudentId()));
                stdCourseStdNameLabel.setText(studentTable.getStudentName());
                stdCourseStdPrgLabel.setText(studentTable.getStudentProgramme());
                loadStdCourseListView();
                loadStdSemesterCombo();
                stdSemesterYearCombo.getItems().addAll(Calendar.getInstance().get(Calendar.YEAR),Calendar.getInstance().get(Calendar.YEAR)+1);


                StudentDAO sd = new StudentDAO();
                Student st = sd.selectStudentById(studentTable.getStudentId());
                loadStdGivenCourseListView(st);
            }

        }
        else if (event.getSource() == addStdCourseBtn){

            if (stdCourseListView.getSelectionModel().getSelectedItem() == null){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("No course Selected..");
                alert.show();

            }
            else if (stdSemesterCombo.getValue()==null){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setContentText("No Semester Selected...");
                alert.show();
            }
            else if (stdSemesterYearCombo.getValue()==null){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setContentText("No Semester Selected...");
                alert.show();
            }
            else {
                long stdId = Long.parseLong(stdCourseStdIdLabel.getText().trim());
                StudentDAO studentDAO = new StudentDAO();
                Student s = studentDAO.selectStudentById(stdId);

                String[] courseInfo= stdCourseListView.getSelectionModel().getSelectedItem().toString().split(":");

                String courseCode = courseInfo[0].trim();
                CourseDAO cd = new CourseDAO();
                Course c = cd.selectCourseByCourseCode(courseCode);

                long lecId = Long.parseLong(courseInfo[2].trim());
                LecturerDAO ld = new LecturerDAO();
                Lecturer l = ld.selectLecturerById(lecId);


                Course_Student cs = new Course_Student(c, s, stdSemesterYearCombo.getValue().toString(), stdSemesterCombo.getValue().toString(), stdGradeAwardField.getText(), l);

                Course_StudentDAO csd = new Course_StudentDAO();
                csd.addCourseStudent(cs);

                loadStdGivenCourseListView(s);
            }



        }
        else if (event.getSource() == dropStudentCourseBtn){
            if (stdGivenCourseListView.getSelectionModel().getSelectedItem() == null){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("No course Selected..");
                alert.show();

            } else {

                StudentDAO studentDAO = new StudentDAO();
                Student s = studentDAO.selectStudentById(Long.parseLong(stdCourseStdIdLabel.getText().trim()));

                String[] courseInfo = stdGivenCourseListView.getSelectionModel().getSelectedItem().toString().split(":");
                String courseCode = courseInfo[0].trim();
                CourseDAO cd = new CourseDAO();
                Course c = cd.selectCourseByCourseCode(courseCode);

//                Course_Student cs = new Course_Student(c,s);

                Course_StudentDAO csd = new Course_StudentDAO();
                csd.deleteCourseStudentByStdAndCourse(s,c);
                loadStdGivenCourseListView(s);

            }
        }
        else if (event.getSource() == updateStdGradeBtn){
            if (stdGivenCourseListView.getSelectionModel().getSelectedItem() == null){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Select Course First...");
                alert.show();

            }
            else {
                StudentDAO studentDAO = new StudentDAO();
                Student s = studentDAO.selectStudentById(Long.parseLong(stdCourseStdIdLabel.getText().trim()));

                String[] courseInfo = stdGivenCourseListView.getSelectionModel().getSelectedItem().toString().split(":");
                String courseCode = courseInfo[0].trim();
                CourseDAO cd = new CourseDAO();
                Course c = cd.selectCourseByCourseCode(courseCode);

                Course_StudentDAO csd = new Course_StudentDAO();
                Course_Student cs = csd.selectCourseStudentByStudentAndCourse(s,c);
                cs.setGradeAward(stdGradeAwardField.getText());
                csd.updateCourseStudent(cs);
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Grade Update Successful");
                alert.show();
                stdGradeAwardField.setText("");

            }

        }
    }





    public void updateDeleteAction(ActionEvent event) throws IOException {
        if (event.getSource() == studentUpdateBtn) {

            StudentTable studentTable = (StudentTable) StudentTableView.getSelectionModel().getSelectedItem();
            if (studentTable == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setContentText("No Student Selected.");
                alert.show();
            } else {

                updateStdPage.setDisable(false);
                updateStdPage.setVisible(true);
                new ZoomIn(updateStdPage).play();

                long id = studentTable.getStudentId();
                String name = studentTable.getStudentName();
                LocalDate birthday = studentTable.getStudentBirthday();
                String gender = studentTable.getStudentGender();
                int year = studentTable.getStudentYearEnrolled();
                String programmeCode = studentTable.getStudentProgramme();
                ProgrammeDAO pd = new ProgrammeDAO();
                Programme p = pd.selectProgrammeByCode(programmeCode);

                loadUpdateStdPrgCombo();
                stdUpdateGenderCombo.getItems().addAll("Male","Female");

                stdUpdateIdField.setText(String.valueOf(id));
                stdUpdateNameField.setText(name);
                stdUpdateEnrolledYearField.setText(String.valueOf(year));
                stdUpdateGenderCombo.setValue(gender);
                stdUpdatePrgCombo.setValue(p.getProgramTitle());
                stdUpdateBirthdayPicker.setValue(birthday);

            }

        }
        else if (event.getSource() == stdUpdateActionBtn) {

            if (stdUpdateNameField.getText().trim().equals("")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Name  is Empty ! Fill the Field...");
                alert.show();
            }
            else if (stdUpdateEnrolledYearField.getText().trim().equals("")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Enrolled year is Empty ! Fill the Field...");
                alert.show();
            }
            else if (stdUpdateGenderCombo.getItems().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Gender not Selected ! Select a Gender...");
                alert.show();
            }
            else if (stdUpdatePrgCombo.getItems().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Programme not Selected ! Select a Programme...");
                alert.show();
            }
            else {
                Programme programme = new Programme();
                ProgrammeDAO programmeDAO = new ProgrammeDAO();
                programme = programmeDAO.selectProgrammeByName(stdUpdatePrgCombo.getValue().toString());

                Student student = new Student(Integer.parseInt(stdUpdateIdField.getText()),stdUpdateNameField.getText(),stdUpdateBirthdayPicker.getValue(),stdUpdateGenderCombo.getValue().toString(),Integer.parseInt(stdUpdateEnrolledYearField.getText()),programme);
                StudentDAO studentDAO = new StudentDAO();
                studentDAO.updateStudent(student);
                setStudentTable();
                new ZoomOut(updateStdPage).play();
                updateStdPage.setDisable(true);
                updateStdPage.setVisible(false);
            }

        }
        else if (event.getSource() == StudentDeleteBtn) {

            StudentTable studentTable = (StudentTable) StudentTableView.getSelectionModel().getSelectedItem();
            if (studentTable == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText(null);
                alert.setContentText("No Student Selected.");
                alert.show();
            } else {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText(null);
                alert.setContentText("Are you Sure to delete the student?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    long id = studentTable.getStudentId();
                    StudentDAO sd = new StudentDAO();

                    Student s = sd.selectStudentById(id);
                    sd.deleteStudent(s);
                    setStudentTable();
                }


            }
        }
        else if (event.getSource() == prgUpdateBtn) {

            ProgrammeTable programmeTable = (ProgrammeTable) prgTableView.getSelectionModel().getSelectedItem();
            if (programmeTable == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText(null);
                alert.setContentText("No Programme Selected.");
                alert.show();
            } else {
                updatePrgPage.setVisible(true);
                new ZoomIn(updatePrgPage).play();

                updatePrgCodeField.setText(programmeTable.getProgramCode());
                updatePrgTitleField.setText(programmeTable.getProgramTitle());
                updatePrgLabelField.setText(programmeTable.getProgramLabel());
                updatePrgLengthField.setText(String.valueOf(programmeTable.getProgramLength()));
                updatePrgCombo.setValue(programmeTable.getProgrammeSclName());


                /*stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    public void handle(WindowEvent we) {
                        setStudentTable();
                    }
                });*/

            }

        }
        else if (event.getSource() == prgUpdateActionBtn) {

            if (updatePrgCodeField.getText().trim().equals("")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Programme code is Empty ! Fill the Field...");
                alert.show();
            }
            else if (updatePrgTitleField.getText().trim().equals("")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Programme Title is Empty ! Fill the Field...");
                alert.show();
            }
            else if (updatePrgLabelField.getText().trim().equals("")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Programme label is Empty ! Fill the Field...");
                alert.show();
            }
            else if (updatePrgLengthField.getText().trim().equals("")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Programme length is Empty ! Fill the Field...");
                alert.show();
            }
            else if (updatePrgCombo.getItems().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("School not Selected ! Select a School...");
                alert.show();
            }
            else {
                SchoolDAO sd = new SchoolDAO();
                School s = sd.selectSchoolByName((String) updatePrgCombo.getValue());
               Programme programme = new Programme(updatePrgCodeField.getText(),updatePrgTitleField.getText(),updatePrgLabelField.getText(),Integer.parseInt(updatePrgLengthField.getText()),s);
               ProgrammeDAO pd = new ProgrammeDAO();
               pd.updateProgramme(programme);
               setProgrammeTable();
            }

        }
        else if (event.getSource() == prgDeleteBtn) {

            ProgrammeTable programmeTable = (ProgrammeTable) prgTableView.getSelectionModel().getSelectedItem();
            if (programmeTable == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText(null);
                alert.setContentText("No Programme Selected.");
                alert.show();
            } else {

                Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                alert1.setTitle("Confirmation");
                alert1.setHeaderText(null);
                alert1.setContentText("Are you Sure to delete the Lecturer?");
                Optional<ButtonType> result = alert1.showAndWait();
                if (result.get() == ButtonType.OK) {
                    ProgrammeDAO pd = new ProgrammeDAO();
                    Programme p = new Programme();
                    p = pd.selectProgrammeByCode(programmeTable.getProgramCode());
                    pd.deleteProgramme(p);
                    setProgrammeTable();
                }

            }
        }
        else if (event.getSource() == courseUpdateBtn) {
            updateCoursePage.setDisable(false);
            updateCoursePage.setVisible(true);
            new ZoomIn(updateCoursePage).play();
            CourseTable courseTable = (CourseTable) courseTableView.getSelectionModel().getSelectedItem();
            if (courseTable == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText(null);
                alert.setContentText("No Course Selected.");
                alert.show();
            } else {
                loadUpdateCourseCombo();
                updateCourseCodeField.setText(courseTable.getCourse_code());
                updateCourseTitleField.setText(courseTable.getCourse_title());

                ProgrammeDAO pd = new ProgrammeDAO();
                Programme p = pd.selectProgrammeByCode((String) courseTable.getProgramme());
                updateCourseCombo.setValue(p.getProgramTitle());
            }

        }
        else if (event.getSource() == courseUpdateActionBtn) {

            if (updateCourseTitleField.getText().trim().equals("")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Course Title is Empty ! Fill the Field...");
                alert.show();
            }

            else if (updateCourseCombo.getItems().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Programme not Selected ! Select a Programme...");
                alert.show();
            }
            else {
                ProgrammeDAO pd = new ProgrammeDAO();
                Programme p = pd.selectProgrammeByName((String) updateCourseCombo.getValue());
                Course course = new Course(updateCourseCodeField.getText(),updateCourseTitleField.getText(),p);
                CourseDAO cd = new CourseDAO();
                cd.updateCourse(course);
                setCourseTable();
            }

        }
        else if (event.getSource() == courseDeleteBtn) {

            CourseTable courseTable = (CourseTable) courseTableView.getSelectionModel().getSelectedItem();
            if (courseTable == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText(null);
                alert.setContentText("No Course Selected.");
                alert.show();
            } else {

                Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                alert1.setTitle("Confirmation");
                alert1.setHeaderText(null);
                alert1.setContentText("Are you Sure to delete the Course?");
                Optional<ButtonType> result = alert1.showAndWait();
                if (result.get() == ButtonType.OK) {
                    CourseDAO cd = new CourseDAO();
                    Course c = new Course();
                    c = cd.selectCourseByName(courseTable.getCourse_title());
                    cd.deleteCourse(c);
                    setCourseTable();
                }

            }
        }
        else if (event.getSource() == updateLecBtn) {

            LecturerTable lecturerTable = (LecturerTable) lecTableView.getSelectionModel().getSelectedItem();
            if (lecturerTable == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText(null);
                alert.setContentText("No lecturer Selected.");
                alert.show();
            } else {
                loadUpdateLecSupCombo();
                loadUpdateLecSclCombo();
                updateLecPage.setDisable(false);
                updateLecPage.setVisible(true);
                new ZoomIn(updateLecPage).play();

                updateIdField.setText("Id: "+lecturerTable.getId());
                updateLecNameField.setText(lecturerTable.getName());
                updateLecTitleField.setText(lecturerTable.getTitle());
                updateLecOfficeRoomField.setText(lecturerTable.getOfficeRoom());
                updateLecSupCombo.setValue(lecturerTable.getSupervisor());
                updateLecSclCombo.setValue(lecturerTable.getSchool());

            }

        }
        else if (event.getSource() == updateLecActionBtn) {

            if (updateLecNameField.getText().trim().equals("")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Name field is Empty ! Fill the Field...");
                alert.show();
            }
            else if (updateLecTitleField.getText().trim().equals("")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Title field is Empty ! Fill the Field...");
                alert.show();
            }
            else if (updateLecOfficeRoomField.getText().trim().equals("")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Office room field is Empty ! Fill the Field...");
                alert.show();
            }
            else if (updateLecSclCombo.getValue()==null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("School not Selected ! Select a School...");
                alert.show();
            }
            else {
                String schoolName = (String) updateLecSclCombo.getValue();
                String supervisorName = (String) updateLecSupCombo.getValue();

                SchoolDAO schoolDAO = new SchoolDAO();
                School school = new School();
                school = schoolDAO.selectSchoolByName(schoolName);

                Lecturer lecturer = new Lecturer();
                LecturerDAO lecturerDAO = new LecturerDAO();
                lecturer = lecturerDAO.selectLecturerByName(supervisorName);

                long id = Long.parseLong(updateIdField.getText().substring(4));

                if(updateLecSupCombo.getValue()!="none"){
                    Lecturer lecturer1 = new Lecturer(id,updateLecNameField.getText(), updateLecTitleField.getText(), updateLecOfficeRoomField.getText(), school,lecturer);
                    lecturerDAO.updateLecturer(lecturer1);
                }
                else {
                    Lecturer lecturer1 = new Lecturer(id,updateLecNameField.getText(), updateLecTitleField.getText(), updateLecOfficeRoomField.getText(), school,null);
                    lecturerDAO.updateLecturer(lecturer1);

                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated..");
                    alert.show();
                }
                setLecturerTable();
            }

        }
        else if (event.getSource() == deleteLecBtn) {

            LecturerTable lecturerTable = (LecturerTable) lecTableView.getSelectionModel().getSelectedItem();
            if (lecturerTable == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText(null);
                alert.setContentText("No lecturer Selected.");
                alert.show();
            } else {

                Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                alert1.setTitle("Confirmation");
                alert1.setHeaderText(null);
                alert1.setContentText("Are you Sure to delete the Lecturer?");
                Optional<ButtonType> result = alert1.showAndWait();
                if (result.get() == ButtonType.OK) {



                    LecturerDAO ld = new LecturerDAO();
                    Lecturer l = new Lecturer();

                    l = ld.selectLecturerById(lecturerTable.getId());
                    Course_StudentDAO cs = new Course_StudentDAO();
                    cs.deleteCourseStudentByLecturer(l);
                    ld.deleteLecturer(l);
                    setLecturerTable();
                }

            }
        }


    }


    @FXML
    private void MouseClicked(MouseEvent event) {
        if (event.getSource() == PrgBack) {
            programmeListPage.setDisable(true);
            new ZoomOut(programmeListPage).play();


        } else if (event.getSource() == updatePrgClose) {
            new ZoomOut(updatePrgPage).play();

        }
        else if(event.getSource() == closeUpdateCourseBtn){
            updateCoursePage.setDisable(true);
            new ZoomOut(updateCoursePage).play();
        }
        else if(event.getSource() == lecAddBtn){
            loadAddLecSupCombo();
            loadAddLecSclCombo();
            AddLecPage.setDisable(false);
            AddLecPage.setVisible(true);
            new ZoomIn(AddLecPage).play();
        }
        else if(event.getSource() == closeAddLecPage){
            AddLecPage.setDisable(true);
            new ZoomOut(AddLecPage).play();
        }

        else if(event.getSource() == closeUpdateLecPage){
            updateLecPage.setDisable(true);
            new ZoomOut(updateLecPage).play();
        }
        else if(event.getSource() == closeLecCoursePage){
            lecCoursePage.setDisable(true);
            new ZoomOut(lecCoursePage).play();
        }
        else if (event.getSource() == closeStdCoursePage){
            stdCoursePage.setDisable(true);
            new ZoomOut(stdCoursePage).play();
        }
        else if (event.getSource() == closeUpdateStd) {
            updateStdPage.setDisable(true);
            new ZoomOut(updateStdPage).play();
        }
    }





    private String courseCode;
    private String courseTitle;
    private String ProgrammeCode;

    public void setCourseTable(){
        courseList.clear();

        tbCourseCode.setCellValueFactory(new PropertyValueFactory<CourseTable, String>("Course_code"));
        tbCourseTitle.setCellValueFactory(new PropertyValueFactory<CourseTable, Integer>("Course_title"));
        tbCourseProgramme.setCellValueFactory(new PropertyValueFactory<CourseTable, String>("Programme"));

        courseTableView.setItems(courseList);

        CourseDAO courseDAO = new CourseDAO();
        List<Course> list = new ArrayList();
        list = courseDAO.getAllCourse();


        for (Course c : list) {
            courseCode = c.getCourseCode();
            courseTitle = c.getCourseTitle();
            Programme p = new Programme();
            p = c.getProgrammeCourse();
            if (p!=null){
                ProgrammeCode = p.getProgramCode();
                CourseTable courseTable = new CourseTable(courseCode, courseTitle, ProgrammeCode);
                courseList.add(courseTable);
            }

        }


    }

    public void setStudentTable() {
        StudentList.clear();

        tbStudentId.setCellValueFactory(new PropertyValueFactory<StudentTable, Long>("studentId"));
        tbStudentName.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("studentName"));
        tbStudentBirthday.setCellValueFactory(new PropertyValueFactory<StudentTable, LocalDate>("studentBirthday"));
        tbStudentGender.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("studentGender"));
        tbStudentYearEnrolled.setCellValueFactory(new PropertyValueFactory<StudentTable, Integer>("studentYearEnrolled"));
        tvStudentProgramme.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("studentProgramme"));

        StudentTableView.setItems(StudentList);

        StudentDAO studentDAO = new StudentDAO();
        List<Student> list = new ArrayList();
        list = studentDAO.getAllStudent();


        for (Student s : list) {

            Programme p = new Programme();
            p = s.getProgramme();
            StudentTable studentTable = new StudentTable(s.getStdId(), s.getStdName(), s.getStdBirthday(), s.getStdGender(), s.getStdYearEnrolled(), p.getProgramCode());
            StudentList.add(studentTable);

        }


    }

    public void setProgrammeTable() {
        programmeList2.clear();

        tbPrgCode.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("programCode"));
        tbPrgTitle.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("programTitle"));
        tbPrgLabel.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("programLabel"));
        tbPrgLength.setCellValueFactory(new PropertyValueFactory<StudentTable, Integer>("programLength"));
        tbPrgSclName.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("programmeSclName"));

        prgTableView.setItems(programmeList2);

        ProgrammeDAO programmeDAO = new ProgrammeDAO();
        List<Programme> list = new ArrayList();
        list = programmeDAO.getAllProgramme();


        for (Programme p : list) {

            School school = new School();
            school = p.getSchoolP();
            ProgrammeTable programmeTable = new ProgrammeTable(p.getProgramCode(), p.getProgramTitle(), p.getProgramLabel(), p.getProgramLength(), school.getSchoolName());
            programmeList2.add(programmeTable);

        }


    }

    public void setLecturerTable() {
        tableLecturerList.clear();

        tbLecId.setCellValueFactory(new PropertyValueFactory<LecturerTable, Long>("id"));
        tbLecName.setCellValueFactory(new PropertyValueFactory<LecturerTable, String>("name"));
        tbLecTitle.setCellValueFactory(new PropertyValueFactory<LecturerTable, String>("title"));
        tbLecOffice.setCellValueFactory(new PropertyValueFactory<LecturerTable, String>("officeRoom"));
        tbLecSchool.setCellValueFactory(new PropertyValueFactory<LecturerTable, String>("school"));
        tbLecSupervisor.setCellValueFactory(new PropertyValueFactory<LecturerTable, String>("supervisor"));

        lecTableView.setItems(tableLecturerList);

        LecturerDAO lecturerDAO = new LecturerDAO();
        List<Lecturer> list = new ArrayList();
        list = lecturerDAO.getAllLecturer();


        for (Lecturer l : list) {

            School school = new School();
            school = l.getSchoolId();
            Lecturer lecturer = new Lecturer();
            lecturer = l.getSupId();
            if (lecturer==null){
                LecturerTable lecturerTable = new LecturerTable(l.getStfId(), l.getLecturerName(), l.getLecturerTitle(), l.getOfficeRoom(), school.getSchoolName(),"none");
                tableLecturerList.add(lecturerTable);
            }
            else {
                LecturerTable lecturerTable = new LecturerTable(l.getStfId(), l.getLecturerName(), l.getLecturerTitle(), l.getOfficeRoom(), school.getSchoolName(), lecturer.getLecturerName());
                tableLecturerList.add(lecturerTable);
            }

        }


    }


    public void loadSclCombo() {
        stateList.clear();

        CampusDAO campusDAO = new CampusDAO();
        sclcombo.setItems(stateList);

        List<Campus> list2 = campusDAO.getAllCampus();

        for (Campus c : list2) {
            stateList.add(c.getCampName());
        }

    }

    public void loadProgCombo() {
        schoolList.clear();

        SchoolDAO schoolDAO = new SchoolDAO();
        progCombo.setItems(schoolList);

        List<School> list2 = schoolDAO.getAllSchool();

        for (School s : list2) {
            schoolList.add(s.getSchoolName());
        }

    }

    public void loadUpdatePrgCombo() {
        schoolList.clear();

        SchoolDAO schoolDAO = new SchoolDAO();
        updatePrgCombo.setItems(schoolList);

        List<School> list2 = schoolDAO.getAllSchool();

        for (School s : list2) {
            schoolList.add(s.getSchoolName());
        }

    }

    public void loadCourseCombo() {
        programmeList.clear();
        ProgrammeDAO programmeDAO = new ProgrammeDAO();
        courseCombo.setItems(programmeList);

        List<Programme> list = programmeDAO.getAllProgramme();
        for (Programme p : list) {
            programmeList.add(p.getProgramTitle());
        }
    }
    public void loadUpdateStdPrgCombo() {
        programmeList.clear();
        ProgrammeDAO programmeDAO = new ProgrammeDAO();
        stdUpdatePrgCombo.setItems(programmeList);

        List<Programme> list = programmeDAO.getAllProgramme();
        for (Programme p : list) {
            programmeList.add(p.getProgramTitle());
        }
    }

    public void loadUpdateCourseCombo() {
        programmeList.clear();
        ProgrammeDAO programmeDAO = new ProgrammeDAO();
        updateCourseCombo.setItems(programmeList);

        List<Programme> list = programmeDAO.getAllProgramme();
        for (Programme p : list) {
            programmeList.add(p.getProgramTitle());
        }
    }

    public void loadStudentCombo() {
        programmeList1.clear();

        ProgrammeDAO programmeDAO = new ProgrammeDAO();
        stdPrgCombo.setItems(programmeList);

        List<Programme> list = programmeDAO.getAllProgramme();
        for (Programme p : list) {
            programmeList1.add(p.getProgramTitle());
        }

    }

    public void loadSchoolList() {
        schoolList2.clear();
        SchoolDAO schoolDAO = new SchoolDAO();
        sclListView.setItems(schoolList2);
        sclListView.setPrefHeight(50);

        List<School> list2 = schoolDAO.getAllSchool();
        for (School s : list2) {
            schoolList2.add(s.getSchoolName());
        }
    }

    public void loadAddLecSclCombo() {
        schoolList.clear();

        SchoolDAO schoolDAO = new SchoolDAO();
        lecSclCombo.setItems(schoolList);

        List<School> list = schoolDAO.getAllSchool();

        for (School s : list) {
            schoolList.add(s.getSchoolName());
        }

    }
    public void loadUpdateLecSclCombo() {
        schoolList.clear();

        SchoolDAO schoolDAO = new SchoolDAO();
        updateLecSclCombo.setItems(schoolList);

        List<School> list = schoolDAO.getAllSchool();

        for (School s : list) {
            schoolList.add(s.getSchoolName());
        }

    }
    

    public void loadAddLecSupCombo() {
        lecturerList.clear();
        LecturerDAO lecturerDAO = new LecturerDAO();
        lecSupCombo.setItems(lecturerList);
        List<Lecturer> list = lecturerDAO.getAllLecturer();
        lecSupCombo.getItems().add("none");
        for (Lecturer l : list) {
            lecturerList.add(l.getLecturerName());
        }

    }
    public void loadUpdateLecSupCombo() {
        lecturerList.clear();
        LecturerDAO lecturerDAO = new LecturerDAO();
        updateLecSupCombo.setItems(lecturerList);
        List<Lecturer> list = lecturerDAO.getAllLecturer();
        for (Lecturer l : list) {
            lecturerList.add(l.getLecturerName());
        }


    }
    public void loadStdSemesterCombo() {
        stdSemesterList.clear();
        ProgrammeDAO programmeDAO = new ProgrammeDAO();
        stdSemesterCombo.getItems().addAll("Spring", "Summer", "Fall");
    }

    public void loadLecCourseListView() {
        lecCourseList.clear();
        CourseDAO courseDAO = new CourseDAO();
        lecCourseListView.setItems(lecCourseList);

        List<Course> list = courseDAO.getAllCourse();
        for (Course c : list) {
            lecCourseList.add(c.getCourseCode());
        }
    }
    public void loadLecGivenCourseListView(Lecturer lec) {
        lecGivenCourseList.clear();
        Lecturer_CourseDAO lcd = new Lecturer_CourseDAO();
        lecGivenCourseListView.setItems(lecGivenCourseList);

        List<Lecturer_Course> list = lcd.getLecturerCourseByLecturer(lec);
        for (Lecturer_Course c : list) {
            Course course = c.getCourse();
            lecGivenCourseList.add(course.getCourseCode());
        }
    }
    public void loadStdCourseListView() {
        stdCourseList.clear();
        CourseDAO courseDAO = new CourseDAO();
        stdCourseListView.setItems(stdCourseList);

        Lecturer_CourseDAO lcd = new Lecturer_CourseDAO();
        List<Lecturer_Course> list = lcd.getAllLecturerCourse();
        for (Lecturer_Course lc : list) {
            Course course = lc.getCourse();
            Lecturer lecturer =lc.getLecturer();
            stdCourseList.add(course.getCourseCode()+" : "+lecturer.getLecturerName() + " : " + lecturer.getStfId());
        }
    }
    public void loadStdGivenCourseListView(Student st) {
        stdGivenCourseList.clear();
        Course_StudentDAO csd = new Course_StudentDAO();
        stdGivenCourseListView.setItems(stdGivenCourseList);

        List<Course_Student> list = csd.getCourseStudentByStudent(st);
        for (Course_Student cs : list) {
            Course course = cs.getCourse();
            Lecturer l =cs.getLecturer();
            stdGivenCourseList.add(course.getCourseCode()+" : "+l.getLecturerName());
        }
    }
}
