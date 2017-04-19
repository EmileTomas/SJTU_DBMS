package DAO.Impl;

import DAO.MemberDao;
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

    public void delete(int memberID) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Member member = session.get(Member.class, memberID);
            if(member!=null)
                session.delete(member);
            //TODO LOG NOT FOUND
            session.getTransaction().commit();
        }catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }


    }

    public Member find(int memberID) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Member member = null;
        try {
            session.beginTransaction();
            member = session.get(Member.class, memberID);
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


    public List<Member> findAllMembers() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Member> members = null;
        try {
            session.beginTransaction();
            String hql = "from Member ";
            Query query = session.createQuery(hql);
            members = query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return members;
    }

}
