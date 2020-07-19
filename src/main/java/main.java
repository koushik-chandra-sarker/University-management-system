import Bean.*;
import DAO.CampusDAO;
import DAO.CourseDAO;
import DAO.ProgrammeDAO;
import DAO.UserDAO;
import Helper.factoryProvider;
import Table.CourseTable;
import org.hibernate.Cache;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ListIterator;

public class main {

    public static void main(String[] args) {



        /*String s ="CAE0111 smsdkm  :  Koushik sarker";

        String[] arr = s.split(":");

        for (String s1:arr){
            System.out.println(s1.trim());
        }*/
        UserDAO ud = new UserDAO();
        User u = (User) ud.selectUserByUNameAndPass("aan","skdm");
        System.out.println(u);
    }
}
