package DAO.DaoImpl;

import DAO.ExpertDao;
import DB_model.Id_PK;
import DB_model.Student.Leader;
import DB_model.Teacher.Expert;
import Util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/10.
 */
public class ExpertDaoImpl implements ExpertDao {
    public void save(Expert expert) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(expert);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void delete(Id_PK ExpertID) {
        Expert expert = find(ExpertID);

        if (expert != null) {

            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            //Clear the key in leaders
            session.update(expert);                 //For lazy load
            Hibernate.initialize(expert.getLeaders());
            List<Leader> leaders = new ArrayList<Leader>(expert.getLeaders());
            if (leaders.size() != 0) {
                for (Leader leader : leaders) {
                    leader.setExpert(null);
                    session.update(leader);
                }
            }

            session.delete(expert);
            session.getTransaction().commit();
        }
    }

    public Expert find(Id_PK ExpertID) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Expert expert = null;
        try {
            session.beginTransaction();
            String hql = "from Expert as expert where expert.id_pk.idType=? and expert.id_pk.idNum=?";
            Query query = session.createQuery(hql)
                    .setParameter(0, ExpertID.getIdType())
                    .setParameter(1, ExpertID.getIdNum());
            expert = (Expert) query.uniqueResult();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return expert;
    }

    public void update(Expert expert) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.update(expert);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<Expert> findAllExperts() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Expert> experts = null;
        try {
            session.beginTransaction();
            String hql = "from Leader";
            Query query = session.createQuery(hql);
            experts = query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return experts;
    }
}
