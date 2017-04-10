package DAO.DaoImpl;

import DAO.MemberDao;
import DB_model.ID_PK;
import DB_model.Member;
import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 * Created by Administrator on 2017/4/10.
 */
public class MemberDaoImpl implements MemberDao {
    public void save(Member member) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(member);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void delete(ID_PK memberID) {
        Member member = find(memberID);
        if (member == null) System.out.println("Empty");
        delete(member);
    }

    public void delete(Member member) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.delete(member);
        session.getTransaction().commit();

    }

    /**
     * @param memberID
     * @return if more than one instance matches LeaderID, throw exception
     */
    public Member find(ID_PK memberID) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Member member = null;
        try {
            session.beginTransaction();
            String hql = "from Member as members where members.id_PK.idType=? and members.id_PK.idNum=?";
            Query query = session.createQuery(hql)
                    .setParameter(0, memberID.getIdType())
                    .setParameter(1, memberID.getIdNum());
            member = (Member) query.uniqueResult();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return member;
    }

    public void update(Member member) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.update(member);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
