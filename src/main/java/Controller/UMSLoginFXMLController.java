package Controller;

import Bean.Campus;
import Bean.User;
import DAO.CampusDAO;
import DAO.UserDAO;
import Helper.factoryProvider;
import animatefx.animation.Swing;
import animatefx.animation.Tada;
import animatefx.animation.Wobble;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UMSLoginFXMLController implements Initializable {

    @Override
    public void initialize(URL event, ResourceBundle rb) {
    }

    @FXML
    private Circle closeLoginPage, minimizeLoginPage;

    @FXML
    private AnchorPane loginPage;
    @FXML
    private Button loginBtn;
    @FXML
    private TextField userNameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void loginControl(ActionEvent event) throws IOException {

        UserDAO ud = new UserDAO();
        User u = (User) ud.selectUserByUNameAndPass(userNameField.getText().trim(), passwordField.getText().trim());
        if (u == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Wrong Username or Password.");
            alert.setTitle("Error");
            alert.show();
        } else if (u.getRole().equals("admin")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UMSDashboardFXML.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }


    }

    @FXML
    public void MouseClickHandle(MouseEvent event) {
        // Windows Close
        if (event.getSource() == closeLoginPage) {
//            Node for ImageView of button
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }
        // Windows Minimize
        if (event.getSource() == minimizeLoginPage) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//             stage.toBack();
            // or
            stage.setIconified(true);
        }
    }

}
