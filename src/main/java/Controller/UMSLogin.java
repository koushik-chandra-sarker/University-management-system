package Controller;

import Bean.User;
import DAO.UserDAO;
import Helper.factoryProvider;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UMSLogin extends Application {
    @Override
    public void start(Stage PrimaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("UMSLoginFXML.fxml"));

        Session session = factoryProvider.getFactory().openSession();
        Transaction t = session.beginTransaction();
        t.commit();
        session.close();

        Stage stage1 = new Stage();
        Scene scene = new Scene(root);
        stage1.setScene(scene);
        stage1.initStyle(StageStyle.UNDECORATED);

        UserDAO ud = new UserDAO();
        List<User> u = ud.getAllUser();
        if (u.size()<=0){
            User u1 = new User("admin","admin","admin");
            ud.addUser(u1);
            stage1.show();
        }
        else {
            stage1.show();
        }
    }
}
