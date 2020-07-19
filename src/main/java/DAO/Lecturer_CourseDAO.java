package DAO;

import Bean.*;
import Helper.factoryProvider;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.List;

public class Lecturer_CourseDAO {
    public void addLecturerCourse( Lecturer_Course lc) {
        Session session = factoryProvider.getFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(lc);
        t.commit();
        session.close();
    }

    public List getAllLecturerCourse() {
        Session session = factoryProvider.getFactory().openSession();

        Query q = session.createQuery("from Lecturer_Course");
        List<Lecturer_Course> list = q.list();
        session.close();
        return list;
    }

    public List getLecturerCourseByLecturer(Lecturer l){
        Session session = factoryProvider.getFactory().openSession();

        Query q =session.createQuery("from Lecturer_Course where lecturer=:lec");
        q.setParameter("lec", l);
        List<Lecturer_Course> list = q.list();
        session.close();
        return list;
    }
    public void deleteLecturerCourse(Lecturer_Course lc) {
        Session session = factoryProvider.getFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(lc);
        t.commit();
        session.close();
    }
    public void deleteAllLecturerCourse(Lecturer lc) {
        Session session = factoryProvider.getFactory().openSession();
        Transaction t =  session.beginTransaction();
        Query q =session.createQuery("delete from Lecturer_Course where lecturer=:lec");
        q.setParameter("lec", lc);
        q.executeUpdate();
        t.commit();
        session.close();

    }
}
