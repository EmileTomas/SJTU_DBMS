package DAO.DaoImpl;

import DAO.LeaderDao;
import DB_model.ID;
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
    public void insert(Leader leader){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            session.save(leader);
        }catch (HibernateException e){
            if(transaction==null) transaction.rollback();
            e.printStackTrace();
        }finally {
            transaction.commit();
        }
    }
    public void delete(ID leaderID){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            Leader leader=find(leaderID);
            session.delete(leader);
        }catch (HibernateException e){
            if(transaction==null) transaction.rollback();
            e.printStackTrace();
        }finally {
            transaction.commit();
        }

    }

    /**
     *
     * @param leaderID
     * @return if more than one instance matches LeaderID, throw exception
     */
    public Leader find(ID leaderID){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = null;
        Leader leader = null;
        try {
            transaction = session.beginTransaction();
            String hql = "from Leader as leader where leader.idType=? and leader.idNum=?";
            Query query = session.createQuery(hql)
                    .setParameter(0, leaderID.getIdType())
                    .setParameter(1, leaderID.getIdNum());
            leader = (Leader) query.uniqueResult();
        } catch (HibernateException e) {
            if (transaction == null) transaction.rollback();
            e.printStackTrace();
        } finally {
            transaction.commit();
        }
        return leader;
    }

    public void update(Leader leader){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            session.update(leader);
        }catch (HibernateException e){
            if(transaction==null) transaction.rollback();
            e.printStackTrace();
        }finally {
            transaction.commit();
        }
    }

}
