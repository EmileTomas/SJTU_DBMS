package DAO.DaoImpl;

import DAO.MemberDao;
import DB_model.ID;
import DB_model.Member;
import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * Created by Administrator on 2017/4/10.
 */
public class MemberDaoImpl implements MemberDao {
    public void insert(Member member) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(member);
        } catch (HibernateException e) {
            if (transaction == null) transaction.rollback();
            e.printStackTrace();
        } finally {
            transaction.commit();
        }
    }

    public void delete(ID memberID) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Member member = find(memberID);
            session.delete(member);
        } catch (HibernateException e) {
            if (transaction == null) transaction.rollback();
            e.printStackTrace();
        } finally {
            transaction.commit();
        }
    }

    /**
     * @param memberID
     * @return if more than one instance matches LeaderID, throw exception
     */
    public Member find(ID memberID) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = null;
        Member member = null;
        try {
            transaction = session.beginTransaction();
            String hql = "from Member as members where members.idType=? and members.idNum=?";
            Query query = session.createQuery(hql)
                    .setParameter(0, memberID.getIdType())
                    .setParameter(1, memberID.getIdNum());
            member = (Member) query.uniqueResult();
        } catch (HibernateException e) {
            if (transaction == null) transaction.rollback();
            e.printStackTrace();
        } finally {
            transaction.commit();
        }
        return member;
    }

    public void update(Member member) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(member);
        } catch (HibernateException e) {
            if (transaction == null) transaction.rollback();
            e.printStackTrace();
        } finally {
            transaction.commit();
        }
    }
}
