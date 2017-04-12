package DAO.DaoImpl;

import DAO.MemberDao;
import DB_model.module.Id_PK;
import DB_model.Student.Member;
import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

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

    public void delete(Id_PK memberID) {
        Member member = find(memberID);
        if (member != null){
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.delete(member);
            session.getTransaction().commit();
        }
    }


    /**
     * @param memberID
     * @return if more than one instance matches LeaderID, throw exception
     */
    public Member find(Id_PK memberID) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Member member = null;
        try {
            session.beginTransaction();
            String hql = "from Member as members where members.id_pk.idType=? and members.id_pk.idNum=?";
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


    public List<Member> findAllMembers(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Member> members = null;
        try {
            session.beginTransaction();
            String hql = "from Member ";
            Query query = session.createQuery(hql);
            members= query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return members;
    }

}
