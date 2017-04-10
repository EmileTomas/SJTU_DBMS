package DAO.DaoImpl;

import DAO.LeaderDao;
import DB_model.ID_PK;
import DB_model.Student.Leader;
import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Administrator on 2017/4/9.
 */
public class LeaderDaoImpl implements LeaderDao {
    public void save(Leader leader) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(leader);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void delete(ID_PK leaderID) {
        Leader leader = find(leaderID);
        if (leader != null)
            delete(leader);
    }

    public void delete(Leader leader) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.delete(leader);
        session.getTransaction().commit();
    }


    /**
     * @param leaderID
     * @return if more than one instance matches LeaderID, throw exception
     */
    public Leader find(ID_PK leaderID) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Leader leader = null;
        try {
            session.beginTransaction();
            String hql = "from Leader as leader where leader.id_pk.idType=? and leader.id_pk.idNum=?";
            Query query = session.createQuery(hql)
                    .setParameter(0, leaderID.getIdType())
                    .setParameter(1, leaderID.getIdNum());
            leader = (Leader) query.uniqueResult();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return leader;
    }

    public void update(Leader leader) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.update(leader);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<Leader> findAllLeaders(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Leader> leaders = null;
        try {
            session.beginTransaction();
            String hql = "from Leader";
            Query query = session.createQuery(hql);
            leaders= query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return leaders;
    }

}
