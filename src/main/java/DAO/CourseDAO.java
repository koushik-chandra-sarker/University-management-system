package DAO;

import Bean.Campus;
import Bean.Course;
import Bean.Programme;
import Bean.School;
import Helper.factoryProvider;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Set;

public class CourseDAO {
    public void addCourse( Course course) {
        Session session = factoryProvider.getFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(course);
        t.commit();
        session.close();
    }


    public void updateCourse(Course course) {
       Session session = factoryProvider.getFactory().openSession();
       Transaction t = session.beginTransaction();
       session.update(course);
       t.commit();
       session.close();
    }


    public void deleteCourse(Course course) {
        Session session = factoryProvider.getFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(course);
        t.commit();
        session.close();
    }


    public List getAllCourse() {
        Session session = factoryProvider.getFactory().openSession();

        Query q =session.createQuery("from Course");
        List<Programme> list = q.list();
        session.close();
        return list;
    }
    public Course selectCourseByName(String title){

        Course course = new Course();

        Session session = factoryProvider.getFactory().openSession();

        Criteria c = session.createCriteria(Course.class);
        c.add(Restrictions.like("courseTitle",title));
        course = (Course) c.uniqueResult();
        session.close();

        return course;


    }
    public Course selectCourseByCourseCode(String code){

        Course course = new Course();

        Session session = factoryProvider.getFactory().openSession();

        Criteria c = session.createCriteria(Course.class);
        c.add(Restrictions.like("courseCode",code));
        course = (Course) c.uniqueResult();
        session.close();

        return course;


    }
}
