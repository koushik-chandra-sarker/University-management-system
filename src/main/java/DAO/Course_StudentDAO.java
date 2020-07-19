package DAO;

import Bean.*;
import Helper.factoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Course_StudentDAO {
    public void addCourseStudent( Course_Student cs) {
        Session session = factoryProvider.getFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(cs);
        t.commit();
        session.close();
    }

    public List getAllCourseStudent() {
        Session session = factoryProvider.getFactory().openSession();

        Query q = session.createQuery("from Course_Student");
        List<Course_Student> list = q.list();
        session.close();
        return list;
    }

    public List getCourseStudentByStudent(Student s){
        Session session = factoryProvider.getFactory().openSession();

        Query q =session.createQuery("from Course_Student where student=:st");
        q.setParameter("st", s);
        List<Course_Student> list = q.list();
        session.close();
        return list;
    }
    public Course_Student selectCourseStudentByStudentAndCourse(Student student, Course course){
        Session session = factoryProvider.getFactory().openSession();

        Query q =session.createQuery("from Course_Student where student=:st and course=:c");
        q.setParameter("st", student);
        q.setParameter("c", course);
        Course_Student cs = (Course_Student) q.uniqueResult();
        session.close();
        return cs;
    }

    public void updateCourseStudent(Course_Student course_student) {
        Session session = factoryProvider.getFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(course_student);
        t.commit();
        session.close();
    }

    public void deleteCourseStudent(Course_Student cs) {
        Session session = factoryProvider.getFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(cs);
        t.commit();
        session.close();
    }
    public void deleteCourseStudentByStdAndCourse(Student st, Course course) {
        Session session = factoryProvider.getFactory().openSession();
        Transaction t = session.beginTransaction();
        Query q = session.createQuery("delete from Course_Student where student=:s and course =:c");
        q.setParameter("s", st);
        q.setParameter("c", course);
        int i = q.executeUpdate();
        t.commit();
        session.close();
    }
    public void deleteCourseStudentByLecturer(Lecturer l) {
        Session session = factoryProvider.getFactory().openSession();
        Transaction t = session.beginTransaction();
        Query q = session.createQuery("delete from Course_Student where lecturer=:lec");
        q.setParameter("lec", l);
        int i = q.executeUpdate();
        t.commit();
        session.close();
    }
}
