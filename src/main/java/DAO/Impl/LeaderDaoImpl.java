package DAO.Impl;

import DAO.LeaderDao;
import DB_model.Student.Leader;
import DB_model.Student.Member;
import DB_model.Student.SpecialStudent;
import Util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
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

    public void delete(int stuID) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Leader leader = session.get(Leader.class, stuID);

            if (leader != null) {
                //Reset members foreign key
                List<Member> members = new ArrayList<Member>(leader.getMembers());
                for (Member member : members) {
                    member.setLeader(null);
                    session.update(member);

                }

                //Reset members foreign key
                Hibernate.initialize(leader.getSpecialStudents());
                List<SpecialStudent> specialStudents = new ArrayList<SpecialStudent>(leader.getSpecialStudents());
                for (SpecialStudent specialStudent : specialStudents) {
                    specialStudent.setLeader(null);
                    session.update(specialStudent);
                }
                session.delete(leader);
            }
            //TODO LOG NOT FOUND

            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public Leader find(int stuID) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Leader leader = null;
        try {
            session.beginTransaction();
            leader = session.get(Leader.class, stuID);
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

    public List<Leader> findAllLeaders() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Leader> leaders = null;
        try {
            session.beginTransaction();
            String hql = "from Leader";
            Query query = session.createQuery(hql);
            leaders = query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return leaders;
    }

}
