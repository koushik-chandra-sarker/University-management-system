package DAO;

import Bean.Programme;
import Bean.Student;
import Bean.User;
import Helper.factoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAO {
    public void addUser(User user) {
        Session session = factoryProvider.getFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(user);
        t.commit();
        session.close();
    }


    public void updateUser(User user) {
        Session session = factoryProvider.getFactory().openSession();
        Transaction t = session.beginTransaction();

        session.update(user);
        t.commit();
        session.close();
    }


    public List getAllUser() {
        Session session = factoryProvider.getFactory().openSession();

        Query q = session.createQuery("from User");
        List<User> list = q.list();
        session.close();
        return list;
    }

    public User selectUserByUNameAndPass(String uName, String pass) {
        Session session = factoryProvider.getFactory().openSession();
        Query q = session.createQuery("from User where username=:u and password=:p");
        q.setParameter("u", uName);
        q.setParameter("p", pass);
        User u = (User) q.uniqueResult();
        session.close();
        return u;
    }
}
