package DAO;

import Bean.Lecturer;
import Bean.Programme;
import Bean.Student;
import Helper.factoryProvider;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.List;

public class LecturerDAO {

    public void addLecturer( Lecturer lecturer) {
        Session session = factoryProvider.getFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(lecturer);
        t.commit();
        session.close();
    }


    public void updateLecturer(Lecturer lecturer) {
        Session session = factoryProvider.getFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(lecturer);
        t.commit();
        session.close();
    }


    public void deleteLecturer(Lecturer l) {
        Session session = factoryProvider.getFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(l);
        t.commit();
        session.close();
    }


    public List getAllLecturer() {
        Session session = factoryProvider.getFactory().openSession();

        Query q =session.createQuery("from Lecturer");
        List<Lecturer> list = q.list();
        session.close();
        return list;
    }
    public Lecturer selectLecturerByName(String name){

        Lecturer lecturer = new Lecturer();

        Session session = factoryProvider.getFactory().openSession();

        Criteria c = session.createCriteria(Lecturer.class);
        c.add(Restrictions.like("lecturerName",name));
        lecturer = (Lecturer) c.uniqueResult();
        session.close();

        return lecturer;


    }
    public Lecturer selectLecturerById(Long Id){

        Lecturer lecturer = new Lecturer();

        Session session = factoryProvider.getFactory().openSession();

        Criteria c = session.createCriteria(Lecturer.class);
        c.add(Restrictions.like("StfId",Id));
        lecturer = (Lecturer) c.uniqueResult();
        session.close();

        return lecturer;


    }
}
