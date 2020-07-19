package DAO;

import Bean.Campus;
import Bean.School;
import Bean.Student;
import Helper.factoryProvider;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.List;

public class CampusDAO {


    public void addCampus(Campus campus){
        Session session = factoryProvider.getFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(campus);
        t.commit();
        session.close();
    }

    public List getAllCampus(){
        Session session = factoryProvider.getFactory().openSession();

        Query q =session.createQuery("from Campus");
        List<Campus> list = q.list();
        session.close();
        return list;
    }
    public Campus selectCampusByName(String name){

        Campus campus = new Campus();

        Session session = factoryProvider.getFactory().openSession();

        Criteria c = session.createCriteria(Campus.class);
        c.add(Restrictions.like("CampName",name));
        campus = (Campus) c.uniqueResult();
        session.close();

        return campus;


    }
    public void updateCampus(Campus campus) {
        Session session = factoryProvider.getFactory().openSession();
        Transaction t = session.beginTransaction();

        session.update(campus);
        t.commit();
        session.close();
    }


}
