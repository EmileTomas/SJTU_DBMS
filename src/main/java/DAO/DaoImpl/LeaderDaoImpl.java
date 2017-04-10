package DAO.DaoImpl;

import DAO.LeaderDao;
import DB_model.ID_PK;
import DB_model.Leader;
import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
            String hql = "from Leader as leader where leader.id_PK=? and leader.id_PK.idNum=?";
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
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(leader);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

}
