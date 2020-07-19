package DAO;

import Bean.Campus;
import Bean.Programme;
import Bean.School;
import Helper.factoryProvider;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.List;

public class ProgrammeDAO {
    public void addProgramme(Programme programme) {
        Session session = factoryProvider.getFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(programme);
        t.commit();
        session.close();
    }


    public void updateProgramme(Programme programme) {
        Session session = factoryProvider.getFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(programme);
        t.commit();
        session.close();
    }


    public void deleteProgramme(Programme p) {

        Session session = factoryProvider.getFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(p);
        t.commit();
        session.close();


    }


    public List getAllProgramme() {
        Session session = factoryProvider.getFactory().openSession();

        Query q = session.createQuery("from Programme");
        List<Programme> list = q.list();
        session.close();
        return list;
    }

    public Programme selectProgrammeByCode(String code) {
        Programme programme = new Programme();
        Session session = factoryProvider.getFactory().openSession();

        Criteria c = session.createCriteria(Programme.class);
        c.add(Restrictions.like("programCode", code));
        programme = (Programme) c.uniqueResult();
        session.close();

        return programme;


    }


    public Programme selectProgrammeByName(String title) {

        Programme programme = new Programme();

        Session session = factoryProvider.getFactory().openSession();

        Criteria c = session.createCriteria(Programme.class);
        c.add(Restrictions.like("programTitle", title));
        programme = (Programme) c.uniqueResult();
        session.close();

        return programme;


    }
}
