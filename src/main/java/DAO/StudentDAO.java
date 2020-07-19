package DAO;

import Bean.Course;
import Bean.Programme;
import Bean.School;
import Bean.Student;
import Helper.factoryProvider;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAO {

    public void addStudent( Student student) {
        Session session = factoryProvider.getFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(student);
        t. commit();
        session.close();
    }


    public void updateStudent(Student st) {
        Session session = factoryProvider.getFactory().openSession();
        Transaction t = session.beginTransaction();

        session.update(st);
        t.commit();
        session.close();
    }


    /*public int deleteStudent(long sId) {
        int i = 0;
        Session session = factoryProvider.getFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            Query q = session.createQuery("delete from Student where stdId=:id");
            q.setParameter("id", sId);
            i = q.executeUpdate();
            t.commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return i;
    }*/
    public void deleteStudent(Student student) {
        Session session = factoryProvider.getFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(student);
        t.commit();
        session.close();
    }

    public List getAllStudent() {
        Session session = factoryProvider.getFactory().openSession();

        Query q =session.createQuery("from Student ");
        List<Programme> list = q.list();
        session.close();
        return list;
    }
    public Student selectStudentByName(String name){

        Student student = new Student();

        Session session = factoryProvider.getFactory().openSession();

        Criteria c = session.createCriteria(Student.class);
        c.add(Restrictions.like("stdName",name));
        student = (Student) c.uniqueResult();
        session.close();

        return student;


    }
    public Student selectStudentById(Long id){

        Student student = new Student();

        Session session = factoryProvider.getFactory().openSession();

        Criteria c = session.createCriteria(Student.class);
        c.add(Restrictions.like("stdId",id));
        student = (Student) c.uniqueResult();
        session.close();

        return student;


    }
}
