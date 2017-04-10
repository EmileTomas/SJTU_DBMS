package DAO.DaoImpl;

import DAO.SpecialStudentDao;
import DB_model.ID;
import DB_model.SpecialStudent;
import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * Created by Administrator on 2017/4/10.
 */
public class SpecialStudentDaoImpl implements SpecialStudentDao {
    public void insert(SpecialStudent specialStudent) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(specialStudent);
        } catch (HibernateException e) {
            if (transaction == null) transaction.rollback();
            e.printStackTrace();
        } finally {
            transaction.commit();
        }
    }

    public void delete(ID specialStudentID) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            SpecialStudent specialStudent = find(specialStudentID);
            session.delete(specialStudent);
        } catch (HibernateException e) {
            if (transaction == null) transaction.rollback();
            e.printStackTrace();
        } finally {
            transaction.commit();
        }
    }

    /**
     * @param specialStudentID
     * @return if more than one instance matches LeaderID, throw exception
     */
    public SpecialStudent find(ID specialStudentID) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = null;
        SpecialStudent specialStudent = null;
        try {
            transaction = session.beginTransaction();
            String hql = "from SpecialStudent as spStu where spStu.idType=? and spStu.idNum=?";
            Query query = session.createQuery(hql)
                    .setParameter(0, specialStudentID.getIdType())
                    .setParameter(1, specialStudentID.getIdNum());
            specialStudent = (SpecialStudent) query.uniqueResult();
        } catch (HibernateException e) {
            if (transaction == null) transaction.rollback();
            e.printStackTrace();
        } finally {
            transaction.commit();
        }
        return specialStudent;
    }

    public void delete(SpecialStudent specialStudent) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(specialStudent);
        } catch (HibernateException e) {
            if (transaction == null) transaction.rollback();
            e.printStackTrace();
        } finally {
            transaction.commit();
        }
    }
}
