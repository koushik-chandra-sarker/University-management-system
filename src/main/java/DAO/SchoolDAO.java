package DAO;

import Bean.Campus;
import Bean.School;
import Helper.factoryProvider;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.List;

public class SchoolDAO {

    public void addSchool( School school) {
        Session session = factoryProvider.getFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(school);
        t.commit();
        session.close();
    }


    public boolean updateSchool(School school) {
        return false;
    }





    public List getAllSchool() {
        Session session = factoryProvider.getFactory().openSession();

        Query q =session.createQuery("from School");
        List<School> list = q.list();
        session.close();
        return list;
    }
    public School selectSchoolByName(String name){

        School school = new School();

        Session session = factoryProvider.getFactory().openSession();

        Criteria c = session.createCriteria(School.class);
        c.add(Restrictions.like("schoolName",name));
        school = (School) c.uniqueResult();
        session.close();

        return school;


    }
}
